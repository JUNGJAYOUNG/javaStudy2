package com.sist.ars;

public class TVArsTest {
	public static void main(String[] args) {
		
		Account account = new Account();	
		
		Donor d1 = new Donor("�����", account);
		Donor d2 = new Donor("��þ�", account);
		Donor d3 = new Donor("�ӻ���", account);
		Donor d4 = new Donor("������", account);
		Donor d5 = new Donor("���ڿ�", account);
	
		//5���� �����ڵ��� �����ϰ� �Ա��ϵ��� �����带 ������Ų��.
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		//�������� �۾��� �Ϸ�ɶ����� ����Ű�� ���� join()�޼ҵ带 ȣ��
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("��ü��ݾ�: "+account.getBalance());
	
	}
}