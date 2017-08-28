package choi.yeonho.bookstore.service;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : Host 관련 기능 정의서 Interface
*/


public interface Host {
	
	public static String ID = "HOST"; //Host Id
	public static String PW = "HOST"; //Host Pw
	
	public void hostLogIn();		//로그인
	public void hostLogOut();		//로그아웃
	public void hostBookList(); 	//도서목록 조회
	public void hostBookAdd();		//도서 신규 등록
	public void hostBookUpdate();	// 도서 수정
	public void hostBookInsert();	//도서 수량 증가
	public void hostBookDel();   	//도서 수량 감소
	public void hostOrderList();	//구매 승인 대기 목록
	public void hostOrderConfirm(); //구매 승인
	public void hostOrderCancle();	//환불 승인
	public void hostSaleTotal();	//결산
	public void deliveryState();	//배송정보

}
