package com.sist.exam12;

public class CountDown extends Thread{
	
	//thread �� �ؾ��ϴ� ���� run�޼ҵ带 �������̵�
	public void run() {
		// TODO Auto-generated method stub
		for(int i=20;i>0;i--) {
			System.out.println(i+"�� ���Դϴ�.");
			try {
				Thread.sleep(1000);	//sleep�� exception�� �����ϱ� ������ try�� �ȿ� ������Ѵ�.
			}catch(Exception e) {
					
			}
		}
	}
}

