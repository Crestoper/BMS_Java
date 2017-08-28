package choi.yeonho.bookstore.presentation;

import choi.yeonho.bookstore.domain.Code;
import choi.yeonho.bookstore.domain.DBIO;
import choi.yeonho.bookstore.domain.Guest;
import choi.yeonho.bookstore.main.Main;
import choi.yeonho.bookstore.service.GuestImplements;
import choi.yeonho.bookstore.service.HostImplements;
import choi.yeonho.bookstore.service.Tool;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : Menu Interface ���� Page ȭ�鿡 ���̴� Menu ����
*/


public class MenuImplements implements Menu {

	//������ ����
	private static HostImplements host = new HostImplements();
	private static GuestImplements guest = new GuestImplements();
	
	
	// �޴� ������, �ڵ带 ���� ����
	@Override
	public void commonMenu(int menu) {
		switch (menu) {
		case Code.SHOP_LOGIN: // �α��� ȭ������ �̵�
			logInMenu();
			break;
		case Code.HOST:
			hostMenu();
			break;
		case Code.HOST_BOOK:
			hostStock();
			break;
		case Code.HOST_BOOK_LIST:
			host.hostBookList();
			break;
		case Code.HOST_BOOK_ADD:
			host.hostBookAdd();
			break;
		case Code.HOST_BOOK_UPDATE:
			host.hostBookUpdate();
			break;
		case Code.HOST_BOOK_INSERT :
			host.hostBookInsert();
			break;
		case Code.HOST_BOOK_DEL:
			host.hostBookDel();
			break;
		case Code.HOST_BOOK_BACK:

			break;
		case Code.HOST_ORDER:
			hostOrder();
			break;
		case Code.HOST_ORDER_LIST:
			host.hostOrderList();
			break;
		case Code.HOST_ORDER_CONFIRM:
			host.hostOrderConfirm();
			break;
		case Code.HOST_ORDER_CANCLE:
			host.hostOrderCancle();
			break;
		case Code.HOST_SALE_TOTAL:
			host.hostSaleTotal();
			break;
		case Code.GUEST:
			guest.guest();
			break;
		case Code.GUEST_SHOPPING:
			guestMenu();
			break;
		case Code.GUEST_CART:
			guestCartMenu();
			break;
		case Code.GUEST_CART_FOLD: // ��ٱ��� ���
			guest.guestCartFold();
			break;
		case Code.GUEST_CART_BUY :
			guest.guestCart();
			break;
		case Code.GUEST_BUY:
			guest.guestBuy();
			break;
		case Code.GUEST_REFUND:
			guestRefund();
			break;
		case Code.GUEST_CART_REFUND:
			guest.guestCartRefund();
			break;
		case Code.GUEST_INFO_CHANGE :
			guestInfoChange();
			break;
		case Code.DELIVERY_STATE :
			host.deliveryState();
			break;
		}
	}

	// ���� ���� �� ù ȭ��. ������ / ������ �޴��� �ҷ����� ���� ����. �α��� ȭ������ �̵�.
	@Override
	public void logInMenu() {

		System.out.println("\n=======�α���=======");
		System.out.println(" 1.������\n 2.������\n 3.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �����ϼ��� ");
		
		switch (Integer.parseInt(Console.input())) { // input�� String�̹Ƿ� int��
														// Casting
		case 1:
			host.hostLogIn(); // Host LogIn ȭ������
			break;
		case 2:
			commonMenu(Code.GUEST); // Guest LogIn ȭ������
			break;
		case 3:
			System.out.println("�����մϴ�.");
			/*DBIO.saveDB(Main.BOOK_DB, Tool.bookGetInstance());
			DBIO.saveDB(Main.ORDER_DB, Tool.orderGetInstance());
			DBIO.saveDB(Main.GUEST_DB, Tool.guestGetInstance());
			DBIO.saveDB(Main.DELIVERY_DB, Tool.deliveryGetInstance());*/
			System.exit(0);
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			commonMenu(Code.SHOP_LOGIN);
			break;
		}
	}

