package db.table;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//DBMS 등의 표형식(2차원구조)의 데이터를 표현하는 최적화된 JTable을 이용해본다
public class TableBasic extends JFrame{
	//JTable의 생성자 중, 레코드는 이차원배열로 지원하고, 컬럼의 제목은 일차원배열로 지원하는 3번째 생성자를 이용해보자!!
	String[] columns= {"member_id","name","phone"};
	String[][] rows= {
			{"1","Batman","010-8888-9999"},
			{"2","Superman","010-7777-9999"},
			{"3","xman","010-6666-9999"}
	};
	JTable table;
	JScrollPane scroll;
	
	//mysql 접속 문자열에 사용될 접속정보
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	Connection con; //접속 후 그 정보를 가진 객체
	
	public TableBasic() {
		table = new JTable(rows , columns); 
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setVisible(true);
		setBounds(2400, 100, 500, 250);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//자원을 해제시킬 작업이 없기 때문에 이용가능...
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con !=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		
		
		getList();
	}
	//데이터베이스 가져오기
	public void getList(){
		/*
		 * 1) 드라이버 로드 
		 * 2) 접속 
		 * 3) 쿼리수행
		 * 4) 자원해제
		 * */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(this, "MySQL 드라이버 로드 성공");
			
			con=DriverManager.getConnection(url, user, password);
			
			if(con!=null) {
				JOptionPane.showMessageDialog(this, "접속 성공");
			}else {
				JOptionPane.showMessageDialog(this, "접속 실패");
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버 로드 실패\n드라이버를 찾을 수 없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TableBasic();
	}

}




