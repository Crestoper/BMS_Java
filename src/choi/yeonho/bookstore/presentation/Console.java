package choi.yeonho.bookstore.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import choi.yeonho.bookstore.domain.Code;


/*
���α׷��� : BMS(���������� �ý���)
�ۼ���     : 3.27 - 3.31
�ۼ���     : �ֿ�ȣ
������ ���� : �Է°��� Class
*/

//MenuImplements�� ��� ����
public class Console extends MenuImplements{
		
	private static BufferedReader reader;
	
	public static String input(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�� ");
		String str = "";
		
		try {
			str = reader.readLine();
		} catch (IOException e) {
			System.out.println("Ű���� �Է� �ַ�");
			e.printStackTrace();
		}
		
		
		return str;
	}
	
}
