package app0601.json.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//LoginForm 예제에서는 메인 메서드 안에 변수를 몰아놓고 , 즉 지역변수로 객체들을 처리하고
//있다..이번엔 oop언어의 is a , has a 관계를 활요하여 객체를 정의해보자
public class LoginForm extends JFrame{
									/* is a*/
	JLabel la_id;
	JLabel la_pass;
	JTextField t_id;
	JTextField t_pass;
	JButton bt_login;
	JButton bt_join;
	
	JPanel p_center;
	JPanel p_south;
	
	//db관련 
	Connection con;
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	
	//이 윈도우인 즉 로그인폼이 메모리에 생성될때, 해당 부품들도 같이 생성시키려면
	//생성자 메서드를 적극 활용해야 한다..
	public LoginForm() {
		//부모의 생성자 이용하는 방법 
		super("LoginForm style 2");
		
		//부품 생성 
		la_id = new JLabel("ID");
		la_pass = new JLabel("Pass");
		t_id = new JTextField(20); //20자 너비의 크기 갖음(20자만 넣을수있는게 아니다!)
		t_pass = new JTextField(20);
		bt_login  = new JButton("Login");
		bt_join  = new JButton("Join");	
		p_center = new JPanel();
		p_south = new JPanel();
		
		//스타일 설정 
		la_id.setPreferredSize(new Dimension(110, 35));
		t_id.setPreferredSize(new Dimension(110, 35));
		la_pass.setPreferredSize(new Dimension(110, 35));
		t_pass.setPreferredSize(new Dimension(110, 35));
		
		//조립 
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		//패널을 윈도우 센터에 부착 
		this.add(p_center);
		this.add(p_south, BorderLayout.SOUTH);
		
		//이벤트 연결 
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				release(con);
				System.exit(0);//kill process 
				
			}
		});
		
		this.setSize(350,155);//윈도우의 크기 설정 
		this.setVisible(true);//윈도우 보이게
		
		connect();
	}
	
	public void connect() {
		/*
		 1) 드라이버 로드 
		 2) 접속 
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void release(Connection con) {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginForm();
	}
}













