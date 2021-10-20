package com.sist.exam01;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car car = new Car("K5", "흰색");
		//car.speedUp(100);
		//car.speedDown(50);
		
		Movable m = new Car();
		//인터페이스도 클래스와 마찬가지로 자료형의 개념이다.
		//인터페이스를 구현한 클래스사이에는 클래스와 마찬가지로 
		//상속관계에 있게 된다. 
		//상위인터페이스의 참조변수가 클래스의 객체를 참조할 수 있다!
		m.speedUp(100);
		m.speedDown(50);
		
		((Car)m).turnLeft();
		((Car)m).turnRight();
		//새롭게 추가된 메소다 호출x 형변환 필요
		
		//Car c = m; 
		//불가능
		
		Car c = (Car)m;
		//가능
		//상속관계에 있는 부모의 참조변수가 자식클래스의 객체를 참조하고
		//있는 경우 해당자식클래스로 형변환하여 대입할 수 있다. 
		Movable m2 = c;
		//가능
		//부모의 참조변수가 자식클래스의 객체를 참조할 수 있다. 
		
		Movable m3 = (Movable)c;
		//상속관계에 있을때 자식클래스의 개ㄱ체를 부모의 자료형으로
		//형변환 가능
	
	
	}

}
