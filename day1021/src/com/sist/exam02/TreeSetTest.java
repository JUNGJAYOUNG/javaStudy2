package com.sist.exam02;
import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		
		set.add("���");
		set.add("����");
		set.add("����");
		System.out.println(set);
		set.add("�ٳ���");	
		set.add("���");		
		set.add("��");		
		set.add("��");		
		System.out.println(set);	//TreeSet ������ ��������(�ߺ�x)
		System.out.println(set.size());
		
		set.remove("����");
		System.out.println(set);
		System.out.println(set.size());
	}
}
