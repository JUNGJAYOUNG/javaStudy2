package com.sist.exam11;

public class CountDown implements Runnable{
	
	//thread �� �ؾ��ϴ� ���� run�޼ҵ带 �������̵�
	public void run() {
		// TODO Auto-generated method stub
		for(int i=20;i>0;i--) {
			System.out.println(i+"�� ���Դϴ�.");
			try {
				Thread.sleep(1000);	//1�ʾ� ����.
				//sleep()�� exception�� �����ϱ� ������ try�� �ȿ� ������Ѵ�.
			}catch(Exception e) {
					
			}
		}
	}
}

