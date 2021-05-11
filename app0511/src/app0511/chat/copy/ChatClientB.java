package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientB extends JFrame{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	public ChatClientB() {
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(24);
		
		//스타일, 레이아웃
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280, 280));
		area.setBackground(Color.CYAN);
		
		//조립 
		add(scroll);
		add(t_input);
		
		//이벤트연결
		
		//보여주기
		setBounds(600, 100, 300, 400);
		setVisible(true);
	}
}





