package choi.yeonho.bookstore.service;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : �� ���� ������Ǽ� Interface
*/


public interface GuestPre {

	public void guest();			//guest �⺻�޴�
	public void guestJoin();		//ȸ������
	public void guestLogIn(); 		//Guest LogIn Menu
	public void guestLogOut();		//Guest LogOut Menu
	public void guestBuy();			//��ñ���
	public void guestCart();		//īƮ�� ��� å ����
	public void guestCartFold();	//īƮ�� å ���
	public void guestCartRefund();	//īƮ�� ��� å ����
	public void guestRefund();		//���� �� å ȯ��
	public void guestChangePW();	//PW����
	public void guestChangeAddress();//�ּҺ���
	public void guestChangeContact();//����ó����
	
	
	
}
