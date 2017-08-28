package choi.yeonho.bookstore.domain;

public interface Code {
	/*
	 ���α׷��� : BMS(���������� �ý���)
	 �ۼ���     : 3.27 - 3.31
	 �ۼ���     : �ֿ�ȣ
	 ������ ���� :	������Ǽ� �ڵ� ���� 
	 */

	//������Ǽ� �ڵ�
	//����(999)
		//������(1)
			//������(1-1)
				//���������ȸ(1-1-1)
				//�������(1-1-2)
				//��������(1-1-3)
				//��������(1-1-4)
				//����(1-1)
			//�ֹ�����(1-2)
				//�ֹ����(1-2-1)
				//�������(1-2-2)
				//�������(1-2-3)
			//���(1-2-4)
			
		//������(2)
			//�������
	
	public final static int SHOP_LOGIN = 999;
	public final static int HOST = 1;
	public final static int HOST_BOOK = 11;
	public final static int HOST_BOOK_LIST = 111;
	public final static int HOST_BOOK_ADD = 112;
	public final static int HOST_BOOK_UPDATE = 113;
	public final static int HOST_BOOK_INSERT = 114;
	public final static int HOST_BOOK_DEL = 115;
	public final static int HOST_BOOK_BACK = 116;//����
	public final static int HOST_ORDER = 12;
	public final static int HOST_ORDER_LIST = 121;
	public final static int HOST_ORDER_CONFIRM = 122;
	public final static int HOST_ORDER_CANCLE = 123; 
	public final static int HOST_SALE_TOTAL = 124;
	public final static int GUEST = 2;
	public final static int GUEST_SHOPPING = 21;
	public final static int GUEST_CART = 211;
	public final static int GUEST_CART_FOLD = 2111;
	public final static int GUEST_CART_REFUND = 2112;
	public final static int GUEST_CART_BUY = 2113;
	public final static int GUEST_BUY = 212;
	public final static int GUEST_REFUND = 213;
	public final static int GUEST_INFO_CHANGE = 214;
	public static final int DELIVERY_STATE = 215;
	
	public final static int ORDERCONFIRM_IMPOSSIBLE = 0; //������ OrderConFirm�� ��ȸ ���� ���� : ���Ű��� ���Ÿ� �Ͽ��°�?
	public final static int ORDERCONFIRM_POSSIBLE = 1;	 //������ OrderConFirm�� ��ȸ ���� ���� :  ���Ű��� ���Ÿ� �Ͽ��°�?
	
	public final static int ORDERCANCLE_IMPOSSIBLE = 0;	//������ ȯ�� ��û ���� 0 = ����
	public final static int ORDERCANCLE_POSSIBLE = 1;	//������ ȯ�� ��û ���� 1 = ��
	
	public final static String ORDERCANCLE_STATE_NOMAL = "N"; 
	public final static String ORDERCANCLE_STATE_CALLING = "Y";
	
	public final static int DELIVERY_STATE_READY = 0;
	public final static int DELIVERY_STATE_GO = 1;
	public final static int DELIVERY_STATE_DONE = 2;
	
}
