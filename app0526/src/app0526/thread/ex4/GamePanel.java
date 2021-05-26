package app0526.thread.ex4;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//사실상 윈도우는 껍데기에 불과하고, 모든 게임은 이 패널에서 그려질 것이다!!
public class GamePanel extends JPanel{
	public GamePanel() {
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(900, 600));		
	}
}









