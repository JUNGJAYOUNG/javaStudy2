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
	JList<Vector<String>> list;	//���� ��� ����
	JTextArea jta;	//�ؽ�Ʈ �ۼ��� �� 
	String path = "c:/myData";
	
	//JList�� �����͸� ���� ���͸� ����
	Vector vector;
	
	public FileList() {
		
		//���͸� �����մϴ�.
		vector = new Vector<String>();
		
		//���丮(����)�� File��ü�� �����.
		File dir = new File(path);
		
		//���丮�ȿ� �ִ� ��� �����̸��� ���丮�̸��� ����� �迭�� ���� �´�.
		String []arr = dir.list();
		
		//���丮�� ���ϸ���� ���Ϳ� ��´�
		for(String str:arr) {
			vector.add(str);
		}
		
		//������ �������� JList�� �����.
		list = new JList<Vector<String>>(vector);
		
		//JList�� �̺�Ʈ�� ����մϴ�.
		list.addListSelectionListener(this);
		list.addMouseListener(this);
	
		//JList�� JTextArea�� ���������� �����ӿ� �ٷ� �����ʰ� 
		//JScrollPane���� ���μ� ��ƾ��Ѵ�.
		
		JScrollPane jsp_list = new JScrollPane(list);

		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//���� ��ư �����
		JButton btn_delete = new JButton("����");
		
		//��ư�� ���Ͽ� �̺�Ʈ�� ����Ѵ�.
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
		//System.out.println("����Ʈ�� �����Ͽ����ϴ�.");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//JList���� ������ �����̸��� ���� �Ϳ�!
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		System.out.println(fileName);
		
		try {
			//������ �����̸���, ������ �ִ� ��θ� ���ļ� File��ü Ȥ�� ���ڿ��� �����մϴ�.
			//������ �б� ���� ��Ʈ���� ����
			FileReader fr = new FileReader(path+"/"+fileName);
			
			//������ ������ ��� �о�� �����ϱ� ���� ���ڿ� ������ ����� ""���� �ʱ�ȭ
			String data = "";
			
			//���Ϸκ��� �ѱ��ھ� �о���̱� ���� ������ �����Ѵ�.
			int ch;
			
			//������ ��系���� �о�´�
			while(true) {
				//���Ϸκ��� �ѱ��ھ� �д´�.
				ch=fr.read();
				
				//������ ���� �����ϸ� �о�� ���� -1, �׶� �ݺ����� Ż���Ѵ�.
				if(ch==-1)
					break;
				
				//������ ���� �ƴϸ� �о�� ���ڸ� data�� ����
				data+=(char)ch;
			}
			//���� JList���� ������ ������ ������ �� �о���̸� while Ż��
			//��� ������ ���ڿ� ���� data�� ����Ǿ��ִ�.
			//�̰��� textArea�� �Ѹ���.
			
			jta.setText(data);
			
			//����� ������ �ݾ��ش�.
			fr.close();
			
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
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
		//�����ϱ� ���Ͽ� ������ ������ File��ü�� �����.
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		File file = new File(path+"/"+fileName);
		
		file.delete();
		
		//�ؽ�Ʈ����� ������ ����ش�.
		jta.setText("");
		
		//c:/myData ������ ���ϸ�� �ٽ� �о�ͼ� Vector���� �ٲٰ� 
		//JList�� �ٽ� �׸����� ��û
		File dir = new File(path);
		String []arr = dir.list();
		
		//���͸� ������ ����� �ٽ� �о�� ���ϸ���� ����ش�.
		vector.clear();
		for(String f:arr) {
			vector.add(f);
		}
		
		//JList�� ����� �ٱ� vector�� ������� �ٲ������
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�.");		
		
	}

}
