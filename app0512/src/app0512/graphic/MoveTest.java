package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//켄버스에 채워진 원을 하나 그리고 나서, 버튼에 의해 이 원이 x축방향으로 
//이동하는 효과를 부여해본자!!
public class MoveTest extends JFrame{
	JPanel p_north;
	JButton bt;
	MyCanvas can; //커스터 마이징된 켄버스
	
	
	public MoveTest() {
		//생성
		p_north = new JPanel();
		bt = new JButton("Move");
		can = new MyCanvas();
		
		//스타일 및 레이아웃 
		can.setBackground(Color.RED);
		
		//조립 
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH); //북쪽에 패널 부착 
		add(can);//센터에 켄버스 부착
		
		//보여주기
		setBounds(1600, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args) {
		new MoveTest();
	}
}












