package db.table.model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
	
	public UseModelApp() {
		table = new JTable(new AbstractTableModel() {
			
			//총 레코드수를 반환하는 메서드 그리고 이 메서드는 JTable이 호출하는 거다!!
			public int getRowCount() {
				return 10;
			}
			//총 컬럼수를 반환하는 메서드, 그리고 이 메서드 또한 JTable이 호출하는 거다!!
			public int getColumnCount() {
				return 5;
			}
			//row, col 좌표에 어떤 데이터가 있는 반환 하는 메서드, 이 또한 JTable이 호출하는 거다!!
			//즉 TableModel의 모든 메서드가 다 JTable을 위한 메서드이다!!
			public Object getValueAt(int row, int col) {
				System.out.println("getValueAt("+row+", "+col+")");
				return "뽀미";
			}
		}); // 테이블모델 객체 이용가능
		
		scroll = new JScrollPane(table);
		add(scroll);
		
		setBounds(2400, 100, 600,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new UseModelApp();

	}

	

}
