package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener {
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	
	//생성자에 즉, 패널이 생성되고 동시에 동작하여
	public MyPanel() {
		super();
		this.addKeyListener(this);	//패널의 키보드 이벤트를 요청
		this.requestFocus();		//패널의 키보드 요청을 설정 a
		setFocusable(true);			//패널에 포커스 설정 b
		//패널은 원래부터 키보드로부터 입력받아 들이는 용도가 아니기 때문에
		//키보드로부터 입력을 받아들이게 하려면 포커스설정이 필요(a,b 필요)
		
		enermy = new Enermy("enermy.png");				//이미지 파일로 각각 개체 생성
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		
		//패널의 구성요소인 적,미사일,우주선이 서로 동시에 움직이도록 하기 위하여
		//멀티쓰레드로 구현한다.
		//이기능은 패널에서만 필요하다.
		//이럴때에 클래스를 클래스안에 만들수 있다.
		//이것을 inner class라고 한다.
		class MyThread extends Thread{	//thread 상속받아 멀티클래스 구현
			public void run() {			//run 오버라이딩하여 동시에 실행시킬 명령어 작성										//
				while(true) {				
					enermy.update();
					spaceship.update();
					missile.update();
					enermy.crush(missile);
		
					repaint();	//변경된 위치에 다시 그리기
								//화면에 그래픽을 그려주는 메소드는 painComponent인데
								//사용자는 repaint를 호출하여 이를 동작시킬수있다. 직접호출x
					
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
						
					}
				}
			}
		}
		Thread t = new MyThread(); //MyThread의 부모가 Thread니까 참조 가능
		t.start();
	}
	@Override
	public void paintComponent(Graphics g) {	//화면에 그림을 그린다.
		super.paintComponent(g);
		
		enermy.draw(g); //그래픽스를 전달하여 이미지를 다시 그린다.
		spaceship.draw(g);	
		missile.draw(g);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {	//키보드 이벤트 전달
		// TODO Auto-generated method stub
		spaceship.keyPressed(event);
		missile.keyPressed(event,spaceship.x,spaceship.y);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
