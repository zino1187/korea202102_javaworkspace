package db.table.model;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/*
 * JTable이 사용할 데이터를, TableModel을 이용해서 좀더 유지보수성에 있어 개선을 해보자
 * TableModel 이란? JTable 과 같은 디자인영역에서 실제 데이터를 직접 접근하지 말고, 중간에 
 * 계층을 두고, 데이터의 조회,입력, 수정등을 이 중간 계층을 통해 작업을 진행하면 추후 Jtable이 변경될때 
 * 데이터를 처리하려는 로직은 영향을 받지 않게 되므로, 어플리케이션의 유지보수성을 높일 수 있다.. 
 * TableModel 은 JTable 사용하려는 데이터를 간접적으로 사용할수 있게 도와주는 컨트롤러를 의미 
 * */
public class UseModelApp extends JFrame{
	JTable table;
	JScrollPane scroll;
	String[] columnName= {"member_id","user_id","password","name","regdate"};
	String[][] rows= {};

	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	Connection con;
	
	public UseModelApp() {
		table = new JTable(new AbstractTableModel() {
			
			//총 레코드수를 반환하는 메서드 그리고 이 메서드는 JTable이 호출하는 거다!!
			public int getRowCount() {//층수
				return rows.length;
			}
			//총 컬럼수를 반환하는 메서드, 그리고 이 메서드 또한 JTable이 호출하는 거다!!
			public int getColumnCount() {
				return columnName.length;
			}
			
			public String getColumnName(int col) { //col 변수에 호출시마다 1씩 증가시키며 호출 0,1,2,3,4
				return columnName[col];
			}
			
			//row, col 좌표에 어떤 데이터가 있는 반환 하는 메서드, 이 또한 JTable이 호출하는 거다!!
			//즉 TableModel의 모든 메서드가 다 JTable을 위한 메서드이다!!
			public Object getValueAt(int row, int col) {
				System.out.println("getValueAt("+row+", "+col+")");
				return rows[row][col];
			}
		}); // 테이블모델 객체 이용가능
		
		scroll = new JScrollPane(table);
		add(scroll);
		
		//윈도우와 리스너 연결 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		
		setBounds(2400, 100, 600,400);
		setVisible(true);
		
		connect();
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로드
			con = DriverManager.getConnection(url, user, password);//접속
			if(con==null) {
				JOptionPane.showMessageDialog(this, "MySQL 접속 실패");
			}else {
				getList();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getList() {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="select * from member";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//레코드 담기!!
			
			//rs를 이차원배열로 바꾼다!!
			rows=new String[][]{ //데이터 갱신
				{"1","Benz","1111","벤츠","2019"},
				{"2","Audi","2222","아우디","2018"},
				{"3","BMW","3333","뱀","2020"}
			};			
			table.updateUI();//디자인 갱신 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new UseModelApp();

	}

	

}
