package app0512.graphic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//JPanel을 상속받아서, paint 메서드를 재정의하기 위한 클래스
public class DetailView extends JPanel{
	Image image;
	
	public DetailView() {
		
	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}






