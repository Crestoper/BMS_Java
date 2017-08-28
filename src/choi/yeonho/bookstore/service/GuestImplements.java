package choi.yeonho.bookstore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Order;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.presentation.Console;
import choi.yeonho.bookstore.presentation.MenuImplements;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : Guest Interface Implements Page �� ���� Method
*/

public class GuestImplements implements GuestPre {

	//�մ� ���� �ൿ�� ����	

	@Override
	public void guest() { // �α��� todo 1.�α��� 2. �������� �ٲٱ�
		System.out.println("\n=======Guest=======");
		System.out.println(" 1.�α���\n 2.ȸ������\n 3.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �����ϼ��� ");
	
		switch (Integer.parseInt(Console.input())) {
		case 1:
			guestLogIn();
			break;
		case 2:
			guestJoin();
			break;
		case 3:
			Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			guest();
		}
	}
		
	@Override
	public void guestJoin(){ 
		System.out.println("�����Ͻ� ���̵� �Է��Ͻÿ�.");
		String ID = Console.input();
		System.out.println("��й�ȣ�� �Է��Ͻÿ�.");
		String PW = Console.input();
		System.out.println("���� �Է��Ͻÿ�.");
		String name = Console.input();
		System.out.println("�ּҸ� �Է��Ͻÿ�.");
		String address = Console.input();
		System.out.println("����ó�� �Է��Ͻÿ�.");
		String contact = Console.input();
		
		
	
		Tool.guestGetInstance().guestMap.put(ID, new Guest(PW, name,address,contact));
		
		System.out.println("ID   : " + ID);
		System.out.println("PW   : " + PW);
		System.out.println("����   : " + name);
		System.out.println("�ּ�   : " + address);
		System.out.println("����ó : " + contact);
		System.out.println("ȸ������ �ϼ̽��ϴ�.");
		/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		guest();
		
	}

	@Override
	public void guestLogIn() { // �α���
		String pw;

		System.out.print("���̵� �Է��ϼ���.");
		String id = Console.input();

		// ID�Ǻ�
		if (Tool.guestGetInstance().guestMap.containsKey(id)) { // todo hash table ���� ID PW �����ϱ�
			System.out.print("��й�ȣ�� �Է��ϼ���.");
			pw = Console.input();

			// PW �Ǻ�
			if (pw.equals(Tool.guestGetInstance().guestMap.get(id).getGuestPW())) {
				System.out.println("�α��εǾ����ϴ�.");
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				Tool.consoleGetInstance().logInMenu();
			}

		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			Tool.consoleGetInstance().logInMenu();
		}
	}

	@Override
	public void guestLogOut() { // �α׾ƿ�
		System.out.println("����Ǿ����ϴ�.");
		Tool.consoleGetInstance().logInMenu();
		Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
	}

	@Override
	public void guestBuy() { // ��ñ��� map���� orderMap���� �ڷ� �̵�
		// map�� �ִ� ��� ���
		Tool.menu("�������");
		Tool.getBookInfo();

		System.out.println("�����Ͻ� å�� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0]");
		try {
			int num = Integer.parseInt(Console.input());

			// 0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

			}
			// �Է��� å�� ��ȣ�� �ڷ� ���� Ȯ��
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				guestBuy();
			}

			System.out.println("å�� ������ �Է��Ͻÿ�.");
			int count = Integer.parseInt(Console.input());

			// �Է��� Count�� map�� Count ��
			if ((Tool.bookGetInstance().map.get(num).getCount() - count) < 0) {
				System.out.println("������ �����մϴ�.");
				guestBuy();
			} else {
				// map���� ���� ����
				Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);

