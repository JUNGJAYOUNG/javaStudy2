package com.sist.exam01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;	//������ �������� �ܾ� �и�,(StringŬ������ split()�ᵵ ����)
import java.util.TreeMap;

public class WordCountTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("������ �Է��ϼ���-->");
		data = sc.nextLine(); //sc.nextLine()���� �Է¹޾ƾ� ��ĭ���� �Է¹��� �� �ִ�. 
		System.out.println(data);
		
		StringTokenizer st = new StringTokenizer(data); //�Է¹����� ���鹮�ڷ� �и�
		//����Ʈ���� ��ĭ���� �����°ſ���, �и��ڸ� ���� �ʾƵ� ok
		//�и��� ������ �ϳ��ϳ��� ��ū�̶�� �Ѵ�.
		
		
		TreeMap<String,Integer> map = new TreeMap<String, Integer>();
		//�ܾ key�� �ϰ� �󵵼��� value�� �Ͽ� �����ϱ� ���� map�� ����
		
		//token�� ������ true ������ false��ȯ
		while(st.hasMoreTokens()) {			//�Է¹������κ��� �и��� �ܾŭ �ݺ�����
			String word = st.nextToken();	//�и��� �ܾ �ϳ��� ������´�
			Integer cnt = map.get(word);	//null���� �ޱ� ���� Integer�� ���� 
			if(cnt == null) {
				map.put(word, 1);			//�󵵼��� 1 �� �����Ͽ� map�� �߰�
			}else {
				map.put(word, cnt+1);	//�ٽ� put�ϸ� key�� �ߺ��� ���� �ʱ� ������ �� ������ ��ü�� �ȴ�.
			}
		}
		//System.out.println(map);	
		
		//map�� �ִ� ��� key����� set���� ��ȯ�Ѵ�.
		Set<String> keyList = map.keySet();
		
		//set��ü���� �ݺ������ϱ� ���� ����� ����. �׷���
		//set�� �ڷḦ �ϳ��� ������ ���� ���� ���Ͽ� Iterator�� ������ �Ѵ�.
		Iterator<String> iter=keyList.iterator(); 
		//�ܾ �󵵼��� ��� �ִ� map�� key����� ��� �ִ� ���ͷ������� �����Ͱ� �ִ� ��ŭ �ݺ� ����
		while(iter.hasNext()) {	
			String word = iter.next(); 	//���ͷ����ͷκ��� �����͸� �������� �ܾ�. �� �ܾ�� map�� key
			int cnt = map.get(word);
			System.out.printf("%20s ---> %d\n",word,cnt);
		}
	}
}
