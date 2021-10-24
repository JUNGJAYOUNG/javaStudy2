package com.sist.exam03;
import java.util.*;

public class HashMapTest {
	public static void main(String[] args)
	 {
	  HashMap map = new HashMap();
	  map.put("java", "1234");
	  map.put("asdf", "1111"); 
	  map.put("asdf", "1234"); //일치함 (키의 중복을 허용하지 않기 때문에 덮어씌어진다)
	  Scanner s = new Scanner(System.in); //화면 입력
	  
	  while(true) { //무한반복
		   System.out.println("id와 password를 입력해주세요.");
		   System.out.print("id : ");
		   String id = s.nextLine().trim(); //id입력 , key
		   System.out.print("password : ");
		   String password = s.nextLine().trim(); //password , value
		   System.out.println();
	   if(!map.containsKey(id)) { //containsKey : 현재 Map에 입력하고 있는 이 id가 있느냐라는 뜻
		   System.out.println("id는 존재하지 않습니다. 다시 입력해주세요.");
		   continue;
	   } else {
		   if(!(map.get(id)).equals(password)) { //map.get(id)) = key에 이름으로 꺼냄 같은지 비교
			   System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		   } else {
			   System.out.println("id와 비밀번호가 일치합니다.");
			   break;
		   }
	   }
	 }
   }
}