	@Override
	public void hostMenu() { //������ �⺻ �޴�
		System.out.println("\n=======������=======");
		System.out.println(" 1.������\n 2.�ֹ�����\n 3.�α׾ƿ�");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_BOOK);
			break;
		case 2:
			commonMenu(Code.HOST_ORDER);
			break;
		case 3:
			host.hostLogOut();
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			commonMenu(Code.HOST);
		}
	}

	@Override
	public void hostStock() { //������ ������ �޴�
		System.out.println("\n======������======");
		System.out.println(" 1.�������\n 2.�������\n 3.��������\n 4.�����߰���û\n 5.������ǰ��û\n 6.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_BOOK_LIST);
			break;
		case 2:
			commonMenu(Code.HOST_BOOK_ADD);
			break;
		case 3:
			commonMenu(Code.HOST_BOOK_UPDATE);
			break;
		case 4:
			commonMenu(Code.HOST_BOOK_INSERT);
			break;
		case 5:
			commonMenu(Code.HOST_BOOK_DEL);
			break;
		case 6:
			System.out.println("���� �޴��� ���ư��ϴ�..");
			commonMenu(Code.HOST);
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			commonMenu(Code.HOST_BOOK);
		}
	}

	public void hostOrder() { //������ �ֹ����� �޴�
		System.out.println("\n======�ֹ�����======"); 
		System.out.println(" 1.�ֹ���ȸ\n 2.���Ž���\n 3.ȯ�ҽ���\n 4.���\n 5.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.HOST_ORDER_LIST);
			break;
		case 2:
			commonMenu(Code.HOST_ORDER_CONFIRM);
			break;
		case 3:
			commonMenu(Code.HOST_ORDER_CANCLE);
			break;
		case 4:
			commonMenu(Code.HOST_SALE_TOTAL);
			break;
		case 5:
			System.out.println("���� �޴��� ���ư��ϴ�..");
			commonMenu(Code.HOST);
		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			commonMenu(Code.HOST_ORDER);

		}
	}

	@Override
	public void guestMenu() { //������ �⺻ �޴�
		System.out.println("\n=======������=======");
		System.out.println(" 1.��ٱ���\n 2.�ٷα���\n 3.ȯ��\n 4.��������\n 5.�������\n 6.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.GUEST_CART);
			break;
		case 2:
			commonMenu(Code.GUEST_BUY);
			break;
		case 3:
			commonMenu(Code.GUEST_REFUND);
			break;
		case 4 :
			commonMenu(Code.GUEST_INFO_CHANGE);
			break;
		case 5:
			commonMenu(Code.DELIVERY_STATE);
			break;
		case 6:
			commonMenu(Code.SHOP_LOGIN);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			commonMenu(Code.GUEST_SHOPPING);
		}
	}

	@Override
	public void guestBuyMenu() { //������ 
		Tool.menu("�������");
		Tool.getBookInfo();
		System.out.println(" 1.����\n 2.���\n 3.����");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			commonMenu(Code.GUEST_BUY);
			break;// ����
		case 2:
			commonMenu(Code.GUEST_REFUND);
			break; // ���
		case 3:
			commonMenu(Code.GUEST_SHOPPING);
			break; // �� �޴�
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			commonMenu(Code.GUEST_SHOPPING);
		}

	}

	@Override
	public void guestCartMenu() { //������ ��ٱ��� �޴�
		Tool.menu("��ٱ���");
		Tool.getShelfBookInfo();
		System.out.println(" 1.����\n 2.���\n 3.���\n 4.����");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1: 
			commonMenu(Code.GUEST_CART_BUY);
			break;
		case 2:
			commonMenu(Code.GUEST_CART_FOLD);
			break;

		case 3:
			commonMenu(Code.GUEST_CART_REFUND);
			break; // ���
		case 4:
			commonMenu(Code.GUEST_SHOPPING);
			break; // �� �޴�
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			commonMenu(Code.GUEST_CART);
		}
	}

	@Override
	public void guestRefund() {//������ ȯ�� �޴�
		guest.guestRefund();
	}

	@Override
	public void guestInfoChange() {
		System.out.println("\n======��������======");
		System.out.println(" 1.��й�ȣ ����\n 2.�ּ� ����\n 3.����ó ����\n 4.����");
		System.out.println("===================");
		System.out.print("�޴���ȣ�� �Է��ϼ���. ");

		switch (Integer.parseInt(Console.input())) {
		case 1:
			guest.guestChangePW();
			break;
		case 2:
			guest.guestChangeAddress();
			break;
		case 3:
			guest.guestChangeContact();
			break;
		case 4:
			commonMenu(Code.GUEST_SHOPPING);
			break;
		}
	}
}