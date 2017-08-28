package choi.yeonho.bookstore.presentation;

import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.service.GuestImplements;
import choi.yeonho.bookstore.service.HostImplements;
import choi.yeonho.bookstore.service.Tool;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : Menu Interface 구현 Page 화면에 보이는 Menu 모음
*/


public class MenuImplements implements Menu {

	//생성자 생성
	private static HostImplements host = new HostImplements();
	private static GuestImplements guest = new GuestImplements();
	
	
	// 메뉴 접근자, 코드를 통해 접근
	@Override
	public void commonMenu(int menu) {
		switch (menu) {
		case Code.SHOP_LOGIN: // 로그인 화면으로 이동
			logInMenu();
			break;
		case Code.HOST:
			hostMenu();
			break;
		case Code.HOST_BOOK:
			hostStock();
			break;
		case Code.HOST_BOOK_LIST:
			host.hostBookList();
			break;
		case Code.HOST_BOOK_ADD:
			host.hostBookAdd();
			break;
		case Code.HOST_BOOK_UPDATE:
			host.hostBookUpdate();
			break;
		case Code.HOST_BOOK_INSERT :
			host.hostBookInsert();
			break;
		case Code.HOST_BOOK_DEL:
			host.hostBookDel();
			break;
		case Code.HOST_BOOK_BACK:

			break;
		case Code.HOST_ORDER:
			hostOrder();
			break;
		case Code.HOST_ORDER_LIST:
			host.hostOrderList();
			break;
		case Code.HOST_ORDER_CONFIRM:
			host.hostOrderConfirm();
			break;
		case Code.HOST_ORDER_CANCLE:
			host.hostOrderCancle();
			break;
		case Code.HOST_SALE_TOTAL:
			host.hostSaleTotal();
			break;
		case Code.GUEST:
			guest.guest();
			break;
		case Code.GUEST_SHOPPING:
			guestMenu();
			break;
		case Code.GUEST_CART:
			guestCartMenu();
			break;
		case Code.GUEST_CART_FOLD: // 장바구니 담기
			guest.guestCartFold();
			break;
		case Code.GUEST_CART_BUY :
			guest.guestCart();
			break;
		case Code.GUEST_BUY:
			guest.guestBuy();
			break;
		case Code.GUEST_REFUND:
			guestRefund();
			break;
		case Code.GUEST_CART_REFUND:
			guest.guestCartRefund();
			break;
		case Code.GUEST_INFO_CHANGE :
			guestInfoChange();
			break;
		case Code.DELIVERY_STATE :
			host.deliveryState();
			break;
		}
	}

