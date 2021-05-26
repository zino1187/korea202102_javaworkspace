package app0526.thread.ex4;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMain extends JFrame{
	GamePanel gamePanel;
	JMenuBar bar; //게임 제어 패널
	JMenu m_control; //설정
	JMenuItem item_start; //게임 시작
	JMenuItem item_pause; //잠시 멈추기
	JMenuItem item_exit; //게임 종료
	
	public GameMain() {
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		m_control = new JMenu("게임제어");
		item_start = new JMenuItem("start");
		item_pause = new JMenuItem("pause");
		item_exit = new JMenuItem("exit");
		
		//조립 
		m_control.add(item_start);
		m_control.add(item_pause);
		m_control.add(item_exit);
		bar.add(m_control);
		setJMenuBar(bar); //프레임에 바 부착!
		
		add(gamePanel);
		
		pack();//내부 컨텐츠 크기까지 줄어듦
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GameMain(); 
	}
}
