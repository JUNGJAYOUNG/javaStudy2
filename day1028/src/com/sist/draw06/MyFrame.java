package com.sist.draw06;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//MyFrame클래스 자신이 "JMenuItem"을 눌렀을때 이벤트처리 담당자가 되도록 하기 위하여
//ActionListener클래스를 구현하도록 한다.
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		//주메뉴 "파일" 생성
		JMenu mn_file = new JMenu("파일");
		//주메뉴 "그리기도구" 생성
		JMenu mn_draw = new JMenu("그리기도구");
		//부메뉴 "새파일" 생성
		JMenuItem file_new = new JMenuItem("새파일");
		//부메뉴 "열기" 생성
		JMenuItem file_open = new JMenuItem("열기");
		//부메뉴 "저장" 생성
		JMenuItem file_save = new JMenuItem("저장");
		
		//주메뉴 "그리기도구"에 담길 부메뉴들을 만든다.
		JMenuItem draw_line = new JMenuItem("선"); 
		JMenuItem draw_rect = new JMenuItem("사각형"); 
		JMenuItem draw_oval = new JMenuItem("원"); 
		
		//"부메뉴"들을 "주메뉴"에 담는다.
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//"부메뉴"들을 "주메뉴"에 담는다.
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);
		
		//"주메뉴"를 "메뉴바"에 담는다.
		jmb.add(mn_file);
		jmb.add(mn_draw);
		
		//"메뉴바"를 "프레임
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대하여 이벤트를 등록한다.
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//그리기 도구의 부메뉴들에 이벤트를 등록한다.
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
	}
	//각각의 JMenuItem을 누르면 actionPerformed 메소드가 동작한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem중에 어떤 메뉴가 눌러졌는지 파악하기 위하여 매개변수
		//ActionEvent의 getActionCommand()를 이용한다.
		
		String cmd = e.getActionCommand();
		//System.out.println(cmd +"가 눌러짐");
		
		if(cmd.equals("저장")) {
			try {
				//현재 화면에 그려진 모든 "선"들을 파일로 저장한다.
				//("c:/myData/data.pan")
				//현재 화면에 그려진 모든 선들의 정보는 LinePanel 객체인
				//lp의 list에 담겨져있다. 
				//list객체를 통째로 파일로 출력하기 위하여
				//ObjectOutputStream을 이용
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				//LinePanel 객체의 멤버변수인 list를 파일로 출력한다.
				oos.writeObject(lp.list);
				oos.close();
				
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("열기")) {
			
			//"c:/myData/data.pan"파일의 내용을 읽어들여
			//LinePanel 객체인 lp의 list에 저장하도록 한다
			//화면을 다시 그리기 위하여 LinePanel의 객체인 lp의 repaint를 호출한다.
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				//파일로 데이터를 읽어들여 Linepanel 객체인 lp의 list에 담는다
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위해 호출
				lp.repaint();
				//파일을 닫아준다.
				ois.close();
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
				
		}else if(cmd.equals("새파일")) {
			System.out.println("새파일의 처리입니다.");
		}else if(cmd.equals("선")) {
			lp.drawType=0;
		}else if(cmd.equals("사각형")) {
			lp.drawType=1;
		}else if(cmd.equals("원")) {
			lp.drawType=2;
		}
	}
}