	// 서점 입장 후 첫 화면. 관리자 / 구매자 메뉴를 불러오기 위해 선택. 로그인 화면으로 이동.
	@Override
	public void logInMenu() {

		System.out.println("\n=======로그인=======");
		System.out.println(" 1.관리자\n 2.구매자\n 3.종료");
		System.out.println("===================");
		System.out.print("메뉴번호를 선택하세요 ");
		
		switch (Integer.parseInt(Console.input())) { // input이 String이므로 int로
														// Casting
		case 1:
			host.hostLogIn(); // Host LogIn 화면으로
			break;
		case 2:
			commonMenu(Code.GUEST); // Guest LogIn 화면으로
			break;
		case 3:
			System.out.println("종료합니다.");
			/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
			DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
			DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());
			DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());*/
			System.exit(0);
		default:
			System.out.println("잘못 입력하셨습니다.");
			commonMenu(Code.SHOP_LOGIN);
			break;
		}
	}

	@Override
	public void hostMenu() { //관리자 기본 메뉴
		System.out.println("\n=======관리자=======");
		System.out.println(" 1.재고관리\n 2.주문관리\n 3.로그아웃");
		System.out.println("===================");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_BOOK);
			break;
		case 2:
			commonMenu(Code.HOST_ORDER);
			break;
		case 3:
			host.hostLogOut();
		default:
			System.out.println("잘못 입력하셨습니다.");
			commonMenu(Code.HOST);
		}
	}

	@Override
	public void hostStock() { //관리자 재고관리 메뉴
		System.out.println("\n======재고관리======");
		System.out.println(" 1.도서목록\n 2.도서등록\n 3.도서변경\n 4.도서추가신청\n 5.도서반품신청\n 6.이전");
		System.out.println("===================");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_BOOK_LIST);
			break;
		case 2:
			commonMenu(Code.HOST_BOOK_ADD);
			break;
		case 3:
			commonMenu(Code.HOST_BOOK_UPDATE);
			break;
		case 4:
			commonMenu(Code.HOST_BOOK_INSERT);
			break;
		case 5:
			commonMenu(Code.HOST_BOOK_DEL);
			break;
		case 6:
			System.out.println("이전 메뉴로 돌아갑니다..");
			commonMenu(Code.HOST);
		default:
			System.out.println("잘못입력하셨습니다.");
			commonMenu(Code.HOST_BOOK);
		}
	}

	public void hostOrder() { //관리자 주문관리 메뉴
		System.out.println("\n======주문관리======"); 
		System.out.println(" 1.주문조회\n 2.구매승인\n 3.환불승인\n 4.결산\n 5.이전");
		System.out.println("===================");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_ORDER_LIST);
			break;
		case 2:
			commonMenu(Code.HOST_ORDER_CONFIRM);
			break;
		case 3:
			commonMenu(Code.HOST_ORDER_CANCLE);
			break;
		case 4:
			commonMenu(Code.HOST_SALE_TOTAL);
			break;
		case 5:
			System.out.println("이전 메뉴로 돌아갑니다..");
			commonMenu(Code.HOST);
		default:
			System.out.println("잘못입력하셨습니다.");
			commonMenu(Code.HOST_ORDER);

		}
	}

	@Override
	public void guestMenu() { //구매자 기본 메뉴
		System.out.println("\n=======구매자=======");
		System.out.println(" 1.장바구니\n 2.바로구매\n 3.환불\n 4.정보변경\n 5.배송정보\n 6.이전");
		System.out.println("===================");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.GUEST_CART);
			break;
		case 2:
			commonMenu(Code.GUEST_BUY);
			break;
		case 3:
			commonMenu(Code.GUEST_REFUND);
			break;
		case 4 :
			commonMenu(Code.GUEST_INFO_CHANGE);
			break;
		case 5:
			commonMenu(Code.DELIVERY_STATE);
			break;
		case 6:
			commonMenu(Code.SHOP_LOGIN);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			commonMenu(Code.GUEST_SHOPPING);
		}
	}

	@Override
	public void guestBuyMenu() { //구매자 
		Tool.menu("도서목록");
		Tool.getBookInfo();
		System.out.println(" 1.결제\n 2.취소\n 3.이전");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.GUEST_BUY);
			break;// 결제
		case 2:
			commonMenu(Code.GUEST_REFUND);
			break; // 취소
		case 3:
			commonMenu(Code.GUEST_SHOPPING);
			break; // 전 메뉴
		default:
			System.out.println("잘못 입력하셨습니다.");
			commonMenu(Code.GUEST_SHOPPING);
		}

	}

	@Override
	public void guestCartMenu() { //구매자 장바구니 메뉴
		Tool.menu("장바구니");
		Tool.getShelfBookInfo();
		System.out.println(" 1.결제\n 2.담기\n 3.취소\n 4.이전");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1: 
			commonMenu(Code.GUEST_CART_BUY);
			break;
		case 2:
			commonMenu(Code.GUEST_CART_FOLD);
			break;

		case 3:
			commonMenu(Code.GUEST_CART_REFUND);
			break; // 취소
		case 4:
			commonMenu(Code.GUEST_SHOPPING);
			break; // 전 메뉴
		default:
			System.out.println("잘못 입력하셨습니다.");
			commonMenu(Code.GUEST_CART);
		}
	}

	@Override
	public void guestRefund() {//구매자 환불 메뉴
		guest.guestRefund();
	}

	@Override
	public void guestInfoChange() {
		System.out.println("\n======정보변경======");
		System.out.println(" 1.비밀번호 변경\n 2.주소 변경\n 3.연락처 변경\n 4.이전");
		System.out.println("===================");
		System.out.print("메뉴번호를 입력하세요. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			guest.guestChangePW();
			break;
		case 2:
			guest.guestChangeAddress();
			break;
		case 3:
			guest.guestChangeContact();
			break;
		case 4:
			commonMenu(Code.GUEST_SHOPPING);
			break;
		}
	}
}