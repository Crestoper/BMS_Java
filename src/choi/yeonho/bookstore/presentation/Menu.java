package choi.yeonho.bookstore.presentation;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : Menu ���� ��� ���Ǽ� Interface
*/

public interface Menu {
	
	//�޴�����
	public void commonMenu(int menu); //�޴� ������, �ڵ带 ���� ����
	
	//�α��θ޴�
	public void logInMenu();
	
	//�����ڸ޴�
	public void hostMenu();
	
	//������� �Ŵ�
	public void hostStock();
	
	//�մ� �޴�
	public void guestMenu();
	
	//�մ� ���θ޴�
	public void guestBuyMenu();  //�ٷ� ����
	
	public void guestCartMenu(); //īƮ ����
	
	public void guestRefund();  //ȯ��
	
	public void guestInfoChange(); //��������
}
