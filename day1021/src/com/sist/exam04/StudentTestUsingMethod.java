package com.sist.exam04;

import java.util.*;

public class StudentTestUsingMethod {
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("1.추가,2.검색,3.삭제,4.모두출력,5.모두삭재,0.종료");
		System.out.println("메뉴를 선택하세요-->");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name,addr,phone;
		System.out.println("학생 이름 입력:");
		name = sc.next();
		System.out.println("학생 주소 입력:");
		addr = sc.next();
		System.out.println("학생 핸드폰 입력:");
		phone = sc.next();
		list.add(new Student(name,addr,phone));	
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("검색할 학생의 이름 입력:");
		name = sc.next();
		Student searchStudent = null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				searchStudent = list.get(i);
				break;
			}
		}
		if(searchStudent != null) {
			System.out.println(searchStudent);
		}else {
			System.out.println("찾고자하는 학생이 없습니다.");
		}
	}
	
	public static void removeStudent(ArrayList<Student> list) {
		String name;
		System.out.println("삭제할 학생의 이름 입력:");
		name = sc.next();
		int i;
		int cnt = list.size();
		//삭제하기 전에 리스트의 크기 미리 저장
		for(i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i); //.remove() 삭제
				break;
			}
		}
		if(i<cnt) {
			System.out.println(name+"학생의 데이터를 삭제하였습니다.");
		}else {
			System.out.println("삭제하려는 학생 "+name+"은 없습니다.");
		}					
	}
	
	public static void printArray(ArrayList<Student> list) {
		if(list.isEmpty()) {	//.isEmpty() 리스트가 비어있는지 확인
			System.out.println("데이터가 없습니다.");
		}else {
			for(Student student:list){	//ArrayList도 foreach문 사용 가능
				System.out.println(student);
			}
		}	
	}
	
	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		String name,addr,phone;
		
		while(true) {
			System.out.println("1.추가,2.검색,3.삭제,4.모두출력,5.모두삭재,0.종료");
			int menu=sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1:insertStudent(list);break;
				case 2:searchStudent(list);break;
				case 3:removeStudent(list);break;
				case 4:printArray(list);break;
				case 5:list.clear();System.out.println("데이터를 모두 삭제하였습니다.");break; //.clear()모두 삭제	
			}
		}	
		
		//main메소드 안에 모든 복잡한 일처리를 다 집어넣게 되면
		//가독성(readability)가 떨어진다.
		//각각의 구체적인 일처리들은 메소드에게 맡기고
		//main에서는 해당 메소드를 호출하도록 구현하는 것이 가독성을 높이는 방법이다.
		
		
	}
}
