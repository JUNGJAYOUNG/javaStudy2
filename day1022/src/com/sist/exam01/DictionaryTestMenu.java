package com.sist.exam01;
import java.util.*;

public class DictionaryTestMenu {
	
	public static void printMenu() {
		System.out.println("1:�ܾ��� 2:�ܾ�˻� 3:������ 4:�ܾ���� 0:����");
		System.out.println("�޴��� �����ϼ���:");
	}
	
	//�ܾ����� ���� �޼ҵ�
	public static void insertWord(HashMap<String,String> map) {
		
	}
	
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tiger","ȣ����");
		map.put("lion","����");
		map.put("apple","���");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String eng, kor;
			System.out.println("ã���� �ϴ� �ܾ� �Է��ϼ���");
			eng = sc.next();
			kor = map.get(eng);
			if(kor != null) {
				System.out.println(kor);
			}else {
				System.out.println("��ϵ� �ܾ �ƴմϴ�.");
			}			
		}
	}
}
