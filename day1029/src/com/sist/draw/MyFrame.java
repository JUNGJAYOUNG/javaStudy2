package com.sist.draw;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

//MyFrame클래스 자신이 "JMenuItem"을 눌렀을때 이벤트처리 담당자가 되도록 하기 위하여
//ActionListener클래스를 구현하도록 한다.
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	//저장할 파일명과 열어올 파일명을 선택할 수 있도록 JFileChooser를 멤버변수로 선언
	JFileChooser jfc;
	
	//컬러다이어로그 생성
	JColorChooser jcc;
			

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser 객체를 생성
		jfc = new JFileChooser("c:/myData");
		
		//JColorChooser 객체 생성
		jcc = new JColorChooser();
		
		//메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		//주메뉴 "파일" 생성
		JMenu mn_file = new JMenu("파일");
		//주메뉴 "그리기도구" 생성
		JMenu mn_draw = new JMenu("그리기도구");
		//주메뉴 "그리기색상" 생성
		JMenu mn_color = new JMenu("그리기색상");
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
		
		//주메뉴 그리기색상에 담길 부메뉴 만들기
		JMenuItem color_red = new JMenuItem("빨강");
		JMenuItem color_blue = new JMenuItem("파랑");
		JMenuItem color_green = new JMenuItem("초록");
		JMenuItem color_other = new JMenuItem("다른색상");
		
		//"빨강","파랑","초록","다른색상"들을 "그리기색상" 주메뉴에 담는다
		mn_color.add(color_red);
		mn_color.add(color_blue);
		mn_color.add(color_green);
		mn_color.add(color_other);
		
		//"주메뉴"를 "메뉴바"에 담는다.
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
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
				
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);
		
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
				//어디에 어떤이름으로 저장할지 선택하도록 JFileChooser 다이어로그를 띄운다
				System.out.println("저장");
				int re=jfc.showSaveDialog(this);
				
				//저장하기 다이어로그에서 저장을 누를수도, 취소를 누를수도 있다.
				//저장을 누르면 0이 반환된다.
				if(re == 0) {
					//다이어로그에서 선택한 파일을 갖고 온다.
					File file = jfc.getSelectedFile();
					
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(lp.list);
					oos.close();
				}	
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("열기")) {
			//JFileChooser를 이용하여 열어올 파일을 선택하도록 구현
			//"새파일"에 대한 기능도 구현해보기
			
			try {
				System.out.println("열기");
				int re=jfc.showOpenDialog(this);
				if(re == 0) {
					File file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					//파일로 데이터를 읽어들여 Linepanel 객체인 lp의 list에 담는다
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
					//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위해 호출
					lp.repaint();
					//파일을 닫아준다.
					ois.close();
				}
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
				
		}else if(cmd.equals("새파일")) {
			lp.list.clear();
			repaint();
		}else if(cmd.equals("선")) {
			lp.drawType=0;
		}else if(cmd.equals("사각형")) {
			lp.drawType=1;
		}else if(cmd.equals("원")) {
			lp.drawType=2;
		}else if(cmd.equals("빨강")) {
			lp.drawColor = Color.RED;
		}else if(cmd.equals("파랑")) {
			lp.drawColor = Color.BLUE;
		}else if(cmd.equals("초록")) {
			lp.drawColor = Color.GREEN;
		}else if(cmd.equals("다른색상")) {
			Color color = jcc.showDialog(this,"그리기색상",Color.RED);
			if(color!=null) {
				lp.drawColor=color;
			}
		}
	}
}