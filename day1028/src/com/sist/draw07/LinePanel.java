package com.sist.draw07;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener{
	int x1= 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//"선"을 그릴것인지 "원"을 그릴것진 "사각형"을 그릴것인지를 위한 맴버변수를 만들어요
	//선:0
	//원:1
	//사각형:2
	int drawType;
	
	//JFrame frame;
	
	//사용자가 그린 "선"들을 담기 위한 리스를 선언해요!
	ArrayList<GraphicInfo> list;
	
	//생성자에서 "마우스 이벤트"를 등록해 줍니다.
	public LinePanel() {
		//this.frame = frame;
		//리스트를 생성합니다.
		list = new ArrayList<GraphicInfo>();
		
		//this의 의미는 마우스이벤트가 발생하였을때 이벤트처리 담당객체가 "자신"이라는 의미입니다.
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		//System.out.println("다시그려줍니다!");
		//g.drawLine(x1,y1,x2,y2);
		super.paintComponent(g);
		
		//리스트에 담긴 모든 "선"을 그려줍니다.
		for( GraphicInfo info  :list  ) {
			x1 = info.getX1();
			y1 = info.getY1();
			x2 = info.getX2();
			y2 = info.getY2();
			int width = x2 - x1;
			int height = y2 - y1;
			
			switch(info.getDrawType()) {
				case 0:g.drawLine(x1,y1,x2,y2);break;
				case 1:g.drawRect(x1,y1,width,height);break;
				case 2:g.drawOval(x1,y1,width,height);break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		
		//하나의 "선"이 완성될때에 리스트 선의 시작점x, 시작점y, 끝점x, 끝점y를 갖고 있는 GraphicInfo객체를 생성하여 
		//리스트에 담아요!
		list.add(new GraphicInfo(x1, y1, x2, y2,drawType));
		repaint();
		//frame.repaint(100, 0, 0,600, 400);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
