package com.sist.file;
import javax.swing.*;


public class FileList extends JFrame{
	JList<String> list;
	
	public FileList() {
		String []arr = {"사과","포도","수박","딸기","사과","포도","수박","딸기","사과","포도","수박","딸기","사과","포도","수박","딸기"};
		list = new JList<String>(arr);
		
		//JList도 JTextArea와 마찬가지로 프레임에 바로 담지않고 
		//JScrollPane으로 감싸서 담아야한다.
		
		JScrollPane jsp_list = new JScrollPane(list);
		add(jsp_list);
		
		setSize(400,300);
		setVisible(true);
	}
}
