//프로그램 실행시에 url을 전달받아
//url에 따라 해당 메소드를 동작시키는 프로그램
//java CmdTest http://www.sist.co.kr/insert.do
//게시물을 등록하였습니다.

package com.sist.exam01;

import java.io.FileReader;
import java.util.*;

public class CmdTest03{
	
	public static void main(String[] args) throws Exception {
		//사용자가 요청하는 서비스명을 key로 하고 일처리담당 객체를 value로 담기 위한 map을 생성
		HashMap<String,SistAction> map = new HashMap<String,SistAction>();
		//서비스명과 일처리담당클래스명이 있는 파일객체를 생성함.
		FileReader fr = new FileReader("sist.properties");
		//파일의 내용을 key와 value로 관리하기 위한 객체를 생성함.
		Properties prop = new Properties();
		//파일의 내용을 읽어들임.
		prop.load(fr);
		//프로퍼티 파일로부터 key목록(서비스명)을 반복자 객체로 생성함.
		Iterator iter = prop.keySet().iterator();
		
		//key가 있는만큼 반복실행
		while(iter.hasNext()) {
			String cmd = (String)iter.next();
			String clsName = (String) prop.get(cmd);
			//System.out.println(cmd+","+clsName);
			SistAction obj = (SistAction) Class.forName(clsName).newInstance();
			map.put(cmd, obj);
		}

		//매번 새로운 서비스가 추가될때마다 코드를 변경해야 하는데
		//별도의 설정파일을 만들어 코드의 변경없이 새로운 서비스를 등록하도록 한다.
		
		String url = args[0];
		String cmd = url.substring(url.lastIndexOf("/")+1);
		//java CmdTest http://www.sist.co.kr/update.do
		//update.do
		
		SistAction action=map.get(cmd);
		action.pro();
	}
	
}
