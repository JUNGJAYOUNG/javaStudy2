package com.sist.exam03;
import java.util.*;

public class HashMapTest {
	public static void main(String[] args)
	 {
	  HashMap map = new HashMap();
	  map.put("java", "1234");
	  map.put("asdf", "1111"); 
	  map.put("asdf", "1234"); //��ġ�� (Ű�� �ߺ��� ������� �ʱ� ������ ���������)
	  Scanner s = new Scanner(System.in); //ȭ�� �Է�
	  
	  while(true) { //���ѹݺ�
		   System.out.println("id�� password�� �Է����ּ���.");
		   System.out.print("id : ");
		   String id = s.nextLine().trim(); //id�Է� , key
		   System.out.print("password : ");
		   String password = s.nextLine().trim(); //password , value
		   System.out.println();
	   if(!map.containsKey(id)) { //containsKey : ���� Map�� �Է��ϰ� �ִ� �� id�� �ִ��Ķ�� ��
		   System.out.println("id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		   continue;
	   } else {
		   if(!(map.get(id)).equals(password)) { //map.get(id)) = key�� �̸����� ���� ������ ��
			   System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		   } else {
			   System.out.println("id�� ��й�ȣ�� ��ġ�մϴ�.");
			   break;
		   }
	   }
	 }
   }
}
