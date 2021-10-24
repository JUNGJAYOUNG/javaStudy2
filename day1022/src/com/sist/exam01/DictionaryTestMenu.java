package com.sist.exam01;
import java.util.*;

public class DictionaryTestMenu {
	
	public static void printMenu() {
		System.out.println("1:단어등록 2:단어검색 3:모두출력 4:단어삭제 0:종료");
		System.out.println("메뉴를 선택하세요:");
	}
	
	//단어등록을 위한 메소드
	public static void insertWord(HashMap<String,String> map) {
		
	}
	
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tiger","호랑이");
		map.put("lion","사자");
		map.put("apple","사과");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String eng, kor;
			System.out.println("찾고자 하는 단어 입력하세요");
			eng = sc.next();
			kor = map.get(eng);
			if(kor != null) {
				System.out.println(kor);
			}else {
				System.out.println("등록된 단어가 아닙니다.");
			}			
		}
	}
}
