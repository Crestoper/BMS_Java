package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import choi.yeonho.bookstore.presentation.MenuImplements;
import choi.yeonho.bookstore.service.Tool;

/*
 ���α׷��� : BMS(���������� �ý���)
 �ۼ���     : 3.27 - 3.31
 �ۼ���     : �ֿ�ȣ
 ������ ���� : Book ������ ���õ� ������ + �⺻ ��ɾ� Class 
 */

//todo �����ͺ��̽� ����

public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//å �⺻ ���� �ɹ�����
	private int num;			//å��ȣ(��Ϲ�ȣ)
	private String bookName;	//å����
	private String ahthor;		//����
	private int price;			//����(�Ǵ�)
	private int count = 0;		//����
		
	//������ �Է� �ޱ� ���� ������ ����
	//�⺻������
	public Book(){}

	//Key�� ��Ͻ� ��� ������
	public Book(String bookName, String ahthor, int price, int count){
		this.bookName = bookName;
		this.ahthor = ahthor;
		this.price = price;
		this.count =count;
		
	}
	
	//å ���� ������ ���� HashMap ����
	public HashMap<Integer,Book> map = new HashMap<Integer,Book>();
	public HashMap<Integer, Book> shelfMap = new HashMap<Integer, Book>();
		
	//�ɹ������� private�� ������ �ܺο��� Book Class�� �����ϱ� ���� �ɹ������� getter setter ����
	public int getNum(){
		return num;
	}
	
	public String getBookName(){ //å����
		return bookName;
	}
	
	public String getAhthor(){ //�۰���
		return ahthor;
	}
	
	public int getPrice(){//����
		return price;
	}
	
	public int getCount(){//å����
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
}