package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	//적이 x축으로 움직이는 간격을 위한 변수
	//맨 처음에는 오른쪽끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정
	//int dx = -10;
	//int dy = 10;
	
	//적의 이동경로를 난수로 만든다
	int dx;
	int dy;
	
	//생성시에 "적"으로 표현할 그래픽 파일이름을 매개변수로 전달받아 
	//부모클래스의 생성자에게 전달한다.
	public Enermy(String name) {
		super(name);
		
		//맨 처음에 프로그램 실행하였을떄애 적의 위치를 오른쪽 상단에 위치시키기 위함
		//x=500;
		//y=0;
		
		//맨처음 적의 위치도 난수로 설정
		Random r = new Random();
		x=r.nextInt(500);
		y=r.nextInt(300);
		
		//적의 이동경로값을 생성시에 난수로 만든다
		//이동하는 최소값: 10
		//이동하는 최대값: 100
		//어떤 난수를 만들어서 90으로 나눈 나머지에다가 10을 더하면 된다.
		
		
		dx=r.nextInt() % 30;
		dy=r.nextInt() % 30;
			
		if(dx>=0) {
			dx+=10;
		}else {
			dx-=10;
		}
		
		if(dy>=10) {
			dy+=10;
		}else {
			dy-=10;
		}
		
		System.out.println("dx:"+x);
		System.out.println("dy:"+y);
		
	}
	
	public void update() {
		
		//x좌표를 dx만큼 변경시킴
		x+=dx;
		y+=dy;
		
		//x축으로 끝에 도달했으면 부호를 바꿔준다
		if(x<0 || x>500) {
			dx = dx * -1;
		}
		if(y<0 || y>300) {
			dy = dy * -1;
		}
		/*
		//만약 오른쪽 끝에 도달하면 다시 왼쪽으로 이동시키기 위하여 dx를 음수로 만든다.
		if(x>500) {
			dx = -10;
		}
		if(y>=300) {
			dy = -10;
		}
		if(y<0) {
			dy = 10;
		}
	*/	
	}
	
	//"적"(내가)이 "미사일"에 맞았는지 판별하는 메소드 정의
	public void crush(Missile missile){
		//"적"이 "미사일"에 맞았는지 판별
		if(missile.x>=x && missile.x<=x+30 && missile.y>=y && missile.y<=y+30) {
			y=-1000;	
			
			//소리파일 객체 생성
			File file = new File("EXPLODE.WAV");
			try {
				//오디오 파일을 읽어오기 위한 준비
				Clip clip = AudioSystem.getClip();
				//오디오파일 읽어오기
				clip.open(AudioSystem.getAudioInputStream(file));
				//오디오 파일 재생
				clip.start();
			}catch(Exception e) {
				
			}
		}
		
	}	
}
