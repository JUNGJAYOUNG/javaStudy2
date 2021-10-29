package com.sist.ars;

public class TVArsTest {
	public static void main(String[] args) {
		
		Account account = new Account();	
		
		Donor d1 = new Donor("김수연", account);
		Donor d2 = new Donor("김시아", account);
		Donor d3 = new Donor("임상진", account);
		Donor d4 = new Donor("윤태인", account);
		Donor d5 = new Donor("정자영", account);
	
		//5명의 성금자들이 공평하게 입금하도록 쓰레드를 가동시킨다.
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		//쓰레드의 작업이 완료될때까지 대기시키기 위해 join()메소드를 호출
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("전체모금액: "+account.getBalance());
	
	}
}
