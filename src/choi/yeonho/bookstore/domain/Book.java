package choi.yeonho.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import choi.yeonho.bookstore.presentation.MenuImplements;
import choi.yeonho.bookstore.service.Tool;

/*
 프로그램명 : BMS(서점관리자 시스템)
 작성일     : 3.27 - 3.31
 작성자     : 최연호
 페이지 설명 : Book 서점에 관련된 데이터 + 기본 명령어 Class 
 */

//todo 데이터베이스 구축

public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//책 기본 정보 맴버변수
	private int num;			//책번호(등록번호)
	private String bookName;	//책제목
	private String ahthor;		//저자
	private int price;			//가격(권당)
	private int count = 0;		//수량
		
	//정보를 입력 받기 위한 생성자 생성
	//기본생성자
	public Book(){}

	//Key값 등록시 사용 생성자
	public Book(String bookName, String ahthor, int price, int count){
		this.bookName = bookName;
		this.ahthor = ahthor;
		this.price = price;
		this.count =count;
		
	}
	
	//책 정보 저장을 위한 HashMap 생성
	public HashMap<Integer,Book> map = new HashMap<Integer,Book>();
	public HashMap<Integer, Book> shelfMap = new HashMap<Integer, Book>();
		
	//맴버변수가 private기 때문에 외부에서 Book Class에 접근하기 위해 맴버변수의 getter setter 생성
	public int getNum(){
		return num;
	}
	
	public String getBookName(){ //책제목
		return bookName;
	}
	
	public String getAhthor(){ //작가명
		return ahthor;
	}
	
	public int getPrice(){//가격
		return price;
	}
	
	public int getCount(){//책수량
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
}