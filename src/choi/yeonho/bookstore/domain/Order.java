package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : 주문관리 Class Host가 주문 받은 책 관리 관련된 데이터 Class 
*/

//Book Class와 중복되는 멤버변수와 멤버메소드 사용 위해 상속함
public class Order extends Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int hostSaleTotal = 0; // 결산액
	
	// 구매승인 여부
	private int sell = 0; 	//결제 승인 여부
	private int refund = 0;	//환불 신청 여부 0 : 안함 1 함
	private String refundState = "N"; // 환불 신청 표시

	// 정보를 입력 받기 위한 생성자 생성
	// 기본생성자
	public Order() {
	}

	// Key값 등록시 사용 생성자
	public Order(String bookName, String ahthor, int price, int count, int sell, int refund,String refundState) {
		super(bookName, ahthor, price, count);
		this.sell = sell;
		this.refund = refund;
		this.refundState = refundState;
	}

	// 주문관리 위해 HashMap 생성
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