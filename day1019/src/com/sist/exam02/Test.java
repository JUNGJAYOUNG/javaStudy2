package com.sist.exam02;

class Test 
{
	
/*
	public static void drawAll(GameCharacter []arr){	//9��
		for(GameCharacter character :arr){	
			//((Hobbit)character).getRing();				
		}
	}
	�����߻� -> �迭�ȿ��� ȣ���� �ְ� Ÿ��ź�� �ְ� �ּ��絵 �ִµ�
	������� ȣ������ ����ȯ�߱� ������ �����߻�!!!!!
	ȣ������ ����� ����ȯ�ؾ���!!!!
*/	
	public static void drawAll(GameCharacter []arr){	//9��
		for(GameCharacter character :arr){	
			character.draw();
			if(character instanceof Hobitt) {
				((Hobitt)character).getRing();
			}				
		}
	}
	
	/*	
	public static void drawAll(Object []arr){	//9��
		for(Object character :arr){	
			//character.draw(); ȣ��Ұ�
			((GameCharacter)character).draw(); //����
			
		}
	}
*/
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
