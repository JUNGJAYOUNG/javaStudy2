package com.sist.exam01;

public class SetPriorityTest {
	public static void main(String[] args) {
		
		Person kim = new Person("김유신");
		Person hong = new Person("홍길동");
		Person lee = new Person("이순신");
		//lee.setPriority(10);
		
		lee.setPriority(Thread.MAX_PRIORITY);
		//최고우선순위로 설정하였다고 반드시 일이 가장 먼저 끝나는 것이 보장되지 x
		//가급적 일을 빨리 끝내달라고 "응급성"을 설정하는 것 뿐이다.
		kim.start();
		hong.start();
		lee.start();
		
		//kim, hong, lee 쓰레드가 모두 끝날때까지 대기시킨다.
		try {
			kim.join();
			hong.join();
			lee.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("kim의 우선순위:"+kim.getPriority());  //5(우선순위 기본값)
		System.out.println("hong의 우선순위:"+hong.getPriority()); //그래픽스를 전달하여 이미지를 다시 그린다.hong.getPriority()); //5
		System.out.println("lee의 우선순위:"+lee.getPriority()); //10
	}
}
