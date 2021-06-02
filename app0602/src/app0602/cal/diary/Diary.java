package app0602.cal.diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Diary extends JFrame{
	JPanel p_north;
	JButton bt_prev;
	JLabel la_title;
	JButton bt_next;
	
	JPanel p_center; //날짜 박스 처리할 영역
	String[] dayArray= {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
	
	public Diary() {
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		la_title = new JLabel("연도 월 올 예정");
		bt_next = new JButton("다음");
		p_center = new JPanel();
		
		//스타일
		
		//조립 
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		createDay(); //요일생성
		createDate();//날짜생성
		
		//테스트
		System.out.println(getFirstDayOfMonth(2021, 1-1)); //1월 
		
		//이벤트 
		
		//보여주기
		setVisible(true);
		setSize(780, 780);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//요일 생성 
	public void createDay() {
		for(int i=0;i<7;i++) {
			DateBox dayBox=new DateBox(dayArray[i],Color.GRAY,100,70);
			p_center.add(dayBox); //센터에 부착!!
		}
	}
	
	//날짜 생성 
	public void createDate() {
		for(int i=0;i<dayArray.length*6;i++) {
			DateBox dateBox = new DateBox(Integer.toString(i), Color.orange, 100,100);
			p_center.add(dateBox); //센터에 부착!!
		}
	}
	
	//해당 월의 시작 요일 구하기!!
	//개발원리: 날짜 객체를 해당월의 1일로 조작한 후, 요일을 구한다!!
	//단 해당월과 연도는 매개변수로 호출자가 그 값을 결정할 수 있도록 메서드 정의하자
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal=Calendar.getInstance(); //날짜 객체 생성 
		cal.set(yy,mm, 1);//해당년도와 월의 1을로 조작!!
		return cal.get(Calendar.DAY_OF_WEEK)-1; //주의 js 에서의 습관이 있기에 요일은 0부터 시작하는 걸로..		
	}
	
	//해당월이 몇일까지 있는지 구하기!!  8월 31일, 9월 30일
	public int getLastDate() {
		Calendar cal = Calendar.getInstance();
		
		return 0;
	}
	
	public static void main(String[] args) {
		new Diary();
	}
}









