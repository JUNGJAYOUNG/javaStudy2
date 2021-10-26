package com.sist.game;
import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	//미사일이 발사되었는지 판별하기 위한 변수
	boolean launched = false;
	
	//생성시에 이미지파일이름을 매개변수로 전달받아
	public Missile(String name) {
		//부모의 생성자에게 전달합니다.
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		//만약에 미사일이 발사 되었다면 
		//y좌표를 1씩 감소
		if(launched) {
			y -=1;
		}
		//미사일의 y좌표가 화면의 눈에 안보이는 영역이면 launched에 false설정
		if(y <-100) {
			launched = false;
		}
	}

	//키보드가 눌러지면 현재 우주선이 있는 위치 x,y좌표에서부터 출발하여
	//미사일을 발사시키기 위하여 keyPressed 메소드를 오버라이딩 한다.
	//여기 매개변수로 전달받는 KeyEvent event를 통해서 어떤 key가 눌러졌는지 알 수 있따.
	//매개변수 x,y는 우주선의 위치 x,y를 전달받는다.
	public void keyPressed(KeyEvent event, int x, int y) {
		//눌러진 키가 스페이스바 라면
		if(event.getKeyCode()==KeyEvent.VK_SPACE) {
			launched = true;//미사일을 발사시키기 위하여 launched에 true설정
			this.x=x;	//미사일의 x,y좌표를 우주선의 x,y좌표로 설정
			this.y=y;
		}
	}
	
}
	
	
