package com.sist.draw07;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


//MyFrameŬ���� �ڽ��� "JMenuItem"�� ���������� "�̺�Ʈó�� �����"�� �ǵ��� �ϱ� ���Ͽ� 
//ActionListener�������̽��� �����ϵ��� �մϴ�.
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	//������ ���ϸ�� ����� ���ϸ��� ������ �� �ֵ��� �ϴ� JFileChooser�� �ɹ������� �����մϴ�.
	JFileChooser jfc;
	

	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser ��ü�� �����մϴ�.
		jfc = new JFileChooser("c:/myData");
		
		//�޴��ٸ� �����մϴ�.
		JMenuBar jmb = new JMenuBar();
		
		//�ָ޴� "����"�� �����մϴ�.
		JMenu  mn_file = new JMenu("����");
		
		//�ָ޴� "�׸��⵵��"�� �����մϴ�.
		JMenu mn_draw = new JMenu("�׸��⵵��");
		
		//�θ޴� "������"�� �����մϴ�.
		JMenuItem file_new = new JMenuItem("������");
		
		//�θ޴� "����"�� �����մϴ�.
		JMenuItem file_open = new JMenuItem("����");
		
		//�θ޴� "����"�� �����մϴ�.
		JMenuItem file_save = new JMenuItem("����");
		
		//"�θ޴�"���� "�ָ޴�"�� ��ƿ�
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		
		//�ָ޴� "�׸��⵵��"�� ��� �θ޴����� ������
		JMenuItem draw_line = new JMenuItem("��");
		JMenuItem draw_rect = new JMenuItem("�簢��");
		JMenuItem draw_oval = new JMenuItem("��");
		
		//��,�簢��,�� �θ޴����� "�׸��⵵��"�ָ޴��� ��ƿ�
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);		
		
		//"�ָ޴�"�� "�޴���"�� ��ƿ�
		jmb.add(mn_file);
		
		//"�׸��⵵��" �ָ޴��� "�޴���"�� ��ƿ�
		jmb.add(mn_draw);
		
		//"�޴���"�� "������"�� �����ؿ�!
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���Ͽ� �̺�Ʈ�� ����մϴ�.
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//�׸��⵵���� �θ޴��鿡 ���ؼ��� �̺�Ʈ�� ����մϴ�.
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("���׸���");
		
	}

	
	//������ JMenuItem�� ������ actionPerformed�޼ҵ尡 �����մϴ�.
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem�߿� � �޴��� ���������� �ľ��ϱ� ���Ͽ� �Ű����� ActionEvent�� getActionCommand()�� �̿��մϴ�.
		String cmd = e.getActionCommand();
		//System.out.println(cmd+"�� ������");
		
		if(cmd.equals("����")) {
			try {
				
				System.out.println("�����մϴ�.");
				//��� ��̸����� �������� �����ϵ��� JFileChooser ���̾�α׸� �����
				int re = jfc.showSaveDialog(this);
				
				//"�����ϱ�" ���̾�α׿��� "����"�� �������� �ְ� "���"�� �������� �־��
				//"����"�� ������ 0�� ��ȯ�� �˴ϴ�.
				if(re == 0) {		
					
					//���̾�α׿��� ������ ������ ���� �ɴϴ�
					File file = jfc.getSelectedFile();
					
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(lp.list);					
					oos.close();				
				}
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}else if(cmd.equals("����")) {
			// "����"�� ���� ����� JFileChooser�� �̿��Ͽ� ����� ������ �����ϵ��� ���� �� ���ϴ�.
			// "������"�� ���� ��ɵ� ������ ���ϴ�.
			
			try {
				//��ü������ ������ ������ �о���̱� ���Ͽ� ObjectInputStream��ü�� �����մϴ�.
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//���Ϸ� �����͸� �о�鿩 Linpanel ��ü�� lp�� list�� ��ƿ�
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���Ͽ� repaint�� ȣ���մϴ�.
				lp.repaint();
				
				//������ �ݾ��ݴϴ�.
				ois.close();
							
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
			
		}else if(cmd.equals("������")) {
			System.out.println("�������� ó���Դϴ�.");
		}else if(cmd.equals("��")) {
			lp.drawType = 0;
		}else if(cmd.equals("�簢��")) {
			lp.drawType = 1;
		}else if(cmd.equals("��")) {
			lp.drawType = 2;
		}
		
	}
}




// ���α׷��� �����ϴٰ� ����
// ���ܰ� �߻��� ������ ���µ�
// try~catch�� ����ϴ� ������
// ObjectInputStrea, ObjectOutStream�� ����ϱ� �����ΰ���?
//	==> ��, �½��ϴ�.
// ObjectInputStream, ObjectOutStream���� 
// java.io ��Ű���� ��� Ŭ������ �����ڿ� �޼ҵ���� ���ܸ� �����ϰ� �ϰ� �־��.
// ������ �̸� �ڿ� �޼ҵ� �̸��ڿ� ��� throws ~~~~Exception���� �Ǿ� �־��
// �׷��� �̷��� �͵带 ����Ϸ��� �ݵ�� ����ó�� �ؾ� �մϴ�.












