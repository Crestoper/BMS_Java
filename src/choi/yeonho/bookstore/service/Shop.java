package choi.yeonho.bookstore.service;

import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.presentation.Console;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : ���� �Ա�
*/

public class Shop {
	//���� ����
	public void shop(){
	Console console = new Console();
	System.out.println("���� ���� ���ϴ�");
	
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
