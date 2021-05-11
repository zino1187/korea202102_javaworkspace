package app0511.member;

import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinForm extends JFrame{
	JPanel p_title;
	JLabel la_title;
	JLabel la_id;
	JTextField t_id;
	JLabel la_pass;
	JPasswordField t_pass;
	JLabel la_hobby;
	JPanel p_hobby;
	JCheckBox[] ch_hobby;
	JPanel p_mail;
	JTextField t_mailId;
	JLabel la_at;
	Choice ch_server;
	JPanel p_receive;
	JLabel la_receive;
	CheckboxGroup g;
	JButton bt_regist;
	
	public JoinForm() {
		//생성 
		p_title = new JPanel();
		la_title = new JLabel("회원가입");
		la_id = new JLabel("ID");
		t_id = new JTextField();
		la_pass = new JLabel("Pass");
		t_pass = new JPasswordField();
		la_hobby = new JLabel("취미선택");
		p_hobby = new JPanel();//취미 체크박스 담게될 패널 
		ch_hobby = new JCheckBox[5]; //빈 공간만 생성함..
		ch_hobby[0] = new JCheckBox("운동");
		ch_hobby[1] = new JCheckBox("독서");
		ch_hobby[2] = new JCheckBox("프로그래밍");
		ch_hobby[3] = new JCheckBox("여행");
		ch_hobby[4] = new JCheckBox("명상");
		
		p_mail = new JPanel();
		t_mailId = new JTextField();
		la_at = new JLabel("@");
		ch_server = new Choice();
		
		ch_server.add("gmail.com");
		ch_server.add("naver.com");
		ch_server.add("daum.net");
		ch_server.add("direct insert");
		
		//스타일, 레이아웃 
		setLayout(new FlowLayout());
		la_title.setFont( new Font("돋움", Font.BOLD, 24));
		p_title.setPreferredSize(new Dimension(450, 50));
		
		Dimension d = new Dimension(100, 30);
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(new Dimension(350,30));
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(new Dimension(350,30));
		p_hobby.setPreferredSize(new Dimension(450, 50));
		
		t_mailId.setPreferredSize(new Dimension(120, 30));
		la_at.setPreferredSize(new Dimension(30, 30));
		ch_server.setPreferredSize(new Dimension(150,30));
		
		//조립
		p_title.add(la_title); //패널에 제목 올려놓기!!
		add(p_title); //윈도우에 제목 패널 부착!!
		add(la_id);
		add(t_id);
		add(la_pass);
		add(t_pass);
		add(la_hobby);
		for(int i=0;i<ch_hobby.length;i++) {
			p_hobby.add(ch_hobby[i]);
		}
		add(p_hobby);
		
		//메일 조립
		p_mail.add(t_mailId);
		p_mail.add(la_at);
		p_mail.add(ch_server);
		add(p_mail);
		
		//보여주기 (화면 중앙으로 오게)
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JoinForm();
	}

}
