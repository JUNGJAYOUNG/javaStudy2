package com.sist.file;
import javax.swing.*;


public class FileList extends JFrame{
	JList<String> list;
	
	public FileList() {
		String []arr = {"���","����","����","����","���","����","����","����","���","����","����","����","���","����","����","����"};
		list = new JList<String>(arr);
		
		//JList�� JTextArea�� ���������� �����ӿ� �ٷ� �����ʰ� 
		//JScrollPane���� ���μ� ��ƾ��Ѵ�.
		
		JScrollPane jsp_list = new JScrollPane(list);
		add(jsp_list);
		
		setSize(400,300);
		setVisible(true);
	}
}
