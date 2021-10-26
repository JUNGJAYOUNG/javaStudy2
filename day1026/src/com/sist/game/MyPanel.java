package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;

public class MyPanel extends JPanel implements KeyListener {
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	public MyPanel() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		enermy = new Enermy("enermy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		class MyThread extends Thread{
			public void run() {
				while(true) {
					enermy.update();
					spaceship.update();
					missile.update();
					repaint();
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
						
					}
				}
			}
		}
		Thread t = new MyThread();
		t.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		enermy.draw(g);
		spaceship.draw(g);
		missile.draw(g);
	}
	

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		spaceship.keyPressed(event);
		missile.keyPressed(event,spaceship.x,spaceship.y);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
