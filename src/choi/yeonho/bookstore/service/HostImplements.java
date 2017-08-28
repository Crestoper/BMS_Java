package choi.yeonho.bookstore.service;

import java.util.Map;
import java.util.Random;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Delivery;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.domain.Order;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.presentation.Console;
import choi.yeonho.bookstore.presentation.MenuImplements;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : Host Interface Implements Page 관리자 관련 Method
*/


public final class HostImplements implements Host {

	

	@Override
	public void hostLogIn() { //로그인
		String id, pw;

		System.out.print("\n아이디를 입력하세요.");
		id = Console.input();

		// ID판별
		if (id.equals(ID)) {
			System.out.print("비밀번호를 입력하세요.");
			pw = Console.input();
			// PW 판별
			if (pw.equals(PW)) {
				System.out.println("\n관리자로 로그인되었습니다.");
				Tool.consoleGetInstance().commonMenu(Code.HOST);// 관리자 화면으로
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
				Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
			}

		} else {
			System.out.println("잘못 입력하셨습니다.");
			Tool.consoleGetInstance().logInMenu();
		}

	}

	
	
	@Override
	public void hostLogOut() { //로그아웃
		System.out.println("로그아웃 되었습니다.");
		Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
	}

	@Override
	public void hostBookList() {
		Tool.menu("책  목록");
		Tool.getBookInfo();
		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
	}

