package choi.yeonho.bookstore.presentation;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : Menu 관련 기능 정의서 Interface
*/

public interface Menu {
	
	//메뉴공통
	public void commonMenu(int menu); //메뉴 접근자, 코드를 통해 접근
	
	//로그인메뉴
	public void logInMenu();
	
	//관리자메뉴
	public void hostMenu();
	
	//제고관리 매뉴
	public void hostStock();
	
	//손님 메뉴
	public void guestMenu();
	
	//손님 세부메뉴
	public void guestBuyMenu();  //바로 구매
	
	public void guestCartMenu(); //카트 구매
	
	public void guestRefund();  //환불
	
	public void guestInfoChange(); //정보변경
}
