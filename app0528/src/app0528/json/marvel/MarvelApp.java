package app0528.json.marvel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//marvl hero 데이터를 읽어서,  JTable로 출력해보기!!
public class MarvelApp extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	JPanel p_east;
	Canvas can;
	JTextField t_title;
	JTextField t_date;
	JTextField t_gross;
	
	public MarvelApp() {
		table = new JTable();
		scroll = new JScrollPane(table);
		p_east = new JPanel();
		can = new Canvas() {
		};
		t_title = new JTextField(13);
		t_date = new JTextField(13);
		t_gross = new JTextField(13);
		
		//스타일 
		p_east.setPreferredSize(new Dimension(250,600));
		can.setPreferredSize(new Dimension(240,270));
		can.setBackground(Color.RED);
		
		//조립 
		add(scroll);
		p_east.add(can);
		p_east.add(t_title);
		p_east.add(t_date);
		p_east.add(t_gross);
		add(p_east, BorderLayout.EAST);
		
		setBounds(2400, 0, 850, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MarvelApp();
	}
	
}


