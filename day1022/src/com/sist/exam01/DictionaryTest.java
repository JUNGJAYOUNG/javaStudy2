package com.sist.exam01;
import java.util.*;

public class DictionaryTest {
	//�ܾ �󵵼��� ���� map�� ���鶧��
	//�ܾ�(key)������ ������ �ǵ��� �ϱ� ���Ͽ� => TreeMap
	//�׷��� ���� ������ ���� ���� ������ �ʿ䰡 ����. =>HashMap
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
