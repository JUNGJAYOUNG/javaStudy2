package com.sist.exam01;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car car = new Car("K5", "���");
		//car.speedUp(100);
		//car.speedDown(50);
		
		Movable m = new Car();
		//�������̽��� Ŭ������ ���������� �ڷ����� �����̴�.
		//�������̽��� ������ Ŭ�������̿��� Ŭ������ ���������� 
		//��Ӱ��迡 �ְ� �ȴ�. 
		//�����������̽��� ���������� Ŭ������ ��ü�� ������ �� �ִ�!
		m.speedUp(100);
		m.speedDown(50);
		
		((Car)m).turnLeft();
		((Car)m).turnRight();
		//���Ӱ� �߰��� �޼Ҵ� ȣ��x ����ȯ �ʿ�
		
		//Car c = m; 
		//�Ұ���
		
		Car c = (Car)m;
		//����
		//��Ӱ��迡 �ִ� �θ��� ���������� �ڽ�Ŭ������ ��ü�� �����ϰ�
		//�ִ� ��� �ش��ڽ�Ŭ������ ����ȯ�Ͽ� ������ �� �ִ�. 
		Movable m2 = c;
		//����
		//�θ��� ���������� �ڽ�Ŭ������ ��ü�� ������ �� �ִ�. 
		
		Movable m3 = (Movable)c;
		//��Ӱ��迡 ������ �ڽ�Ŭ������ ����ü�� �θ��� �ڷ�������
		//����ȯ ����
	
	
	}

}
