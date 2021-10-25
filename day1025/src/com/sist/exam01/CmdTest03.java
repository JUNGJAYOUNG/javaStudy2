//���α׷� ����ÿ� url�� ���޹޾�
//url�� ���� �ش� �޼ҵ带 ���۽�Ű�� ���α׷�
//java CmdTest http://www.sist.co.kr/insert.do
//�Խù��� ����Ͽ����ϴ�.

package com.sist.exam01;

import java.io.FileReader;
import java.util.*;

public class CmdTest03{
	
	public static void main(String[] args) throws Exception {
		//����ڰ� ��û�ϴ� ���񽺸��� key�� �ϰ� ��ó����� ��ü�� value�� ��� ���� map�� ����
		HashMap<String,SistAction> map = new HashMap<String,SistAction>();
		//���񽺸�� ��ó�����Ŭ�������� �ִ� ���ϰ�ü�� ������.
		FileReader fr = new FileReader("sist.properties");
		//������ ������ key�� value�� �����ϱ� ���� ��ü�� ������.
		Properties prop = new Properties();
		//������ ������ �о����.
		prop.load(fr);
		//������Ƽ ���Ϸκ��� key���(���񽺸�)�� �ݺ��� ��ü�� ������.
		Iterator iter = prop.keySet().iterator();
		
		//key�� �ִ¸�ŭ �ݺ�����
		while(iter.hasNext()) {
			String cmd = (String)iter.next();
			String clsName = (String) prop.get(cmd);
			//System.out.println(cmd+","+clsName);
			SistAction obj = (SistAction) Class.forName(clsName).newInstance();
			map.put(cmd, obj);
		}

		//�Ź� ���ο� ���񽺰� �߰��ɶ����� �ڵ带 �����ؾ� �ϴµ�
		//������ ���������� ����� �ڵ��� ������� ���ο� ���񽺸� ����ϵ��� �Ѵ�.
		
		String url = args[0];
		String cmd = url.substring(url.lastIndexOf("/")+1);
		//java CmdTest http://www.sist.co.kr/update.do
		//update.do
		
		SistAction action=map.get(cmd);
		action.pro();
	}
	
}
