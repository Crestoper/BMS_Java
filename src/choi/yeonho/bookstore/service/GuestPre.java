package choi.yeonho.bookstore.service;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : 고객 관련 기능정의서 Interface
*/


public interface GuestPre {

	public void guest();			//guest 기본메뉴
	public void guestJoin();		//회원가입
	public void guestLogIn(); 		//Guest LogIn Menu
	public void guestLogOut();		//Guest LogOut Menu
	public void guestBuy();			//즉시구매
	public void guestCart();		//카트에 담긴 책 결제
	public void guestCartFold();	//카트에 책 담기
	public void guestCartRefund();	//카트에 담긴 책 비우기
	public void guestRefund();		//구매 한 책 환불
	public void guestChangePW();	//PW변경
	public void guestChangeAddress();//주소변경
	public void guestChangeContact();//연락처변경
	
	
	
}
