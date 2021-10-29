package com.sist.game;
//우리편(우주선)을 위한 클래스

import java.awt.event.KeyEvent;
public class SpaceShip extends GraphicObject {
	
	//생성시에 이미지파일명을 매개변수로 전달받아 부모의 생성자에 전달한다.
	public SpaceShip(String name) {
		super(name);
		//맨처음 우주선의 위치 x,y를 설정
		x=150;
		y=350;
	}
	
	//"우주선"에 눌러진 방향키에 따라 우주선의 위치를 이동시켜요.
	//매개변수로 전달받은 KeyEvent event를 통해서 어떤키가 눌러졌는지 알수 있다. 
	public void keyPressed(KeyEvent event) {
		
		//왼쪽방향키가 눌러지면
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			//x좌표를 왼쪽으로 이동시키기 위하여 10을 감소한다.
			x -=10;
		}
		//오른쪽 방향키
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			//x좌표를 오른쪽으로 이동시키기 위하여 10을 증가한다.
			x +=10;
		}
		//위쪽 방향키
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			//y좌표를 위쪽으로 이동시키기 위하여 10을 감소한다.
			y -=10;
		}
		//아래쪽 방향키
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			//y좌표를 아래쪽으로 이동시키기 위하여 10을 감소한다.
			y +=10;
		}
		
		
	}
}
