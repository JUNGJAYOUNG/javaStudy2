package com.sist.lab04;

class Test 
{
	public static void drawAll(Object []arr){	//9��
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
		//g1.getRing();	//�����߻�! �ڽ�Ŭ���������� ���ǵ� �޼ҵ忩�� �θ�Ŭ���� ���������δ� ���� ����.
		((Hobitt)g1).getRing(); //����! �ڷ����� �ڽ�Ŭ������ ����ȯ���ְ� �޼ҵ带 ȣ���ؾ���.
	
		GameCharacter []array = {g1,g2,g3,g4,g5,g6}; //6�� GameCharacter type
		drawAll(array);
	}

}
