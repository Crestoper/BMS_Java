package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;

public class Delivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int oderNumber;
	private int bookNumber;
	private int count;
	private String address;
	private int deliverySate; 
	
	public Delivery(){}

	public Delivery(int bookNumber,int count, int deliverySate){
		this.bookNumber = bookNumber;
		this.count = count;
		
		this.deliverySate = deliverySate;
	}
	public Delivery(int oderNumber,int count, String address,int deliverySate){
		this.oderNumber = oderNumber;
		this.count = count;
		this.address = address;
		this.deliverySate = deliverySate;
	}
	
	public HashMap<Integer,Delivery> deliveryList = new HashMap<Integer,Delivery>();

	public void setDeliverySate(int deliverySate){
		this.deliverySate = deliverySate;
	}
	
	public int getDeliverySate(){
		return deliverySate;
	}
	public int getOderNumber() {
		return oderNumber;
	}
	public void setOderNumber(int oderNumber) {
		this.oderNumber = oderNumber;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public HashMap<Integer, Delivery> getDeliveryList() {
		return deliveryList;
	}
	public void setDeliveryList(HashMap<Integer, Delivery> deliveryList) {
		this.deliveryList = deliveryList;
	}
	
	
}

