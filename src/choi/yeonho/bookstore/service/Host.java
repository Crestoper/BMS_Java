package choi.yeonho.bookstore.service;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : Host ���� ��� ���Ǽ� Interface
*/


public interface Host {
	
	public static String ID = "HOST"; //Host Id
	public static String PW = "HOST"; //Host Pw
	
	public void hostLogIn();		//�α���
	public void hostLogOut();		//�α׾ƿ�
	public void hostBookList(); 	//������� ��ȸ
	public void hostBookAdd();		//���� �ű� ���
	public void hostBookUpdate();	// ���� ����
	public void hostBookInsert();	//���� ���� ����
	public void hostBookDel();   	//���� ���� ����
	public void hostOrderList();	//���� ���� ��� ���
	public void hostOrderConfirm(); //���� ����
	public void hostOrderCancle();	//ȯ�� ����
	public void hostSaleTotal();	//���
	public void deliveryState();	//�������

}
