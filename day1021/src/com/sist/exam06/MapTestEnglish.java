package com.sist.exam06;
import java.util.*;
public class MapTestEnglish {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<String, String>();
		while(true) {
			System.out.println("1:�߰�, 2:�˻�, 3:����");
			System.out.print("�����ϼ���=>");
			int menu=sc.nextInt();
		
			switch(menu) {
				case 1:
					System.out.print("�߰��� ���ܾ �Է��ϼ���:");
					String eng =sc.next();
					System.out.println("���ܾ��� ���� �Է��ϼ���:");
					String mean = sc.next();
					map.put(eng,mean);
					break;
				case 2:
					System.out.println("�˻��� ���ܾ �Է��ϼ���:");
					System.out.println(map.get(sc.next()));
					break;
				case 3:
					System.out.print("������ ���ܾ �Է��ϼ���");
					map.remove(sc.next());
					break;
			}
		}
	}

}
