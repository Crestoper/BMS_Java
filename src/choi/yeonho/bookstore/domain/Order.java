package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : �ֹ����� Class Host�� �ֹ� ���� å ���� ���õ� ������ Class 
*/

//Book Class�� �ߺ��Ǵ� ��������� ����޼ҵ� ��� ���� �����
public class Order extends Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int hostSaleTotal = 0; // ����
	
	// ���Ž��� ����
	private int sell = 0; 	//���� ���� ����
	private int refund = 0;	//ȯ�� ��û ���� 0 : ���� 1 ��
	private String refundState = "N"; // ȯ�� ��û ǥ��

	// ������ �Է� �ޱ� ���� ������ ����
	// �⺻������
	public Order() {
	}

	// Key�� ��Ͻ� ��� ������
	public Order(String bookName, String ahthor, int price, int count, int sell, int refund,String refundState) {
		super(bookName, ahthor, price, count);
		this.sell = sell;
		this.refund = refund;
		this.refundState = refundState;
	}

	// �ֹ����� ���� HashMap ����
	public HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>();

	public int getSell() {
		return sell;
	}
	
	public int getRefund(){
		return refund;
	}
	
	public String getRefundState(){
		return refundState;
	}
	
	public void setSell(int sell){
		this.sell = sell;
	}
	
	public void setRefund(int refund){
		this.refund = refund;
	}
	
	public void setRefundState(String refundState){
		this.refundState = refundState;
	}


}