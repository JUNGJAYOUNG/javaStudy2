package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		Random r = new Random();
		int com = r.nextInt(3);
		
		System.out.println("0:가위, 1:바위, 2:보");
		System.out.println("선택하세요=>");
		int user = sc.nextInt();
		
		System.out.println("컴퓨터는 "+map.get(com)+"을 내었습니다.");
		System.out.println("당신은 "+map.get(user)+"를 내었습니다.");
		
		
		if(com==user) {	//비기는경우
			System.out.println("비겼습니다.");
		}else if(user==0&&com==2 || user==1&&com==0 || user==2&&com==1){	//사용자가 이기는 경우
			System.out.println("당신이 이겼습니다.");
		}else {	//사용자가 지는 경우
			System.out.println("컴퓨터가 이겼습니다.");
		}
	}
}
