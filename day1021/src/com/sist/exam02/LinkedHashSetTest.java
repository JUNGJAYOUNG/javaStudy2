package com.sist.exam02;
import java.util.*;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set = new LinkedHashSet();
		set.add("���");
		set.add("����");
		set.add("����");
		System.out.println(set);
		set.add("�ٳ���");	//LinkedHashSet�� ���� �����ϱ� ������ �߰��� �״�� ��µ�
		set.add("���");		//set�� �ߺ��� ������� �ʱ� ������ �߰� �ȵȴ�.
		System.out.println(set);
	}

}
