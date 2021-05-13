package app0513.colorbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_ea;
	JButton bt_create; 
	JButton bt_bg;
	JPanel p_center;
	
	public ButtonMain() {
		//생성 
		p_north = new JPanel();
		t_ea = new JTextField(10);
		bt_create = new JButton("생성하기");
		bt_bg = new JButton("배경색");
		p_center = new JPanel();
		
		//스타일, 레이아웃 
		p_north.setPreferredSize(new Dimension(500, 50));
		p_center.setBackground(Color.YELLOW);
		
		//조립 
		p_north.add(t_ea);
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_create.addActionListener(this);//리스너와 연결 
		bt_bg.addActionListener(this);//리스너와 연결 
		
		//보이기 
		setBounds(2400,100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//사용자가 입력한 개수만큼, 버튼을 생성한다!!
	public void create() {
		//(1) 텍스트필의 값 구하기
		int ea = Integer.parseInt(t_ea.getText()); // "" 벗겨내기
		
		//(2) 개수만큼 버튼을 생성하여  p_center에 붙이기!!
		for(int i=0;i<ea;i++) {
			JButton bt= new JButton("버튼"+i);
			p_center.add(bt);
		}
		p_center.updateUI();//다시 그려라
	}
	
	public void setBg() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt_create) {
			create();
		}else if(e.getSource() == bt_bg) {
			setBg();
		}
	}
	
	public static void main(String[] args) {
		new ButtonMain();
	}

}



