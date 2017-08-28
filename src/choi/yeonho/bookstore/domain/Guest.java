package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Guest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//todo �� �����ͺ��̽� 
	//guest ��ȣ�� arraylist�� index�� ���� 
	private String guestID = " ";
	private String guestPW = " ";
	private String guestName = " ";
	private String guestAddress = " ";
	private String guestContact = " ";
	
	//���� �Է� ���� ������
		public Guest(){}
		public Guest(String guestPW, String guestName, String guestAddress, String guestContact){
			this.guestPW = guestPW;			
			this.guestName= guestName;			
			this.guestAddress = guestAddress;			
			this.guestContact = guestContact;
		}
			
	//�� ���� ������ ���� Hash Map ����
	public HashMap<String, Guest> guestMap = new HashMap<String, Guest>();
		
	//�ɹ������� private�� ������ �ܺο��� Guest Class�� �����ϱ� ���� �ɹ������� getter ����
	public String getGuestName(){
		return guestName;
	}
	public String getGuestAddress() {
		return guestAddress;
	}

	public String getGuestContact() {
		return guestContact;
	}
	public String getGuestID() {
		return guestID;
	}
	public String getGuestPW() {
		return guestPW;
	}
	public void setGuestPW(String guestPW) {
		this.guestPW = guestPW;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	public void setGuestContact(String guestContact) {
		this.guestContact = guestContact;
		
	}
	
}
