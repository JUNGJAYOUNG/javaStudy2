package com.sist.draw;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

//MyFrameŬ���� �ڽ��� "JMenuItem"�� �������� �̺�Ʈó�� ����ڰ� �ǵ��� �ϱ� ���Ͽ�
//ActionListenerŬ������ �����ϵ��� �Ѵ�.
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	//������ ���ϸ�� ����� ���ϸ��� ������ �� �ֵ��� JFileChooser�� ��������� ����
	JFileChooser jfc;
	
	//�÷����̾�α� ����
	JColorChooser jcc;
			

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser ��ü�� ����
		jfc = new JFileChooser("c:/myData");
		
		//JColorChooser ��ü ����
		jcc = new JColorChooser();
		
		//�޴��� ����
		JMenuBar jmb = new JMenuBar();
		//�ָ޴� "����" ����
		JMenu mn_file = new JMenu("����");
		//�ָ޴� "�׸��⵵��" ����
		JMenu mn_draw = new JMenu("�׸��⵵��");
		//�ָ޴� "�׸������" ����
		JMenu mn_color = new JMenu("�׸������");
		//�θ޴� "������" ����
		JMenuItem file_new = new JMenuItem("������");
		//�θ޴� "����" ����
		JMenuItem file_open = new JMenuItem("����");
		//�θ޴� "����" ����
		JMenuItem file_save = new JMenuItem("����");
		
		//�ָ޴� "�׸��⵵��"�� ��� �θ޴����� �����.
		JMenuItem draw_line = new JMenuItem("��"); 
		JMenuItem draw_rect = new JMenuItem("�簢��"); 
		JMenuItem draw_oval = new JMenuItem("��"); 
		
		//"�θ޴�"���� "�ָ޴�"�� ��´�.
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//"�θ޴�"���� "�ָ޴�"�� ��´�.
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);
		
		//�ָ޴� �׸������ ��� �θ޴� �����
		JMenuItem color_red = new JMenuItem("����");
		JMenuItem color_blue = new JMenuItem("�Ķ�");
		JMenuItem color_green = new JMenuItem("�ʷ�");
		JMenuItem color_other = new JMenuItem("�ٸ�����");
		
		//"����","�Ķ�","�ʷ�","�ٸ�����"���� "�׸������" �ָ޴��� ��´�
		mn_color.add(color_red);
		mn_color.add(color_blue);
		mn_color.add(color_green);
		mn_color.add(color_other);
		
		//"�ָ޴�"�� "�޴���"�� ��´�.
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		//"�޴���"�� "������
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���Ͽ� �̺�Ʈ�� ����Ѵ�.
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//�׸��� ������ �θ޴��鿡 �̺�Ʈ�� ����Ѵ�.
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
				
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("���׸���");
	}
	//������ JMenuItem�� ������ actionPerformed �޼ҵ尡 �����Ѵ�.
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem�߿� � �޴��� ���������� �ľ��ϱ� ���Ͽ� �Ű�����
		//ActionEvent�� getActionCommand()�� �̿��Ѵ�.
		
		String cmd = e.getActionCommand();
		//System.out.println(cmd +"�� ������");
		
		if(cmd.equals("����")) {
			try {
				//��� ��̸����� �������� �����ϵ��� JFileChooser ���̾�α׸� ����
				System.out.println("����");
				int re=jfc.showSaveDialog(this);
				
				//�����ϱ� ���̾�α׿��� ������ ��������, ��Ҹ� �������� �ִ�.
				//������ ������ 0�� ��ȯ�ȴ�.
				if(re == 0) {
					//���̾�α׿��� ������ ������ ���� �´�.
					File file = jfc.getSelectedFile();
					
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(lp.list);
					oos.close();
				}	
			}catch(Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}else if(cmd.equals("����")) {
			//JFileChooser�� �̿��Ͽ� ����� ������ �����ϵ��� ����
			//"������"�� ���� ��ɵ� �����غ���
			
			try {
				System.out.println("����");
				int re=jfc.showOpenDialog(this);
				if(re == 0) {
					File file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					//���Ϸ� �����͸� �о�鿩 Linepanel ��ü�� lp�� list�� ��´�
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
					//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���� ȣ��
					lp.repaint();
					//������ �ݾ��ش�.
					ois.close();
				}
			}catch(Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
				
		}else if(cmd.equals("������")) {
			lp.list.clear();
			repaint();
		}else if(cmd.equals("��")) {
			lp.drawType=0;
		}else if(cmd.equals("�簢��")) {
			lp.drawType=1;
		}else if(cmd.equals("��")) {
			lp.drawType=2;
		}else if(cmd.equals("����")) {
			lp.drawColor = Color.RED;
		}else if(cmd.equals("�Ķ�")) {
			lp.drawColor = Color.BLUE;
		}else if(cmd.equals("�ʷ�")) {
			lp.drawColor = Color.GREEN;
		}else if(cmd.equals("�ٸ�����")) {
			Color color = jcc.showDialog(this,"�׸������",Color.RED);
			if(color!=null) {
				lp.drawColor=color;
			}
		}
	}
}