package com.sist.exam06;
import java.util.*;
public class MapTestEnglish {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<String, String>();
		while(true) {
			System.out.println("1:추가, 2:검색, 3:삭제");
			System.out.print("선택하세요=>");
			int menu=sc.nextInt();
		
			switch(menu) {
				case 1:
					System.out.print("추가할 영단어를 입력하세요:");
					String eng =sc.next();
					System.out.println("영단어의 뜻을 입력하세요:");
					String mean = sc.next();
					map.put(eng,mean);
					break;
				case 2:
					System.out.println("검색할 영단어를 입력하세요:");
					System.out.println(map.get(sc.next()));
					break;
				case 3:
					System.out.print("삭제할 영단어를 입력하세요");
					map.remove(sc.next());
					break;
			}
		}
	}

}
