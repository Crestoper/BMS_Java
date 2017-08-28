package choi.yeonho.bookstore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Order;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.presentation.Console;
import choi.yeonho.bookstore.presentation.MenuImplements;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : Guest Interface Implements Page 고객 관련 Method
*/

public class GuestImplements implements GuestPre {

	//손님 관련 행동들 정의	

	@Override
	public void guest() { // 로그인 todo 1.로그인 2. 가입으로 바꾸기
		System.out.println("\n=======Guest=======");
		System.out.println(" 1.로그인\n 2.회원가입\n 3.이전");
		System.out.println("===================");
		System.out.print("메뉴번호를 선택하세요 ");
	
		switch (Integer.parseInt(Console.input())) {
		case 1:
			guestLogIn();
			break;
		case 2:
			guestJoin();
			break;
		case 3:
			Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			guest();
		}
	}
		
	@Override
	public void guestJoin(){ 
		System.out.println("가입하실 아이디를 입력하시오.");
		String ID = Console.input();
		System.out.println("비밀번호를 입력하시오.");
		String PW = Console.input();
		System.out.println("성명를 입력하시오.");
		String name = Console.input();
		System.out.println("주소를 입력하시오.");
		String address = Console.input();
		System.out.println("연락처를 입력하시오.");
		String contact = Console.input();
		
		
	
		Tool.guestGetInstance().guestMap.put(ID, new Guest(PW, name,address,contact));
		
		System.out.println("ID   : " + ID);
		System.out.println("PW   : " + PW);
		System.out.println("성명   : " + name);
		System.out.println("주소   : " + address);
		System.out.println("연락처 : " + contact);
		System.out.println("회원가입 하셨습니다.");
		/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		guest();
		
	}

	@Override
	public void guestLogIn() { // 로그인
		String pw;

		System.out.print("아이디를 입력하세요.");
		String id = Console.input();

		// ID판별
		if (Tool.guestGetInstance().guestMap.containsKey(id)) { // todo hash table 만들어서 ID PW 관리하기
			System.out.print("비밀번호를 입력하세요.");
			pw = Console.input();

			// PW 판별
			if (pw.equals(Tool.guestGetInstance().guestMap.get(id).getGuestPW())) {
				System.out.println("로그인되었습니다.");
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

			} else {
				System.out.println("비밀번호가 틀렸습니다.");
				Tool.consoleGetInstance().logInMenu();
			}

		} else {
			System.out.println("잘못 입력하셨습니다.");
			Tool.consoleGetInstance().logInMenu();
		}
	}

	@Override
	public void guestLogOut() { // 로그아웃
		System.out.println("종료되었습니다.");
		Tool.consoleGetInstance().logInMenu();
		Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
	}

	@Override
	public void guestBuy() { // 즉시구매 map에서 orderMap으로 자료 이동
		// map에 있는 재고 목록
		Tool.menu("도서목록");
		Tool.getBookInfo();

		System.out.println("구매하실 책의 번호를 입력하시오. [이전 메뉴 : 0]");
		try {
			int num = Integer.parseInt(Console.input());

			// 0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

			}
			// 입력한 책의 번호에 자료 유무 확인
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				guestBuy();
			}

			System.out.println("책의 수량을 입력하시오.");
			int count = Integer.parseInt(Console.input());

			// 입력한 Count와 map의 Count 비교
			if ((Tool.bookGetInstance().map.get(num).getCount() - count) < 0) {
				System.out.println("수량이 부족합니다.");
				guestBuy();
			} else {
				// map에서 제고 감소
				Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);

