package app0528.json.marvel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//marvl hero 데이터를 읽어서,  JTable로 출력해보기!!
public class MarvelApp extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	JPanel p_east;
	Canvas can;
	JTextField t_title;
	JTextField t_date;
	JTextField t_gross;
	JButton bt;
	FileReader reader;
	
	//이차원배열보다 유연하게 데이터를 처리할 수 있는 Vector를 이용한 JTable을 구현해본다!
	Vector<JSONObject> data=new Vector<JSONObject>(); //테이블에 채워질 데이터
	Vector<String> column=new Vector<String>(); //테이블의 컬럼정보
	
	public MarvelApp() {
		//컬럼
		column.add("movie_id");
		column.add("url");
		column.add("title");
		column.add("category_name");
		column.add("release_date");
		column.add("running_time");
		column.add("budget");
		column.add("gross");
		
		table = new JTable(new AbstractTableModel() {
			
			public int getRowCount() {
				return data.size();
			}
			public int getColumnCount() {
				return column.size();
			}
			public String getColumnName(int col) {
				return column.get(col);   //배열의 경우엔  배열[col]
			}
			public Object getValueAt(int rowIndex, int columnIndex) {
				return "hi";
			}
		});
		
		scroll = new JScrollPane(table);
		p_east = new JPanel();
		can = new Canvas() {
		};
		t_title = new JTextField(13);
		t_date = new JTextField(13);
		t_gross = new JTextField(13);
		bt = new JButton("Load");
		
		//스타일 
		p_east.setPreferredSize(new Dimension(250,600));
		can.setPreferredSize(new Dimension(240,270));
		can.setBackground(Color.RED);
		bt.setPreferredSize(new Dimension(200, 25));
		
		//조립 
		add(scroll);
		p_east.add(can);
		p_east.add(t_title);
		p_east.add(t_date);
		p_east.add(t_gross);
		p_east.add(bt);
		
		add(p_east, BorderLayout.EAST);
		
		//이벤트 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		
		setBounds(2400, 0, 850, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void load() {
		try {
			URL url = this.getClass().getClassLoader().getResource("kk/marvel.json");
			URI uri=url.toURI();
			File file = new File(uri);
			reader = new FileReader(file);
			System.out.println("스트림 생성 성공");
			
			//생성된 스트림을 이용하여 JSoN을 parsing  해보자!!1
			JSONParser jsonParser = new JSONParser();
			JSONObject obj=(JSONObject)jsonParser.parse(reader);//파싱 시작!!!
			
			JSONArray movieArray=(JSONArray)obj.get("marvel"); //영화 배열 받기
			System.out.println("마블의 총 영화수는 "+movieArray.size());
			
			for(int i=0;i<movieArray.size();i++) {
				JSONObject movie=(JSONObject)movieArray.get(i); //영화 1편 반환!!
				//data 백터에 영화1편 넣기!! 
				data.add(movie);
			}
			table.updateUI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void main(String[] args) {
		new MarvelApp();
	}
	
}






