package com.sist.exam02;

class Hobitt extends GameCharacter{
	@Override
	public void draw(){
		System.out.println("호빗을 그립니다.");
	}
	public void getRing(){
		System.out.println("GameCharacter의 getRing()");
	}
}