				// orderMap에 자료가 있는 경우 Count+
				if (Tool.orderGetInstance().orderMap.containsKey(num)) {
					Tool.orderGetInstance().orderMap.get(num).setCount(Tool.orderGetInstance().orderMap.get(num).getCount() + count);
					Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_POSSIBLE);
					Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
					Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);

					// orderMap에 자료가 없는 경우 정보 입력
				} else {
					Tool.orderGetInstance().orderMap.put(num,
							new Order(Tool.bookGetInstance().map.get(num).getBookName(), Tool.bookGetInstance().map.get(num).getAhthor(),
									Tool.bookGetInstance().map.get(num).getPrice(), count, Code.ORDERCONFIRM_POSSIBLE,
									Code.ORDERCANCLE_IMPOSSIBLE, Code.ORDERCANCLE_STATE_NOMAL));
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println(Tool.bookGetInstance().map.get(num).getBookName() + " 구매되었습니다.");
			}

		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
			guestBuy();
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_BUY);
	}

	@Override
	public void guestCart() { // 장바구니에 있는 책 일괄 결제 shelfMap에서 orderMap으로 자료 이동
		Tool.menu("장바구니");
		Tool.getShelfBookInfo();

		System.out.println("결제 하시겠습니까? Y or N");
		String choice = Console.input();

		if (choice.equals("Y") || choice.equals("y")) {

			// shelfMap에 있는 모든 자료 불러오기 위해 for - each문 사용  todo 수정
			for (Entry<Integer, Book> shelf : Tool.bookGetInstance().shelfMap.entrySet()) {
				int key = shelf.getKey();
				String bookName = shelf.getValue().getBookName();
				String arthor = shelf.getValue().getAhthor();
				int price = shelf.getValue().getPrice();
				int count = shelf.getValue().getCount();

				// orderMap에 자료가 있는 경우 Count+
				if (Tool.orderGetInstance().orderMap.containsKey(key)) {
					Tool.orderGetInstance().orderMap.get(key).setCount(Tool.orderGetInstance().orderMap.get(key).getCount() + count);
					Tool.orderGetInstance().orderMap.get(key).setSell(Code.ORDERCONFIRM_POSSIBLE);
					Tool.orderGetInstance().orderMap.get(key).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
					Tool.orderGetInstance().orderMap.get(key).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);

					// orderMap에 자료가 없는 경우 정보 입력
				} else {
					Tool.orderGetInstance().orderMap.put(key, new Order(bookName, arthor, price, count, Code.ORDERCONFIRM_POSSIBLE,
							Code.ORDERCANCLE_IMPOSSIBLE, Code.ORDERCANCLE_STATE_NOMAL));

				}
			/*	DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println(bookName + " 결제되었습니다.");
				// orderMap으로 Count를 이동시켜서 중복을 막기 위해 shelfMap에 있는 Chount 0올 설정
				Tool.bookGetInstance().shelfMap.get(key).setCount(0);
			}
		} else if (choice.equals("N") || choice.equals("n")) {
			System.out.println("취소하셨습니다.");
			Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
		} else {
			System.out.println("잘못 입력하셨습니다.");
			guestCart();
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
	}

	@Override
	public void guestCartFold() { // 장바구니에 책 담기 map에서 shelfMap으로 자료 이동
		Tool.menu("도서목록");
		Tool.getBookInfo();

		System.out.println("구매하실 책의 번호를 입력하시오. [이전메뉴 : 0]");

		try {
			int num = Integer.parseInt(Console.input());

			// 0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().guestCartMenu();
			}

			// 입력한 책의 번호에 자료 유무 확인
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				guestCartFold();
			}
						
			System.out.println("책의 수량을 입력하시오.");
			int count = Integer.parseInt(Console.input());

			// 입력한 Count와 map의 Count 비교
			if ((Tool.bookGetInstance().map.get(num).getCount() - count) < 0) {
				System.out.println("수량이 부족합니다.");
				guestCartFold();
			} else {

				// orderMap으로 Count를 이동시켜서 중복을 막기 위해 map에 있는 Chount- 설정
				Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);

				// shelfMap에 자료가 있는 경우 Count+
				if (Tool.bookGetInstance().shelfMap.containsKey(num)) {
					Tool.bookGetInstance().shelfMap.get(num).setCount(Tool.bookGetInstance().shelfMap.get(num).getCount() + count);

					// shelfMap에 자료가 없는 경우 정보 입력
				} else {
					Tool.bookGetInstance().shelfMap.put(num, new Book(Tool.bookGetInstance().map.get(num).getBookName(), Tool.bookGetInstance().map.get(num).getAhthor(),
							Tool.bookGetInstance().map.get(num).getPrice(), count));
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println("장바구니에 담았습니다.");
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
			guestCartFold();
		}
		guestCartFold();
	}

	@Override
	public void guestCartRefund() {// 장바구니에 있는 책 취소 shelfMap에서 map으로 이동
		Tool.menu("장바구니");
		Tool.getShelfBookInfo();

		System.out.println("취소하실 책의 번호를 입력하시오. [이전 메뉴 : 0] ");
		try {
			int num = Integer.parseInt(Console.input());

			// 0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
			}

			// 입력한 책의 번호에 자료 유무 확인
			if (!Tool.bookGetInstance().shelfMap.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				guestCartRefund();
			}

			System.out.println("책의 수량을 입력하시오.");
			int count = Integer.parseInt(Console.input());

			// 입력한 Count와 shelfMap의 Count 비교
			if ((Tool.bookGetInstance().shelfMap.get(num).getCount() - count) < 0) {
				System.out.println("수량이 부족합니다.");
				guestCartRefund();

			} else {
				// map으로 Count를 이동시켜서 중복을 막기 위해 shelfMap에 있는 Chount- 설정
				Tool.bookGetInstance().shelfMap.get(num).setCount(Tool.bookGetInstance().shelfMap.get(num).getCount() - count);

				// map에 자료가 없는 경우 정보 입력
				if (Tool.bookGetInstance().map.containsKey(num)) {
					Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + count);

					// map에 자료가 있는 경우 Count+
				} else {
					Tool.bookGetInstance().map.get(num).setCount(count);
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
			}
			System.out.println("취소되었습니다.");
		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
			guestCartRefund();
		}
		guestCartRefund();
	}

	@Override
	public void guestRefund() { // 환불 메뉴 관리자가 구매 승인 한 책 환불 신청 메뉴 Refund =
								// ORDERCANCLE_POSSIBLE),RefundState =
								// ORDERCANCLE_STATE_CALLING가 됨
			
		System.out.println("=================================구매목록==================================");
		System.out.println("코드\t도서명\t\t저자\t\t가격\t\t수량\t환불신청여부");
		System.out.println("------------------------------------------------------------------------");

		Tool.getOrderBookInfo();

		System.out.println("환불하실 책의 번호를 입력하시오. [이전 메뉴 : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			// 0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

				// 입력한 책의 번호에 자료 유무 확인
			} else if (!Tool.orderGetInstance().orderMap.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");

				// 입력한 책의 번호의 환불 신청 여부 확인
			} else if (Tool.orderGetInstance().orderMap.get(num).getSell() == 0) {
				System.out.println("잘못 입력하셨습니다.");
				
			}else if(Tool.deliveryGetInstance().deliveryList.get(num).getDeliverySate() == 1 ||Tool.deliveryGetInstance().deliveryList.get(num).getDeliverySate() == 2){
					System.out.println("이미 배송 중입니다.");
					 guestCartFold();
			}else {
				Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_POSSIBLE); 
				Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_POSSIBLE); 
				Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_CALLING); 
																						
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println("환불 신청 되었습니다.");
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
		}
		guestRefund();
	}

	@Override
	public void guestChangePW() { //비밀번호 변경
		System.out.println("개인정보 확인을 위해 ID를 입력하시오.");
		String ID = Console.input();

		if (Tool.guestGetInstance().guestMap.containsKey(ID)) {
			System.out.println("현재 비밀번호를 입력하시오.");
			String PW = Console.input();
			
			if (Tool.guestGetInstance().guestMap.get(ID).getGuestPW().equals(PW)) {
				System.out.println("새 비밀번호를 입력하시오.");
				PW = Console.input();
				
				System.out.println("다시 한번 입력하시오.");
				String PW2 = Console.input();
				
				while (!PW.equals(PW2)) {
					System.out.println("잘못 입력하셨습니다. 다시 입력하시오. [이전 메뉴 : 0]");
				
					// 0 입력시 이전 메뉴로
					if (PW2 == "0") {
						
						break;
					}
				}
				Tool.guestGetInstance().guestMap.get(ID).setGuestPW(PW);
				/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
				System.out.println("비밀번호가 " + PW + "로 변경되었습니다.");
				Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
				guestChangePW();
			}
		} else {
			System.out.println("ID를 잘못 입력하셨습니다.");
			guestChangePW();
		}
	}

	@Override
	public void guestChangeAddress() {
		System.out.println("ID를 입력하시오.");
		String ID = Console.input();
		
		System.out.println("변경하실 주소를 입력하시오.");
		String address = Console.input();
		
		System.out.println("변경하실 주소가" + "\n 맞습니까? [Y/N]");
		String YN = Console.input();
		
		if(YN.equals("Y")||YN.equals("y")){
			System.out.println("주소가 " + address + "로 변경되었습니다.");
			Tool.guestGetInstance().guestMap.get(ID).setGuestAddress(address);
			/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		
		}else if(YN.equals("N")||YN.equals("n")){
			System.out.println("취소하셨습니다.");

		}else{
			System.out.println("잘못 입력하셨습니다.");
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
	}

	@Override
	public void guestChangeContact() {
		System.out.println("ID를 입력하시오.");
		String ID = Console.input();
		
		System.out.println("변경하실 연락처를 입력하시오.");
		String address = Console.input();
		
		System.out.println("변경하실 연락처가" + "\n 맞습니까?");
		String YN = Console.input();
		
		if(YN.equals("Y")||YN.equals("y")){
			Tool.guestGetInstance().guestMap.get(ID).setGuestContact(address);
			/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		
		}else if(YN.equals("N")||YN.equals("n")){
			System.out.println("취소하셨습니다.");

		}else{
			System.out.println("잘못 입력하셨습니다.");
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
	}
}
