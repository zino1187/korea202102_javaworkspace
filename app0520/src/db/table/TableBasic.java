package db.table;

import javax.swing.JFrame;
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
	
	public TableBasic() {
		table = new JTable(rows , columns); 
		scroll = new JScrollPane(table);
		
		add(scroll);
		
		setVisible(true);
		setBounds(2400, 100, 500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//자원을 해제시킬 작업이 없기 때문에 이용가능...
	}
	public static void main(String[] args) {
		new TableBasic();
	}

}




