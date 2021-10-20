package com.sist.lab04;

class Sorcerer extends GameCharacter{
	@Override
	public void draw(){
		System.out.println("주술사를 그립니다.");
	}
	public void getRing(){
		System.out.println("Sorcerer()의 getRing()");
	}
}
