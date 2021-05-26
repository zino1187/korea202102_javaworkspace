package app0526.thread.ex4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import util.ImageManager;

//사실상 윈도우는 껍데기에 불과하고, 모든 게임은 이 패널에서 그려질 것이다!!
public class GamePanel extends JPanel{
	Thread gameThread; //게임루프 즉 심장을 뛰게 할 게임 운영 쓰레드!!
	boolean gameFlag=true; //게임 진행 여부를 결정짓는 논리값
	public static final int WIDTH=900; 
	public static final int HEIGHT=600; 
	ImageManager imageManager=new ImageManager();
	Image bgImg;//배경이미지 
	
	Hero hero;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		gameThread=new Thread() {
			public void run() {
				while(gameFlag) {
					gameLoop();
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		createBg();
		createHero();
		
		gameThread.start();
	}
	
	//배경 생성
	public void createBg() {
		ImageIcon icon = imageManager.getScaledIcon("bg.jpg", WIDTH, HEIGHT);
		bgImg=icon.getImage(); //배경 이미지 얻기!!
	}
	
	//주인공 생성
	public void createHero() {
		hero = new Hero(this,"plane2.png",100,200,80,45,0,0);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(bgImg ,0 , 0, WIDTH, HEIGHT, this);
		hero.render(g);
	}
	
	public void gameLoop() {
		//System.out.println("gameLoop operating...");
	}
}









