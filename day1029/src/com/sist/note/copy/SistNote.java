package com.sist.note.copy;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//"�θ޴�" "������", "����","����"�� �������� �̺�Ʈó���� ���Ͽ� ActionListener�������̽��� �����ϵ��� �մϴ�.
public class SistNote extends JFrame implements ActionListener{
	boolean isModified =false;
	String fileName = "���� ����";
	
	//�޸����� �Է� �� ����� ���Ͽ� "������"�� ������ �Է��Ҽ� �ִ� JTextArea�� �ɹ������� �����ؿ�.
	JTextArea jta;
	
	//������ �����̸��� ����� �����̸��� �����ϱ� ���� JFileChooser�� �ɹ������� �����ؿ�.
	JFileChooser jfc;
	
	//�����ڿ��� JTextArea��ü�� �����Ͽ� �����ӿ� ��ƿ�
	public SistNote() {
		jta = new JTextArea();
		
		
		//JFileChooser ��ü�� �����մϴ�.
		jfc = new JFileChooser("c:/myData");
		
		//add(jta);
		//�ؽ�Ʈ����� �ٷ� �����ӿ� ������ 
		//ȭ���� ��� ���ڵ��� �Ⱥ�����!
		//�׷��� �ؽ�Ʈ������� �ٷ� �����ӿ� ���� �ʰ� 
		//��ũ���� �ڵ����� ����� �ִ� JScrollPane���� ���μ� �����ӿ� ��ƾ� �ؿ�.		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		//"�޴���"�� ���� ��ü�� �����մϴ�.
		JMenuBar jmb = new JMenuBar();
		
		//"�ָ޴�" "����"�� �����մϴ�.
		JMenu mn_file = new JMenu("����");
		
		//"�θ޴�", "������", "����","����"�� ������
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		//"�θ޴�", "������", "����", "����"�� "�ָ޴�" "����"�� ��ƿ�
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//"�ָ޴�" "����"�� "�޴���"�� ��ƿ�
		jmb.add(mn_file);
		
		//"������"�� "�޴���"�� �����ؿ�
		setJMenuBar(jmb);
		
		//"�θ޴�" "������","����","����"�� ���Ͽ� �޴��� ���������� � ���� �ϵ��� �̺�Ʈ�� ����մϴ�.
		//�Ű����� "�̺�Ʈó����簴ü"�� �����ؾ� �ϴµ�, �� Ŭ����(SistNote) �ڽ��� ó���ϵ��� �ϱ� ���Ͽ� 
		//this�� �����մϴ�.
		file_new.addActionListener( this );
		file_open.addActionListener( this );
		file_save.addActionListener( this );
		
		
		
		//�������� ũ�⸦ �����ϰ�, �������� �����ֵ��� �����մϴ�
		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		/*
		jta.setText("�ȳ��ϼ���");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		jta.setText("");
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�޴��߿� ���� ���������� �ľ��ϱ� ���Ͽ� 
		//ActionEvent�� getActionCommand �޼ҵ带 �̿��Ͽ� 
		//������ �޴��� "����"�� �����ɴϴ�.
		String cmd = e.getActionCommand();
		String oldData="";
		//������ �޴��� ���� ������ ��ó���� �ϵ��� �մϴ�.
		if(cmd.equals("������")) {
			File file = jfc.getSelectedFile();
			try {
				//�� ������ ������ ��ǻ�͸޸𸮷� �о�������� ��Ʈ���� �����մϴ�.
				FileReader fr = new FileReader(file);
				
				//������ ��� ������ ��� ���� ���ڿ� ������ ������
				//���Ϸ� ���� �ѱ��ھ� �пͼ� �����ϱ� ���Ͽ� ""���� �ʱ�ȭ �� �ݴϴ�.
				
				
				//���Ϸ� ���� �ѱ��ھ� �б� ���� ������ ������
				int ch;
				
				//�ݺ����� �̿��Ͽ� ������ ���� �ƴҵ��� �ѱ��ھ� �о� �鿩��
				while(true) {
					
					//���Ϸ� ���� �ѱ��ھ� �о���Դϴ�.
					//���ڿ� �ش��ϴ� �������� ��ȯ�մϴ�.
					//���� ���̻� �о���� ������ ���� ������ ���� �����ϸ� -1�� ��ȯ�մϴ�.
					ch = fr.read();
					
					//���Ϸ� ���� ���̻� �о���� ������ ������ �ݺ����� Ż���մϴ�.
					if(ch == -1) {
						break;
					}
					
					//������ ���� �ƴ϶�� �о���� ������ ���ڸ� �ٽ� ���ڷ� ��ȯ�Ͽ� 
					//���ڿ� ���� data�� �����մϴ�.
					oldData = oldData + (char)ch;
					
				}
			
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
			String newData=jta.getText();
			
			isModified= oldData.equals(newData)?false:true;
			
			int ask = 0;
			if(isModified) {
				ask=JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?");	//��:0 �ƴϿ�:1 ���:2
			}
			switch(ask) {
				case 0: 
					File file2 = jfc.getSelectedFile();
					int rs=jfc.showSaveDialog(this);
					//"�����ϱ�"���̾�α׿� "����"�� �������� ���������� ���� ��ɾ���� �����ϵ��� �մϴ�.
					if(rs == 0) {
						try {
							FileWriter fw = new FileWriter(file2);
							
							//�ؽ�Ʈ����� ������ ������ �о�ͼ� ���Ϸ� ����մϴ�.
							fw.write(jta.getText());
							
							//������ ����� �������Ƿ� ������ �ݾ��ݴϴ�.
							fw.close();
							
							//��������� �˷��� ������ �ֿܼ� ������� ���� ���̾�α׸� �����
							JOptionPane.showMessageDialog(this, "���Ϸ� �����Ͽ����ϴ�.");
							
							
						}catch (Exception ex) {//���ܺ����̸��� �̺�Ʈ�����̸��� �ٸ��� ������ �ݴϴ�.
							System.out.println("���ܹ߻�:"+ex.getMessage()); 
							//���ܰ� �߻��ϸ� ���ܸ޼����� ����Ͽ� 
							//�޼����� �ľ��Ͽ� ������ �ذ��ϵ��� �մϴ�.
						}
						
					}//end if
					break;
				case 1: case 2: 
					jta.setText("");
					fileName="���� ����";
					break;
			}
			setTitle(fileName);
		}
		else if(cmd.equals("����")) {
			try {
				//"����"�޴��� ������ ��� �ִ� ������� ������� �����ϱ� ���� ���̾�α׸� �����
				int re = jfc.showOpenDialog(this);
				
				//���̾�α׿��� "���"�� ������ �ʰ� "����"�� ���������� ������ ������ �о���� ó���� �ϵ��� �մϴ�.
				if(re == 0) {
					//���̾�α׿��� ������ ���������� �����ɴϴ�.
					File file = jfc.getSelectedFile();
					
					//�� ������ ������ ��ǻ�͸޸𸮷� �о�������� ��Ʈ���� �����մϴ�.
					FileReader fr = new FileReader(file);
					
					//������ ��� ������ ��� ���� ���ڿ� ������ ������
					//���Ϸ� ���� �ѱ��ھ� �пͼ� �����ϱ� ���Ͽ� ""���� �ʱ�ȭ �� �ݴϴ�.
					String data="";
					
					//���Ϸ� ���� �ѱ��ھ� �б� ���� ������ ������
					int ch;
					
					//�ݺ����� �̿��Ͽ� ������ ���� �ƴҵ��� �ѱ��ھ� �о� �鿩��
					while(true) {
						
						//���Ϸ� ���� �ѱ��ھ� �о���Դϴ�.
						//���ڿ� �ش��ϴ� �������� ��ȯ�մϴ�.
						//���� ���̻� �о���� ������ ���� ������ ���� �����ϸ� -1�� ��ȯ�մϴ�.
						ch = fr.read();
						
						//���Ϸ� ���� ���̻� �о���� ������ ������ �ݺ����� Ż���մϴ�.
						if(ch == -1) {
							break;
						}
						
						//������ ���� �ƴ϶�� �о���� ������ ���ڸ� �ٽ� ���ڷ� ��ȯ�Ͽ� 
						//���ڿ� ���� data�� �����մϴ�.
						data = data + (char)ch;
					}
					//������ ������ ��� �о���� �������� while�� Ż���մϴ�.
					//while�� Ż���������� ������ ��� ������ String ���� data�� ����� �־��.
					//data�� ������ �ؽ�Ʈ����� �����մϴ�.
					jta.setText(data);
					
					//������ �о�Դٰ� �޼����� ����սô�.
					JOptionPane.showMessageDialog(this, "������ �о�Խ��ϴ�.");
					
					//�о�� ������ ������ ��� �ִ� File��ü�� ���� ���ϸ��� �̾Ƽ� �ɺ����� fileName�� ��ƿ�
					fileName = file.getName();
					//String []arr = fileName.split(".");
					//fileName = arr[0];
					//split�޼ҵ�� .���� �и��� �� �����!
					
					fileName = fileName.substring(0, fileName.indexOf("."));
					
					//���ϸ��� �������� ����ǥ���ٷ� �����մϴ�.
					setTitle(fileName);
				}
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}
		else if(cmd.equals("����")) {
			//"����" �޴��� ������ ��� ������̸��� ������ ������ �����ϵ��� ���̾�α׸� �����
			//�Ű����� this�� �� ���̾�α׸� � ������������ ���������� �����մϴ�.
			//���� �������� SistNote�� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this�� �����մϴ�.
			//showSaveDialog���� ����ڴ� "����"�� �������� �ְ� "���"�� �������� �־��
			//"���"�� �����µ� ���������ϴ� ��ɾ ó���ϸ� ����ؿ�.
			//�׷��� �̸޼ҵ�� "����"�� ������ 0�� ��ȯ�ϰ� "���"�� ������ 1�� ��ȯ�մϴ�.
			//�� ��ȯ�ϴ� ���� ������ ��� �� ���� ���� �״��� ��ó���� �ٸ��� �� �� �־��.
			int re =jfc.showSaveDialog(this);
			
			//"�����ϱ�"���̾�α׿� "����"�� �������� ���������� ���� ��ɾ���� �����ϵ��� �մϴ�.
			if(re == 0) {
				//���̾�α׿��� ������ ������ ������ �о� �ɴϴ�.
				File file = jfc.getSelectedFile();
				
				//�� ������ ���Ͽ� �ؽ�Ʈ������ ������ ������ ����ϱ� ���� ��Ʈ���� �����մϴ�.
				//���ڴ����� ������� Writer�� �ļ��� FileWriter�� �̿��մϤ���.
				//����°� ���õ� ��� �����ڿ� �޼ҵ���� ���ܸ� �����ϰ� �־��.
				//�� ���ܵ��� RuntimeException�� �ļյ��� �ƴϱ� ������ 
				//����ڰ� �ݵ�� ����ó���� �ؾ��մϴ�.
				try {
					FileWriter fw = new FileWriter(file);
					
					//�ؽ�Ʈ����� ������ ������ �о�ͼ� ���Ϸ� ����մϴ�.
					fw.write( jta.getText()   );
					
					//������ ����� �������Ƿ� ������ �ݾ��ݴϴ�.
					fw.close();
					
					//��������� �˷��� ������ �ֿܼ� ������� ���� ���̾�α׸� �����
					JOptionPane.showMessageDialog(this, "���Ϸ� �����Ͽ����ϴ�.");
					
					//������ ������ ������ ���� �ִ� ��ü File file�� ���� �����̸��� �̾ƿͼ� 
					//�ɹ����� fileName�� ��ƿ�.
					//fileName = file.getName();   
					//�޸�.txt
					//.���� �и��Ͽ� ���ϸ� �̾ƿͿ�
					fileName = file.getName();
//					System.out.println("���ϸ�:"+fileName);
//					String []arr = fileName.split(".");
//					fileName = arr[0];
					
					fileName= fileName.substring(0, fileName.indexOf("."));
					
					//���ϸ��� ����ǥ���ٿ� �����մϴ�.
					setTitle(fileName);
					
				}catch (Exception ex) {//���ܺ����̸��� �̺�Ʈ�����̸��� �ٸ��� ������ �ݴϴ�.
					System.out.println("���ܹ߻�:"+ex.getMessage()); 
					//���ܰ� �߻��ϸ� ���ܸ޼����� ����Ͽ� 
					//�޼����� �ľ��Ͽ� ������ �ذ��ϵ��� �մϴ�.
				}
				
			}
		}
		
	}
}