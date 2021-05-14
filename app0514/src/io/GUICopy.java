package io;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 파일복사 기능을 GUI기반으로 처리해 본다
 */
public class GUICopy extends JFrame implements WindowListener{
	JButton bt_open; //복사원본 탐색창 열기
	JTextField t_open;
	JButton bt_target; //복사될 파일 탐색창 열기
	JTextField t_target;
	JTextArea area;
	JScrollPane scroll;
	JButton bt_copy;
	
	public GUICopy() {
		//생성
		bt_open = new JButton("원본선택");
		t_open = new JTextField();
		bt_target = new JButton("복사위치");
		t_target = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_copy = new JButton("복사실행");
		
		//스타일, 레이아웃 
		setLayout(new FlowLayout());
		bt_open.setPreferredSize(new Dimension(100, 25));
		bt_target.setPreferredSize(new Dimension(100, 25));
		
		t_open.setPreferredSize(new Dimension(370, 25));
		t_target.setPreferredSize(new Dimension(370, 25));
		scroll.setPreferredSize(new Dimension(480, 180));
		
		//조립 
		add(bt_open);
		add(t_open);
		add(bt_target);
		add(t_target);
		add(scroll);
		add(bt_copy);
		
		this.addWindowListener(this);//이벤트 연결
		
		//보여주기
		setBounds(2400, 100, 500,350);
		setVisible(true);
		//아래의 메서드 호출하면 안되느 이유? 윈도우창 닫을때 스트림을 닫는 처리를 하기 위해...
		//결론: 윈도우리스너를 구현하여, 창 닫을때 스트림 닫아야 한다..
		//setDefaultCloseOperation(); 
	}
	
	public static void main(String[] args) {
		new GUICopy();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("저 닫혀요, 닫을것이 있다면 닫을께요..(db, stream..등)");
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}










