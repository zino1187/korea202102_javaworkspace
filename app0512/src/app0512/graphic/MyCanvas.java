package app0512.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	
	//켄버스에 그려질 그림을 개발자가 주도하여, 원하는 
	//그림을 그려보자!!
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);//이 시점부터는, 노란색으로 그려진다...
		g.fillOval(0, 100, 100, 100);
	}
}
