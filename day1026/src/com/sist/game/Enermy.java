package com.sist.game;

public class Enermy extends GraphicObject {
	//적이 x축으로 움직이는 간격을 위한 변수
	//맨 처음에는 오른쪽끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정
	int dx = -10;
	
	//생성시에 "적"으로표현할 그래픽 파일이름을 매개변수로 전달받아 
	//부모클래스의 생성자에게 전달한다.
	public Enermy(String name) {
		super(name);
		
		//맨 처음에 프로그램 실행하였을떄애 적의 위치를 오른쪽 상단에 위치시키기 위함
		x=500;
		y=0;
	}
	
	public void update() {
		
		//x좌표를 dx만큼 변경시킴
		x+=dx;
		
		//만약 왼쪽끝에 도달하면 오른쪼긍로 이동시키기 위하여 dx를 양수로 만든다.
		if(x<0) {
			dx = 10;
		}
		//만약 오른쪽 끝에 도달하면 다시 왼쪽으로 이동시키기 위하여 dx를 음수로 만든다.
		if(x>500) {
			dx = -10;
		}
	}
}
