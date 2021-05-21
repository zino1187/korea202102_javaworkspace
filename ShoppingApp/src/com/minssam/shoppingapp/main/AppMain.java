package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppMain extends JFrame{
	JPanel p_north;
	String[] menu_title= {"상품관리","회원관리","주문관리","고객센터","Login","환경설정"};
	JButton[] bt_menu=new JButton[menu_title.length]; //배열생성
	
	public AppMain() {
		//생성
		p_north = new JPanel();
		for(int i=0;i< menu_title.length;i++) {
			bt_menu[i] = new JButton(menu_title[i]);
		}
		
		//스타일
		
		
		//조립
		for(JButton bt : bt_menu) { // improved for loop : 주로 집합데이터 형식을 대상으로 한 loop
			p_north.add(bt);
		}
		add(p_north, BorderLayout.NORTH);
		
		//리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); //kill process
			}
		});
		
		//보여주기
		setBounds(1900, 10, 1200, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppMain();

	}

}
