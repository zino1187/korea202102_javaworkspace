package app0531;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//공지게시판 구현하기 
public class NoticeApp extends JFrame{
	//서쪽영역
	JPanel p_west;
	JTextField t_title;
	JTextField t_writer;
	JTextField t_content;
	JButton bt_regist;
	
	//센터영역
	JPanel p_center;
	JTable table;
	JScrollPane scroll;
	JPanel p_south;
	JButton bt_del;
	
	public NoticeApp() {
		//생성
		p_west = new JPanel();
		t_title = new JTextField(16); 
		t_writer = new JTextField(16); 
		t_content = new JTextField(16); 
		bt_regist = new JButton("등록");	
		
		p_center = new JPanel();
		table = new JTable(); //TableModel을 .java로 빼서 처리해보자!!
		scroll = new JScrollPane(table);
		p_south = new JPanel();
		bt_del = new JButton("삭제");
		
		//스타일
		p_west.setPreferredSize(new Dimension(200, 450));
		p_west.setBackground(Color.orange);
		p_center.setLayout(new BorderLayout());
		
		//조립
		p_west.add(t_title);
		p_west.add(t_writer);
		p_west.add(t_content);
		p_west.add(bt_regist);
		add(p_west, BorderLayout.WEST);
		
		p_center.add(scroll);
		p_center.add(p_south, BorderLayout.SOUTH);
		p_south.add(bt_del);
		p_center.add(p_south, BorderLayout.SOUTH);
		add(p_center);
		
		//이벤트
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); //프로세스 종료
			}
		});
		
		setBounds(0,100,600,450);
		setVisible(true);
	}
	public static void main(String[] args) {
		new NoticeApp();
	}
}
