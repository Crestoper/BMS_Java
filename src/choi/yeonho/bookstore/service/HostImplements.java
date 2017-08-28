package choi.yeonho.bookstore.service;

import java.util.Map;
import java.util.Random;

import choi.yeonho.bookstore.domain.Book;
import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Delivery;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.domain.Order;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.presentation.Console;
import choi.yeonho.bookstore.presentation.MenuImplements;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : Host Interface Implements Page ������ ���� Method
*/


public final class HostImplements implements Host {

	

	@Override
	public void hostLogIn() { //�α���
		String id, pw;

		System.out.print("\n���̵� �Է��ϼ���.");
		id = Console.input();

		// ID�Ǻ�
		if (id.equals(ID)) {
			System.out.print("��й�ȣ�� �Է��ϼ���.");
			pw = Console.input();
			// PW �Ǻ�
			if (pw.equals(PW)) {
				System.out.println("\n�����ڷ� �α��εǾ����ϴ�.");
				Tool.consoleGetInstance().commonMenu(Code.HOST);// ������ ȭ������
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
			}

		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			Tool.consoleGetInstance().logInMenu();
		}

	}

	
	
	@Override
	public void hostLogOut() { //�α׾ƿ�
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		Tool.consoleGetInstance().commonMenu(Code.SHOP_LOGIN);
	}

	@Override
	public void hostBookList() {
		Tool.menu("å  ���");
		Tool.getBookInfo();
		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
	}

