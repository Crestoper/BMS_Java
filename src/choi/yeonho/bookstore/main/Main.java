package choi.yeonho.bookstore.main;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.service.Shop;
import choi.yeonho.bookstore.service.Tool;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : 서점 관리 시스템  
*/

public class Main {
	static String version = "01";
		
	/*public static final String BOOK_DB  = "bookDB" + version;
	public static final String ORDER_DB = "orderDB" + version;
	public static final String GUEST_DB = "guestDB" + version;
	public static final String DELIVERY_DB = "deliveryDB" + version;
		
	public static final String PATH = "C:\\DEV\\WorkSpace\\Project\\";*/
	
	public static void main(String[] args){
		
		Shop s = new Shop();
		s.shop();
	}

}