	@Override
	public void hostBookAdd() { //도서 정보 신규 등록
		try {
			int num = (int) (Math.random()*9999);
			System.out.println("도서번호는 " + num + "입니다.");
			
			if(Tool.bookGetInstance().map.containsKey(num)){
				hostBookAdd();
			}
			System.out.print("책 제목을 입력하시오. ");
			String bookName = Console.input();

			System.out.print("책 저자를 입력하시오. ");
			String ahthor = Console.input();

			System.out.print("책 가격을 입력하시오. ");
			int price = Integer.parseInt(Console.input());

			System.out.print("책 수량을 입력하시오. ");
			int count = Integer.parseInt(Console.input());

			Tool.bookGetInstance().map.put(num, new Book(bookName, ahthor, price, count));
			
			/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
			DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
			
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다,");
			hostBookAdd();
		}
		System.out.println("추가되었습니다.");

		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);

	}

	@Override
	public void hostBookUpdate() { //등록된 도서 정보 수정 - 수량은 불가
		System.out.print("수정 할 책 등록 번호를 입력하시오. ");
		try {
			int num = Integer.parseInt(Console.input());
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				hostBookUpdate();
			}

			System.out.print("책 제목을 입력하시오. ");
			String bookName = Console.input();

			System.out.print("책 저자를 입력하시오. ");
			String ahthor = Console.input();

			System.out.print("책 가격을 입력하시오. ");
			int price = Integer.parseInt(Console.input());

			Tool.bookGetInstance().map.put(num, new Book(bookName, ahthor, price, Tool.bookGetInstance().map.get(num).getCount()));
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			hostBookUpdate();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("수정되었습니다.");

		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
	}

	@Override
	public void hostBookInsert() { //등록된 도서 수량 증가
		Tool.menu("책  목록");
		Tool.getBookInfo();

		System.out.print("추가 주문할 책 등록 번호를 입력하시오. [이전 메뉴 : 0]"); 
		try {
			int num = Integer.parseInt(Console.input());
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			System.out.println("추가 주문할 수량을 입력하시오. [이전 메뉴 : 0]");
			int count = Integer.parseInt(Console.input());
			if (count == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				hostBookInsert();
			}
			Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + count);
		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
			hostBookInsert();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("추가되었습니다.");

		hostBookInsert();
		
	}
	@Override
	public void hostBookDel() { //등록된 도서 수량 감소
		Tool.menu("책  목록");
		Tool.getBookInfo();

		System.out.print("반품할 책 등록 번호를 입력하시오. [이전 메뉴 : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			//0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			System.out.println("반품하실 수량을 입력하시오. [이전 메뉴 : 0]");
			int count = Integer.parseInt(Console.input());
			
			//입력한 Count와 map의 Count 비교
			if (Tool.bookGetInstance().map.get(num).getCount() < count){
				System.out.println("수량이 부족합니다.");
				hostBookDel();
			}
			
			//0 입력시 이전 메뉴로
			if (count == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			
			//map에 자료 유무 확인
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("잘못 입력하셨습니다.");
				hostBookDel();
			}
			
			//map의 Count에서 입력한 Count만큼 감소
			Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);
		
		} catch (Exception e) {
			System.out.println("숫자를 입력하시오.");
			hostBookDel();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("반품되었습니다.");
		hostBookDel();
	}

	@Override
	public void hostOrderList() { //구매 승인 대기 목록
		Tool.menu("주문목록");		
		Tool.getOrderBookInfo();

		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
	}

	@Override
	public void hostOrderConfirm() { //구매 승인 
		Tool.menu("요청목록");
		Tool.getOrderBookInfo();

		System.out.println("결제 하시겠습니까? Y or N");
		String choice = Console.input();

		if (choice.equals("Y") || choice.equals("y")) {
			
			//orderMap에 있는 모든 자료 불러오기 위해 for - each문 사용
			for (Map.Entry<Integer, Order> order : Tool.orderGetInstance().orderMap.entrySet()) {
				int key = order.getKey();
				String bookName = order.getValue().getBookName();
				String arthor = order.getValue().getAhthor();
				int price = order.getValue().getPrice();
				int count = order.getValue().getCount();
				int sell = order.getValue().getSell();
				int refund = order.getValue().getRefund();
				if (sell == 1 || refund == 0) {
					Tool.orderGetInstance().hostSaleTotal += (price * count);

					Tool.orderGetInstance().orderMap.get(key).setCount(count);
					Tool.orderGetInstance().orderMap.get(key).setSell(Code.ORDERCONFIRM_POSSIBLE); //구매승인 o
					Tool.orderGetInstance().orderMap.get(key).setRefund(Code.ORDERCANCLE_POSSIBLE);//환불신청 가능
							
				int oderNumber = (int) (Math.random() * 9999);
				Tool.deliveryGetInstance().deliveryList.put(oderNumber, new Delivery(key, count, Code.DELIVERY_STATE_READY));

				} else {
					continue;
				}

				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
				DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());*/
				
				System.out.println(bookName + " 승인되었습니다.");
			}
		} else if (choice.equals("N") || choice.equals("n")) {
			Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
		} else {
			System.out.println("잘못 입력하셨습니다.");
			hostOrderConfirm();
		}
		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);

	}

	@Override //
	public void hostOrderCancle() { //환불 결재
		System.out.println("=================================취소목록==================================");
		System.out.println("코드\t도서명\t\t저자\t\t가격\t\t수량\t환불신청여부");
		System.out.println("------------------------------------------------------------------------");
		Tool.getOrderRefundBookInfo();

		System.out.println("취소하실 책의 번호를 입력하시오. [이전 메뉴 : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			//0 입력시 이전 메뉴로
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
			}

			//입력한 책의 번호에 자료 유무 확인 + 환불신청 확인
			if (!Tool.orderGetInstance().orderMap.containsKey(num) || Tool.orderGetInstance().orderMap.get(num).getRefund() == Code.ORDERCANCLE_IMPOSSIBLE) {
				System.out.println("잘못 입력하셨습니다.");
				hostOrderCancle();
					
			} else {
				//map에 자료가 있으면 orderMap에 있는 Count와 map에 있는 Count +
				if (Tool.bookGetInstance().map.containsKey(num)) {
					Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + Tool.orderGetInstance().orderMap.get(num).getCount());
							
				//map에 자료가 없으면 oderMap Count를 map Count에 입력
				} else {
					Tool.bookGetInstance().map.get(num).setCount(Tool.orderGetInstance().orderMap.get(num).getCount());
				}
				int price = Tool.orderGetInstance().orderMap.get(num).getPrice();
				int count = Tool.orderGetInstance().orderMap.get(num).getCount();
				Tool.orderGetInstance().hostSaleTotal -= (price * count); //환불 금액 결산에서 -
				}
				
				//상태 reset
			Tool.orderGetInstance().orderMap.get(num).setCount(0);
				Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_IMPOSSIBLE);
				Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
				Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);
				
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				
				System.out.println(Tool.bookGetInstance().map.get(num).getBookName() + " 취소되었습니다.");

		}catch(

	Exception e)
	{
		System.out.println("숫자를 입력하시오.");
		hostOrderCancle();
	}
		hostOrderCancle();
	}

	@Override
	public void hostSaleTotal() { //결산금액 출력
		System.out.printf("결산 금액은 %,d원 입니다.\n", Tool.orderGetInstance().hostSaleTotal);
		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
	}



	@Override
	public void deliveryState() {
		System.out.println("=============배송현황=============");
		System.out.println(" 주문번호\t도서번호\t수량\t배송상태");
		System.out.println("--------------------------------");
		Tool.getDeliveryInfo();
		System.out.println("================================");
		
		Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);	
	}
}
