package com.sist.lab04;

class Test 
{
	public static void drawAll(Object []arr){	//9번
		for(Object g :arr){	
			if(g instanceof Hobitt) {
				((Hobitt)g).draw();
			}else if(g instanceof Titan) {
				((Titan)g).draw();
			}else if(g instanceof Sorcerer) {
				((Sorcerer)g).draw();
			}
		} 
	}
	public static void main(String[] args) 
	{
		GameCharacter g1 = new Hobitt();
		GameCharacter g2 = new Hobitt();
		GameCharacter g3 = new Titan();
		GameCharacter g4 = new Titan();
		GameCharacter g5 = new Sorcerer();
		GameCharacter g6 = new Sorcerer();
		
		g1.getLife();
		//g1.getRing();	//에러발생! 자식클래스에서만 정의된 메소드여서 부모클래스 참조변수로는 접근 못함.
		((Hobitt)g1).getRing(); //성공! 자료형을 자식클래스로 형변환해주고 메소드를 호출해야함.
	
		GameCharacter []array = {g1,g2,g3,g4,g5,g6}; //6번 GameCharacter type
		drawAll(array);
	}

}
