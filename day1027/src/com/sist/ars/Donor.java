package com.sist.ars;

//"성금자"를 위한 클래스를 쓰레드를 상속받아 구현한다.
public class Donor extends Thread{
	private String name;	//"성금자"의 이름을 위한 멤버변수
	private Account tvArs;	//"성금자"들이 모금액을 공유하기 위한 멤버변수
	

	public Donor(String name, Account tvArs) {
		this.name = name;
		this.tvArs = tvArs;
	}
	//쓰레드가 해야할 일을 run을 오버라이딩하여 써준다.
	public void run() {
		for(int i=1; ; i++) {	//계속반복
			
			if(tvArs.getBalance() >= 100000) {
				break;
			}
			
			tvArs.deposit(1000);
			System.out.println(name+"이 "+ i +"번째 입금하였습니다.");
			try {
				Thread.sleep(200);
			}catch(Exception e) {
				
			}
		}
	}
}
