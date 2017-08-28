package choi.yeonho.bookstore.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import choi.yeonho.bookstore.domain.Code;


/*
프로그램명 : BMS(서점관리자 시스템)
작성일     : 3.27 - 3.31
작성자     : 최연호
페이지 설명 : 입력관련 Class
*/

//MenuImplements를 상속 받음
public class Console extends MenuImplements{
		
	private static BufferedReader reader;
	
	public static String input(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("§ ");
		String str = "";
		
		try {
			str = reader.readLine();
		} catch (IOException e) {
			System.out.println("키보드 입력 애러");
			e.printStackTrace();
		}
		
		
		return str;
	}
	
}
