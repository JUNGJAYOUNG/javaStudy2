package com.sist.ars;

//"������"�� ���� Ŭ������ �����带 ��ӹ޾� �����Ѵ�.
public class Donor extends Thread{
	private String name;	//"������"�� �̸��� ���� �������
	private Account tvArs;	//"������"���� ��ݾ��� �����ϱ� ���� �������
	

	public Donor(String name, Account tvArs) {
		this.name = name;
		this.tvArs = tvArs;
	}
	//�����尡 �ؾ��� ���� run�� �������̵��Ͽ� ���ش�.
	public void run() {
		for(int i=1; ; i++) {	//��ӹݺ�
			
			if(tvArs.getBalance() >= 100000) {
				break;
			}
			
			tvArs.deposit(1000);
			System.out.println(name+"�� "+ i +"��° �Ա��Ͽ����ϴ�.");
			try {
				Thread.sleep(200);
			}catch(Exception e) {
				
			}
		}
	}
}