	@Override
	public void hostBookAdd() { //���� ���� �ű� ���
		try {
			int num = (int) (Math.random()*9999);
			System.out.println("������ȣ�� " + num + "�Դϴ�.");
			
			if(Tool.bookGetInstance().map.containsKey(num)){
				hostBookAdd();
			}
			System.out.print("å ������ �Է��Ͻÿ�. ");
			String bookName = Console.input();

			System.out.print("å ���ڸ� �Է��Ͻÿ�. ");
			String ahthor = Console.input();

			System.out.print("å ������ �Է��Ͻÿ�. ");
			int price = Integer.parseInt(Console.input());

			System.out.print("å ������ �Է��Ͻÿ�. ");
			int count = Integer.parseInt(Console.input());

			Tool.bookGetInstance().map.put(num, new Book(bookName, ahthor, price, count));
			
			/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
			DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
			
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�,");
			hostBookAdd();
		}
		System.out.println("�߰��Ǿ����ϴ�.");

		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);

	}

	@Override
	public void hostBookUpdate() { //��ϵ� ���� ���� ���� - ������ �Ұ�
		System.out.print("���� �� å ��� ��ȣ�� �Է��Ͻÿ�. ");
		try {
			int num = Integer.parseInt(Console.input());
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				hostBookUpdate();
			}

			System.out.print("å ������ �Է��Ͻÿ�. ");
			String bookName = Console.input();

			System.out.print("å ���ڸ� �Է��Ͻÿ�. ");
			String ahthor = Console.input();

			System.out.print("å ������ �Է��Ͻÿ�. ");
			int price = Integer.parseInt(Console.input());

			Tool.bookGetInstance().map.put(num, new Book(bookName, ahthor, price, Tool.bookGetInstance().map.get(num).getCount()));
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			hostBookUpdate();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("�����Ǿ����ϴ�.");

		Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
	}

	@Override
	public void hostBookInsert() { //��ϵ� ���� ���� ����
		Tool.menu("å  ���");
		Tool.getBookInfo();

		System.out.print("�߰� �ֹ��� å ��� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0]"); 
		try {
			int num = Integer.parseInt(Console.input());
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			System.out.println("�߰� �ֹ��� ������ �Է��Ͻÿ�. [���� �޴� : 0]");
			int count = Integer.parseInt(Console.input());
			if (count == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				hostBookInsert();
			}
			Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + count);
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			hostBookInsert();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("�߰��Ǿ����ϴ�.");

		hostBookInsert();
		
	}
	@Override
	public void hostBookDel() { //��ϵ� ���� ���� ����
		Tool.menu("å  ���");
		Tool.getBookInfo();

		System.out.print("��ǰ�� å ��� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			//0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			System.out.println("��ǰ�Ͻ� ������ �Է��Ͻÿ�. [���� �޴� : 0]");
			int count = Integer.parseInt(Console.input());
			
			//�Է��� Count�� map�� Count ��
			if (Tool.bookGetInstance().map.get(num).getCount() < count){
				System.out.println("������ �����մϴ�.");
				hostBookDel();
			}
			
			//0 �Է½� ���� �޴���
			if (count == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_BOOK);
			}
			
			//map�� �ڷ� ���� Ȯ��
			if (!Tool.bookGetInstance().map.containsKey(num)) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				hostBookDel();
			}
			
			//map�� Count���� �Է��� Count��ŭ ����
			Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() - count);
		
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			hostBookDel();
		}
		/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
		DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
		System.out.println("��ǰ�Ǿ����ϴ�.");
		hostBookDel();
	}

	@Override
	public void hostOrderList() { //���� ���� ��� ���
		Tool.menu("�ֹ����");		
		Tool.getOrderBookInfo();

		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
	}

	@Override
	public void hostOrderConfirm() { //���� ���� 
		Tool.menu("��û���");
		Tool.getOrderBookInfo();

		System.out.println("���� �Ͻðڽ��ϱ�? Y or N");
		String choice = Console.input();

		if (choice.equals("Y") || choice.equals("y")) {
			
			//orderMap�� �ִ� ��� �ڷ� �ҷ����� ���� for - each�� ���
			for (Map.Entry<Integer, Order> order : Tool.orderGetInstance().orderMap.entrySet()) {
				int key = order.getKey();
				String bookName = order.getValue().getBookName();
				String arthor = order.getValue().getAhthor();
				int price = order.getValue().getPrice();
				int count = order.getValue().getCount();
				int sell = order.getValue().getSell();
				int refund = order.getValue().getRefund();
				if (sell == 1 || refund == 0) {
					Tool.orderGetInstance().hostSaleTotal += (price * count);

					Tool.orderGetInstance().orderMap.get(key).setCount(count);
					Tool.orderGetInstance().orderMap.get(key).setSell(Code.ORDERCONFIRM_POSSIBLE); //���Ž��� o
					Tool.orderGetInstance().orderMap.get(key).setRefund(Code.ORDERCANCLE_POSSIBLE);//ȯ�ҽ�û ����
							
				int oderNumber = (int) (Math.random() * 9999);
				Tool.deliveryGetInstance().deliveryList.put(oderNumber, new Delivery(key, count, Code.DELIVERY_STATE_READY));

				} else {
					continue;
				}

				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
				DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());*/
				
				System.out.println(bookName + " ���εǾ����ϴ�.");
			}
		} else if (choice.equals("N") || choice.equals("n")) {
			Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			hostOrderConfirm();
		}
		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);

	}

	@Override //
	public void hostOrderCancle() { //ȯ�� ����
		System.out.println("=================================��Ҹ��==================================");
		System.out.println("�ڵ�\t������\t\t����\t\t����\t\t����\tȯ�ҽ�û����");
		System.out.println("------------------------------------------------------------------------");
		Tool.getOrderRefundBookInfo();

		System.out.println("����Ͻ� å�� ��ȣ�� �Է��Ͻÿ�. [���� �޴� : 0]");
		try {
			int num = Integer.parseInt(Console.input());
			
			//0 �Է½� ���� �޴���
			if (num == 0) {
				Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
			}

			//�Է��� å�� ��ȣ�� �ڷ� ���� Ȯ�� + ȯ�ҽ�û Ȯ��
			if (!Tool.orderGetInstance().orderMap.containsKey(num) || Tool.orderGetInstance().orderMap.get(num).getRefund() == Code.ORDERCANCLE_IMPOSSIBLE) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				hostOrderCancle();
					
			} else {
				//map�� �ڷᰡ ������ orderMap�� �ִ� Count�� map�� �ִ� Count +
				if (Tool.bookGetInstance().map.containsKey(num)) {
					Tool.bookGetInstance().map.get(num).setCount(Tool.bookGetInstance().map.get(num).getCount() + Tool.orderGetInstance().orderMap.get(num).getCount());
							
				//map�� �ڷᰡ ������ oderMap Count�� map Count�� �Է�
				} else {
					Tool.bookGetInstance().map.get(num).setCount(Tool.orderGetInstance().orderMap.get(num).getCount());
				}
				int price = Tool.orderGetInstance().orderMap.get(num).getPrice();
				int count = Tool.orderGetInstance().orderMap.get(num).getCount();
				Tool.orderGetInstance().hostSaleTotal -= (price * count); //ȯ�� �ݾ� ��꿡�� -
				}
				
				//���� reset
			Tool.orderGetInstance().orderMap.get(num).setCount(0);
				Tool.orderGetInstance().orderMap.get(num).setSell(Code.ORDERCONFIRM_IMPOSSIBLE);
				Tool.orderGetInstance().orderMap.get(num).setRefund(Code.ORDERCANCLE_IMPOSSIBLE);
				Tool.orderGetInstance().orderMap.get(num).setRefundState(Code.ORDERCANCLE_STATE_NOMAL);
				
				/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
				DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());*/
				
				System.out.println(Tool.bookGetInstance().map.get(num).getBookName() + " ��ҵǾ����ϴ�.");

		}catch(

	Exception e)
	{
		System.out.println("���ڸ� �Է��Ͻÿ�.");
		hostOrderCancle();
	}
		hostOrderCancle();
	}

	@Override
	public void hostSaleTotal() { //���ݾ� ���
		System.out.printf("��� �ݾ��� %,d�� �Դϴ�.\n", Tool.orderGetInstance().hostSaleTotal);
		Tool.consoleGetInstance().commonMenu(Code.HOST_ORDER);
	}



	@Override
	public void deliveryState() {
		System.out.println("=============�����Ȳ=============");
		System.out.println(" �ֹ���ȣ\t������ȣ\t����\t��ۻ���");
		System.out.println("--------------------------------");
		Tool.getDeliveryInfo();
		System.out.println("================================");
		
		Tool.consoleGetInstance().commonMenu(Code.GUEST_SHOPPING);	
	}
}
