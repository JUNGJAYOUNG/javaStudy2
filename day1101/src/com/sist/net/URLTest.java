package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		
		try {
			//���ͳݻ��� ������ü�� �����Ѵ�.
			URL url = new URL("https://www.hanbit.co.kr/");
			
			//�� ������ ������ �о���̱� ���Ͽ� ��Ʈ���� �����մϴ�.
			InputStream is = url.openStream();
			
			//�ѹ��� �о���� byte���� �迭�� �����
			byte []data = new byte[100];
			
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ �����.
			String str = "";
			
			//��Ʈ���� ���� �ƴҶ����� 100����Ʈ�� �о���δ�.
			while(is.read(data) != -1) {
				//�о�帰 byte���� ���ڿ��� ���� �����Ѵ�.
				str += new String(data,"utf-8");
			}
			System.out.println(str);
			
			is.close();
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
}