				// orderMap�� �ڷᰡ �ִ� ��� Count+
				if (Tool.orderGetInstance().orderMap.containsKey(num)) {
					Tool.orderGetInstance().orderMap.get(num).setCount(Tool.orderGetInstance().orderMap.get(num).getCount() + count);
					Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_POSSIBLE);
					Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
					Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);

					// orderMap�� �ڷᰡ ���� ��� ���� �Է�
				} else {
					Tool.orderGetInstance().orderMap.put(num,
							new Order(Tool.bookGetInstance().map.get(num).getBookName(), Tool.bookGetInstance().map.get(num).getAhthor(),
									Tool.bookGetInstance().map.get(num).getPrice(), count, Code.ORDERCONFIRM_POSSIBLE,
									Code.ORDERCANCLE_IMPOSSIBLE, Code.ORDERCANCLE_STATE_NOMAL));
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println(Tool.bookGetInstance().map.get(num).getBookName() + " ���ŵǾ����ϴ�.");
			}

		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			guestBuy();
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_BUY);
	}

	@Override
	public void guestCart() { // ��ٱ��Ͽ� �ִ� å �ϰ� ���� shelfMap���� orderMap���� �ڷ� �̵�
		Tool.menu("��ٱ���");
		Tool.getShelfBookInfo();

		System.out.println("���� �Ͻðڽ��ϱ�? Y or N");
		String choice = Console.input();

		if (choice.equals("Y") || choice.equals("y")) {

			// shelfMap�� �ִ� ��� �ڷ� �ҷ����� ���� for - each�� ���  todo ����
			for (Entry<Integer, Book> shelf : Tool.bookGetInstance().shelfMap.entrySet()) {
				int key = shelf.getKey();
				String bookName = shelf.getValue().getBookName();
				String arthor = shelf.getValue().getAhthor();
				int price = shelf.getValue().getPrice();
				int count = shelf.getValue().getCount();

				// orderMap�� �ڷᰡ �ִ� ��� Count+
				if (Tool.orderGetInstance().orderMap.containsKey(key)) {
					Tool.orderGetInstance().orderMap.get(key).setCount(Tool.orderGetInstance().orderMap.get(key).getCount() + count);
					Tool.orderGetInstance().orderMap.get(key).setSell(Code.ORDERCONFIRM_POSSIBLE);
					Tool.orderGetInstance().orderMap.get(key).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
					Tool.orderGetInstance().orderMap.get(key).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);

					// orderMap�� �ڷᰡ ���� ��� ���� �Է�
				} else {
					Tool.orderGetInstance().orderMap.put(key, new Order(bookName, arthor, price, count, Code.ORDERCONFIRM_POSSIBLE,
							Code.ORDERCANCLE_IMPOSSIBLE, Code.ORDERCANCLE_STATE_NOMAL));

				}
			/*	DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println(bookName + " �����Ǿ����ϴ�.");
				// orderMap���� Count�� �̵����Ѽ� �ߺ��� ���� ���� shelfMap�� �ִ� Chount 0�� ����
				Tool.bookGetInstance().shelfMap.get(key).setCount(0);
			}
		} else if (choice.equals("N") || choice.equals("n")) {
			System.out.println("����ϼ̽��ϴ�.");
			Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			guestCart();
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
	}

	@Override
	public void guestCartFold() { // ��ٱ��Ͽ� å ��� map���� shelfMap���� �ڷ� �̵�
		Tool.menu("�������");
		Tool.getBookInfo();

		System.out.println("�����Ͻ� å�� ��ȣ�� �Է��Ͻÿ�. [�����޴� : 0]");

		try {
			int num = Integer.parseInt(Console.input());

			// 0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().guestCartMenu();
			}

			// �Է��� å�� ��ȣ�� �ڷ� ���� Ȯ��
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				guestCartFold();
			}
						
			System.out.println("å�� ������ �Է��Ͻÿ�.");
			int count = Integer.parseInt(Console.input());

			// �Է��� Count�� map�� Count ��
			if ((Tool.bookGetInstance().map.get(num).getCount() - count) < 0) {
				System.out.println("������ �����մϴ�.");
				guestCartFold();
			} else {

				// orderMap���� Count�� �̵����Ѽ� �ߺ��� ���� ���� map�� �ִ� Chount- ����
				Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);

				// shelfMap�� �ڷᰡ �ִ� ��� Count+
				if (Tool.bookGetInstance().shelfMap.containsKey(num)) {
					Tool.bookGetInstance().shelfMap.get(num).setCount(Tool.bookGetInstance().shelfMap.get(num).getCount() + count);

					// shelfMap�� �ڷᰡ ���� ��� ���� �Է�
				} else {
					Tool.bookGetInstance().shelfMap.put(num, new Book(Tool.bookGetInstance().map.get(num).getBookName(), Tool.bookGetInstance().map.get(num).getAhthor(),
							Tool.bookGetInstance().map.get(num).getPrice(), count));
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println("��ٱ��Ͽ� ��ҽ��ϴ�.");
			}
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			guestCartFold();
		}
		guestCartFold();
	}

	@Override
	public void guestCartRefund() {// ��ٱ��Ͽ� �ִ� å ��� shelfMap���� map���� �̵�
		Tool.menu("��ٱ���");
		Tool.getShelfBookInfo();

		System.out.println("����Ͻ� å�� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0] ");
		try {
			int num = Integer.parseInt(Console.input());

			// 0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_CART);
			}

			// �Է��� å�� ��ȣ�� �ڷ� ���� Ȯ��
			if (!Tool.bookGetInstance().shelfMap.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				guestCartRefund();
			}

			System.out.println("å�� ������ �Է��Ͻÿ�.");
			int count = Integer.parseInt(Console.input());

			// �Է��� Count�� shelfMap�� Count ��
			if ((Tool.bookGetInstance().shelfMap.get(num).getCount() - count) < 0) {
				System.out.println("������ �����մϴ�.");
				guestCartRefund();

			} else {
				// map���� Count�� �̵����Ѽ� �ߺ��� ���� ���� shelfMap�� �ִ� Chount- ����
				Tool.bookGetInstance().shelfMap.get(num).setCount(Tool.bookGetInstance().shelfMap.get(num).getCount() - count);

				// map�� �ڷᰡ ���� ��� ���� �Է�
				if (Tool.bookGetInstance().map.containsKey(num)) {
					Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + count);

					// map�� �ڷᰡ �ִ� ��� Count+
				} else {
					Tool.bookGetInstance().map.get(num).setCount(count);
				}
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
			}
			System.out.println("��ҵǾ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			guestCartRefund();
		}
		guestCartRefund();
	}

	@Override
	public void guestRefund() { // ȯ�� �޴� �����ڰ� ���� ���� �� å ȯ�� ��û �޴� Refund =
								// ORDERCANCLE_POSSIBLE),RefundState =
								// ORDERCANCLE_STATE_CALLING�� ��
			
		System.out.println("=================================���Ÿ��==================================");
		System.out.println("�ڵ�\t������\t\t����\t\t����\t\t����\tȯ�ҽ�û����");
		System.out.println("------------------------------------------------------------------------");

		Tool.getOrderBookInfo();

		System.out.println("ȯ���Ͻ� å�� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			// 0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);

				// �Է��� å�� ��ȣ�� �ڷ� ���� Ȯ��
			} else if (!Tool.orderGetInstance().orderMap.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

				// �Է��� å�� ��ȣ�� ȯ�� ��û ���� Ȯ��
			} else if (Tool.orderGetInstance().orderMap.get(num).getSell() == 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				
			}else if(Tool.deliveryGetInstance().deliveryList.get(num).getDeliverySate() == 1 ||Tool.deliveryGetInstance().deliveryList.get(num).getDeliverySate() == 2){
					System.out.println("�̹� ��� ���Դϴ�.");
					 guestCartFold();
			}else {
				Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_POSSIBLE); 
				Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_POSSIBLE); 
				Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_CALLING); 
																						
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				System.out.println("ȯ�� ��û �Ǿ����ϴ�.");
			}
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
		}
		guestRefund();
	}

	@Override
	public void guestChangePW() { //��й�ȣ ����
		System.out.println("�������� Ȯ���� ���� ID�� �Է��Ͻÿ�.");
		String ID = Console.input();

		if (Tool.guestGetInstance().guestMap.containsKey(ID)) {
			System.out.println("���� ��й�ȣ�� �Է��Ͻÿ�.");
			String PW = Console.input();
			
			if (Tool.guestGetInstance().guestMap.get(ID).getGuestPW().equals(PW)) {
				System.out.println("�� ��й�ȣ�� �Է��Ͻÿ�.");
				PW = Console.input();
				
				System.out.println("�ٽ� �ѹ� �Է��Ͻÿ�.");
				String PW2 = Console.input();
				
				while (!PW.equals(PW2)) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��Ͻÿ�. [���� �޴� : 0]");
				
					// 0 �Է½� ���� �޴���
					if (PW2 == "0") {
						
						break;
					}
				}
				Tool.guestGetInstance().guestMap.get(ID).setGuestPW(PW);
				/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
				System.out.println("��й�ȣ�� " + PW + "�� ����Ǿ����ϴ�.");
				Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				guestChangePW();
			}
		} else {
			System.out.println("ID�� �߸� �Է��ϼ̽��ϴ�.");
			guestChangePW();
		}
	}

	@Override
	public void guestChangeAddress() {
		System.out.println("ID�� �Է��Ͻÿ�.");
		String ID = Console.input();
		
		System.out.println("�����Ͻ� �ּҸ� �Է��Ͻÿ�.");
		String address = Console.input();
		
		System.out.println("�����Ͻ� �ּҰ�" + "\n �½��ϱ�? [Y/N]");
		String YN = Console.input();
		
		if(YN.equals("Y")||YN.equals("y")){
			System.out.println("�ּҰ� " + address + "�� ����Ǿ����ϴ�.");
			Tool.guestGetInstance().guestMap.get(ID).setGuestAddress(address);
			/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		
		}else if(YN.equals("N")||YN.equals("n")){
			System.out.println("����ϼ̽��ϴ�.");

		}else{
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
	}

	@Override
	public void guestChangeContact() {
		System.out.println("ID�� �Է��Ͻÿ�.");
		String ID = Console.input();
		
		System.out.println("�����Ͻ� ����ó�� �Է��Ͻÿ�.");
		String address = Console.input();
		
		System.out.println("�����Ͻ� ����ó��" + "\n �½��ϱ�?");
		String YN = Console.input();
		
		if(YN.equals("Y")||YN.equals("y")){
			Tool.guestGetInstance().guestMap.get(ID).setGuestContact(address);
			/*DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());*/
		
		}else if(YN.equals("N")||YN.equals("n")){
			System.out.println("����ϼ̽��ϴ�.");

		}else{
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		Tool.consoleGetInstance().commonMenu(Code.GUEST_INFO_CHANGE);
	}
}
