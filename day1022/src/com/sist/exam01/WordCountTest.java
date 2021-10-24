package com.sist.exam01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;	//구분자 기준으로 단어 분리,(String클래스의 split()써도 무방)
import java.util.TreeMap;

public class WordCountTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("문장을 입력하세요-->");
		data = sc.nextLine(); //sc.nextLine()으로 입력받아야 빈칸까지 입력받을 수 있다. 
		System.out.println(data);
		
		StringTokenizer st = new StringTokenizer(data); //입력문장을 공백문자로 분리
		//디폴트값이 빈칸으로 나누는거여서, 분리자를 주지 않아도 ok
		//분리된 데이터 하나하나를 토큰이라고 한다.
		
		
		TreeMap<String,Integer> map = new TreeMap<String, Integer>();
		//단어를 key로 하고 빈도수를 value로 하여 저장하기 위한 map을 생성
		
		//token이 있으면 true 없으면 false반환
		while(st.hasMoreTokens()) {			//입력문장으로부터 분리한 단어만큼 반복실행
			String word = st.nextToken();	//분리한 단어를 하나씩 끄집어내온다
			Integer cnt = map.get(word);	//null값도 받기 위해 Integer로 생성 
			if(cnt == null) {
				map.put(word, 1);			//빈도수를 1 로 설정하여 map에 추가
			}else {
				map.put(word, cnt+1);	//다시 put하면 key가 중복이 되지 않기 떄문에 이 값으로 대체가 된다.
			}
		}
		//System.out.println(map);	
		
		//map에 있는 모든 key목록을 set으로 반환한다.
		Set<String> keyList = map.keySet();
		
		//set자체에는 반복수행하기 위한 기능이 없다. 그래서
		//set의 자료를 하나씩 끄집어 내어 오기 위하여 Iterator로 만들어야 한다.
		Iterator<String> iter=keyList.iterator(); 
		//단어별 빈도수가 담겨 있는 map의 key목록을 담고 있는 이터레이터의 데이터가 있는 만큼 반복 실행
		while(iter.hasNext()) {	
			String word = iter.next(); 	//이터레이터로부터 데이터를 꺼내오는 단어. 그 단어는 map의 key
			int cnt = map.get(word);
			System.out.printf("%20s ---> %d\n",word,cnt);
		}
	}
}
