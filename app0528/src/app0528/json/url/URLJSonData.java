package app0528.json.url;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.json.simple.JSONObject;

public class URLJSonData extends JFrame{
	JPanel p_north;
	JButton bt;
	JTable table;
	JScrollPane scroll;
	Vector<JSONObject> data=new Vector<JSONObject>();
	Vector<String> column=new Vector<String>();
	
	public URLJSonData() {
		column.add("Name");
		column.add("Code");
		
		p_north = new JPanel();
		bt = new JButton("Load From URL");
		table = new JTable(new AbstractTableModel() {
			public int getRowCount() {
				return data.size();
			}
			public int getColumnCount() {
				return column.size();
			}
			public String getColumnName(int col) {
				return column.get(col);
			}
			public Object getValueAt(int row, int col) {
				return null;
			}			
		});
		scroll = new JScrollPane(table);
		
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		setVisible(true);
		setBounds(2400, 100, 600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new URLJSonData();
	}

}
