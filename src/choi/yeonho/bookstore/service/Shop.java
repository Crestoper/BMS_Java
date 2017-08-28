package choi.yeonho.bookstore.service;

import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.presentation.Console;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : 서점 입구
*/

public class Shop {
	//서점 정문
	public void shop(){
	Console console = new Console();
	System.out.println("서점 문을 엽니다");
	
	initialization();
	
	console.logInMenu();
	}
	
	public void initialization() {
		
		/*if(!DBIO.checkFile(Main.PATH, Main.BOOK_DB))	DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		if(!DBIO.checkFile(Main.PATH, Main.ORDER_DB))	DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
		if(!DBIO.checkFile(Main.PATH, Main.GUEST_DB))	DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());
		if(!DBIO.checkFile(Main.PATH, Main.DELIVERY_DB))	DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());
		
		Tool.setBook(DBIO.loadDB(Main.BOOK_DB));
		Tool.setOrder(DBIO.loadDB(Main.ORDER_DB));
		Tool.setGuest(DBIO.loadDB(Main.GUEST_DB));
		Tool.setDelivery(DBIO.loadDB(Main.DELIVERY_DB));*/
	}
}
