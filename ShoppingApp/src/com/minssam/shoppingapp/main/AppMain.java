package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.minssam.shoppingapp.config.ConfigMain;
import com.minssam.shoppingapp.customer.CustomerMain;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.MemberMain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener{
	JPanel p_north;
	String[] menu_title= {"상품관리","회원관리","주문관리","고객센터","Login","환경설정"};
	JButton[] bt_menu=new JButton[menu_title.length]; //배열생성
	
	JPanel p_center;//페이지를 교체하기 위한 패널(페이지들 간의 공존을 위해)
	
	//페이지 선언 
	ProductMain productMain; //상품관리 페이지
	MemberMain memberMain;//회원관리 페이지
	OrderMain orderMain;//주문관리
	CustomerMain customerMain;//고객센터
	LoginForm loginForm;//로그인
	ConfigMain configMain;//환경설정
	
	public AppMain() {
		//생성
		p_north = new JPanel();
		for(int i=0;i< menu_title.length;i++) {
			bt_menu[i] = new JButton(menu_title[i]);
		}
		
		//페이지들 생성 
		p_center = new JPanel();
		productMain = new ProductMain(); //상품관리
		memberMain = new MemberMain();//회원관리
		orderMain = new OrderMain();//주문관리
		customerMain = new CustomerMain();//고객센터
		loginForm = new LoginForm();//로그인
		configMain = new ConfigMain();//환경설정
		
		//스타일
		
		
		//조립
		for(JButton bt : bt_menu) { // improved for loop : 주로 집합데이터 형식을 대상으로 한 loop
			p_north.add(bt);
		}
		add(p_north, BorderLayout.NORTH);
		//p_center 에 페이지들 붙이기 
		p_center.add(productMain);
		p_center.add(memberMain);
		p_center.add(orderMain);
		p_center.add(customerMain);
		p_center.add(loginForm);
		p_center.add(configMain);
		
		add(p_center);
		
		//리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); //kill process
			}
		});
		
		for(int i=0;i<bt_menu.length;i++) {
			bt_menu[i].addActionListener(this);
		}
	
		
		//보여주기
		setBounds(1900, 10, 1200, 700);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌렀어?");
	}
	public static void main(String[] args) {
		new AppMain();

	}

}
