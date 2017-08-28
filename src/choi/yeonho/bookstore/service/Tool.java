package choi.yeonho.bookstore.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Delivery;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.domain.Order;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.presentation.Console;

public class Tool {

	
	public static void menu(String name){
	System.out.println("============================"+name+"=============================");
	System.out.println("�ڵ�\t������\t\t����\t\t����\t\t����");
	System.out.println("--------------------------------------------------------------");
	}
		
	public static void line(){
	System.out.println("==============================================================");
	}
	
	//å ���� ���
	public static void getBookInfo(){
		for(Map.Entry<Integer, Book> m : Tool.bookGetInstance().map.entrySet()){
			System.out.print(m.getKey()+"\t");
			System.out.print(m.getValue().getBookName()+"\t");
			System.out.print(m.getValue().getAhthor()+"\t");
			System.out.printf("%,d��",m.getValue().getPrice());
			System.out.printf("\t\t%,d��\n", m.getValue().getCount());
		}
		line();
	}
	//��ٱ��� å ���� ���	
	public static void getShelfBookInfo(){ //todo ����
		for(Map.Entry<Integer, Book> m : Tool.bookGetInstance().shelfMap.entrySet()){
			System.out.print(m.getKey()+"\t");
			System.out.print(m.getValue().getBookName()+"\t");
			System.out.print(m.getValue().getAhthor()+"\t");
			System.out.printf("%,d��",m.getValue().getPrice());
			System.out.printf("\t\t%,d��\n", m.getValue().getCount());
		}
		Tool.line();
	}
	
	// ���Ž�û �� å�� �ҷ���
		public static void getOrderBookInfo() {
			for (Map.Entry<Integer, Order> m : Tool.orderGetInstance().orderMap.entrySet()) {
				int sell = m.getValue().getSell();
				int refund = m.getValue().getRefund();
				if (sell == Code.ORDERCONFIRM_POSSIBLE && refund == Code.ORDERCANCLE_IMPOSSIBLE) {
					System.out.print(m.getKey() + "\t");
					System.out.print(m.getValue().getBookName() + "\t");
					System.out.print(m.getValue().getAhthor() + "\t");
					System.out.printf("%,d��", m.getValue().getPrice());
					System.out.printf("\t\t%,d��\n", m.getValue().getCount());
				} else {
				continue;
				}
			}
			line();
		}
		
		//ȯ�� ��û �� å�� �ҷ���
		public static void getOrderRefundBookInfo(){
			for (Map.Entry<Integer, Order> m : Tool.orderGetInstance().orderMap.entrySet()) {
				int refund = m.getValue().getRefund(); 
				if (refund == Code.ORDERCANCLE_POSSIBLE) {
					System.out.print(m.getKey() + "\t");
					System.out.print(m.getValue().getBookName() + "\t");
					System.out.print(m.getValue().getAhthor() + "\t");
					System.out.printf("%,d��", m.getValue().getPrice());
					System.out.printf("\t\t%,d��\t", m.getValue().getCount());
					System.out.println(m.getValue().getRefundState());
				} else {
					
					continue;
				}
			}
			System.out.println("========================================================================");
		}
		
	//������� todo
	public static void getDeliveryInfo() {
		for(Map.Entry<Integer, Delivery> m : Tool.deliveryGetInstance().deliveryList.entrySet()){
			int key = m.getKey();
			int bookNumber = m.getValue().getBookNumber();
			int count = m.getValue().getCount();
			int deliveryState = m.getValue().getDeliverySate();
			String address = m.getValue().getAddress();
			
			
			System.out.print(" " + key + "\t" + bookNumber + "\t" + count + "\t");
			if(deliveryState  == 0){
				System.out.println("�غ��� ");
			}else if(deliveryState  == 1){
				System.out.println("�߼ۿϷ�");
			}else if(deliveryState  == 2){
				System.out.println("��ۿϷ�");
			}
		}
	}
		
		// SingleTon ���� ���� private�� ������ ����
		private static Console console = new Console();

		// SingleTon Method
		public static Console consoleGetInstance() {
			if (console == null) {
				console = new Console();
			}
			return console;
		}
		
		private static Book book = new Book();

		// SingleTon Method
		public synchronized static Book bookGetInstance() {
			if (book == null) {
				book = new Book();
			}
			return book;
		}
		
		public synchronized static void setBook(Object object) {
			Tool.book = (Book) object;
		}
				
		private static Order order = new Order();

		// SingleTon Method
		public synchronized static Order orderGetInstance() {
			if (order == null) {
				order = new Order();
			}
			return order;
		}
		
		public synchronized static void setOrder(Object object) {
			Tool.order = (Order) object;
		}
		
		private static Guest guest = new Guest();

		// SingleTon Method
		public synchronized static Guest guestGetInstance() {
			if (guest == null) {
				guest = new Guest();
			}
			
			return guest;
		}
		
		public synchronized static void setGuest(Object object) {
			Tool.guest = (Guest) object;
		}

		private static Delivery delivery = new Delivery();

		// SingleTon Method
		public synchronized static Delivery deliveryGetInstance() {
			if (delivery == null) {
				delivery = new Delivery();
			}
			return delivery;
		}
		
		public synchronized static void setDelivery(Object object) {
			Tool.delivery = (Delivery) object;
		}
		
}

/*�޼ҵ� �Ʒ����� ����
DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());
DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());
*/

