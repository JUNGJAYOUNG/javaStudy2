package com.sist.note.copy;

public class Test {
	public static void main(String[] args) {
		String data = "�޸�.txt";
		
		//String []arr = data.split(".");
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		//��ħǥ(.)���δ� �и��� �� �����!
	
		String result = data.substring(0,data.indexOf("."));
		System.out.println(result);
	}
	
}