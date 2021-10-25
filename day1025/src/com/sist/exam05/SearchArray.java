package com.sist.exam05;

public class SearchArray {
	//search 메소드 body안에 예외 객체가 생성될 수 있다.
	//메소드 안에서 직접 try~catch로 예외처리 할 수도 있고
	//메소드 호출하는 쪽으로 예외를 전파할 수도 있다.
		
	public static int search(int []arr, int value) throws NotFoundException{
		int index = -1;	//초기값을 -1로 주는 이유는 배열의 인덱스는 0부터니까 인덱스가 아닌값을 설정하기 위해
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] ==value) {
				index = i;
			}
		}
		//value를 배열에서 못찾았으면 예외 발생 시킴
		if(index == -1) {
			throw new NotFoundException("배열에 찾는값 "+value+"가(이) 없습니디!");
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		try {
			int []data = {2,4,10,9,6};
			int n = search(data,100);
			System.out.println(n);
		}catch(NotFoundException e) {
			System.out.println("예외발생: "+e.getMessage());
		}			
	}
}
