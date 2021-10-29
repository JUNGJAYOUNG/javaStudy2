package com.sist.file03;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class FileList extends JFrame implements ListSelectionListener, MouseListener, ActionListener {
	JList<Vector<String>> list;	//파일 목록 띄울곳
	JTextArea jta;	//텍스트 작성할 곳 
	String path = "c:/myData";
	
	//JList의 데이터를 위한 벡터를 선언
	Vector vector;
	
	public FileList() {
		
		//벡터를 생성합니다.
		vector = new Vector<String>();
		
		//디렉토리(폴더)도 File객체로 만든다.
		File dir = new File(path);
		
		//디렉토리안에 있는 모든 파일이름과 디렉토리이름의 목록을 배열로 갖고 온다.
		String []arr = dir.list();
		
		//디렉토리의 파일목록을 벡터에 담는다
		for(String str:arr) {
			vector.add(str);
		}
		
		//벡터의 내용으로 JList를 만든다.
		list = new JList<Vector<String>>(vector);
		
		//JList에 이벤트를 등록합니다.
		list.addListSelectionListener(this);
		list.addMouseListener(this);
	
		//JList도 JTextArea와 마찬가지로 프레임에 바로 담지않고 
		//JScrollPane으로 감싸서 담아야한다.
		
		JScrollPane jsp_list = new JScrollPane(list);

		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//삭제 버튼 만들기
		JButton btn_delete = new JButton("삭제");
		
		//버튼에 대하여 이벤트를 등록한다.
		btn_delete.addActionListener(this);
		
		add(jsp_list,BorderLayout.WEST);
		add(jsp_area,BorderLayout.CENTER);
		add(btn_delete,BorderLayout.SOUTH);
			
		setSize(800,600);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("리스트를 선택하였습니다.");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//JList에서 선택한 파일이름을 갖고 와요!
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		System.out.println(fileName);
		
		try {
			//선택한 파일이름과, 파일이 있는 경로를 합쳐서 File객체 혹은 문자열로 생성합니다.
			//파일을 읽기 위한 스트림을 생성
			FileReader fr = new FileReader(path+"/"+fileName);
			
			//파일의 내용을 모두 읽어와 누적하기 위한 문자열 변수를 만들고 ""으로 초기화
			String data = "";
			
			//파일로부터 한글자씩 읽어들이기 위한 변수를 선언한다.
			int ch;
			
			//파일의 모든내용을 읽어온다
			while(true) {
				//파일로부터 한글자씩 읽는다.
				ch=fr.read();
				
				//파일의 끝에 도달하면 읽어온 값은 -1, 그때 반복문을 탈출한다.
				if(ch==-1)
					break;
				
				//파일의 끝이 아니면 읽어온 문자를 data에 누적
				data+=(char)ch;
			}
			//현재 JList에서 선택한 파일의 내용을 다 읽어들이면 while 탈출
			//모든 내용은 문자열 변수 data에 저장되어있다.
			//이것을 textArea에 뿌린다.
			
			jta.setText(data);
			
			//사용한 파일은 닫아준다.
			fr.close();
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//삭제하기 위하여 삭제할 파일을 File객체로 만든다.
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		File file = new File(path+"/"+fileName);
		
		file.delete();
		
		//텍스트에리어를 깨끗이 비워준다.
		jta.setText("");
		
		//c:/myData 폴더의 파일목록 다시 읽어와서 Vector내용 바꾸고 
		//JList를 다시 그리도록 요청
		File dir = new File(path);
		String []arr = dir.list();
		
		//벡터를 깨끗이 지우고 다시 읽어온 파일목록을 담아준다.
		vector.clear();
		for(String f:arr) {
			vector.add(f);
		}
		
		//JList의 모양을 바귄 vector의 모양으로 바꿔줘야함
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다.");		
		
	}

}
