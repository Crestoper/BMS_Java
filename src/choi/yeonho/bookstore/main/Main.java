package choi.yeonho.bookstore.main;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.service.Shop;
import choi.yeonho.bookstore.service.Tool;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : ���� ���� �ý���  
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
