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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	
	public MarvelApp() {
		table = new JTable();
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






