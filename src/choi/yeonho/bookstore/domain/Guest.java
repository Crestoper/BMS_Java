package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Guest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//todo 고객 데이터베이스 
	//guest 번호는 arraylist의 index로 설정 
	private String guestID = " ";
	private String guestPW = " ";
	private String guestName = " ";
	private String guestAddress = " ";
	private String guestContact = " ";
	
	//정보 입력 위한 생성자
		public Guest(){}
		public Guest(String guestPW, String guestName, String guestAddress, String guestContact){
			this.guestPW = guestPW;			
			this.guestName= guestName;			
			this.guestAddress = guestAddress;			
			this.guestContact = guestContact;
		}
			
	//고객 정보 저장을 위한 Hash Map 생성
	public HashMap<String, Guest> guestMap = new HashMap<String, Guest>();
		
	//맴버변수가 private기 때문에 외부에서 Guest Class에 접근하기 위해 맴버변수의 getter 생성
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
