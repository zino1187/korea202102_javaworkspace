package com.minssam.shoppingapp.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.minssam.shoppingapp.main.AppMain;
import com.minssam.shoppingapp.main.Page;

public class LoginForm extends Page{
	JPanel p_container;//BorderLayout 
	JPanel p_center; //form 
	JPanel p_south; //버튼 영역 
	JLabel la_id, la_pass;
	JTextField t_id; 
	JPasswordField t_pass;
	JButton bt_login, bt_join;
	
	public LoginForm(AppMain appMain) {
		super(appMain);
		
		//생성
		p_container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pass = new JLabel("Password");
		t_id = new JTextField();
		t_pass = new JPasswordField();
		bt_login = new JButton("Login");
		bt_join = new JButton("회원가입");
		
		//스타일 레이아웃
		p_container.setPreferredSize(new Dimension(250, 85));
		p_container.setLayout(new BorderLayout());
		p_center.setLayout(new GridLayout(2, 2));
		
		//조립
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		p_container.add(p_center);
		p_container.add(p_south, BorderLayout.SOUTH);
		
		add(p_container);
		
		//리스너
		//보이기
	}
}










