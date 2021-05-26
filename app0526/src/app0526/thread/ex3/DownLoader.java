package app0526.thread.ex3;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import util.ImageManager;

//웹상의 자원을 수집하고, 다운로드 받는 진행 상황을 프로그래스바로 표시하자!!
public class DownLoader extends JFrame{
	JTextField t_url;
	JButton bt;
	JProgressBar bar;
	ImageManager imageManager=new ImageManager();
	ImageIcon icon; //Icon 인터페이스를 구현한 클래스
	
	public DownLoader() {
		t_url = new JTextField();
		//resource 폴더로 등록된 자원은 클래스패스를 통해 접근해야 한다!! 
		//그리고 클래스패스와 관련된 정보를 얻으려면, Class 클래스를 이용하면 된다!!
		//자바의 클래스 중 class에 대한 정보를 가진 클래스가 Class 이다!! 이 Class 클래스를 이용하면, 클래스코드를 static에 올릴수
		//도 있고(Class.forName("드라이버명")) , 해당 클래스가 가진 메서드, 속성 등을 추출할수도 있다..
		//Class myClass = this.getClass();
		//Method[] methods=myClass.getMethods(); //이 클래스가 보유한 메서드 목록을 Method 객체배열로 반환
		//System.out.println("이 클래스가 보유한 메서드의 수는 "+methods.length);
		
		//개발자가 특정 디렉토리를 resource로 등록하면, getResource() 메서드로 
		//클래스 패스를 이용하여 접근이 가능~!!
		
		bt = new JButton(imageManager.getScaledIcon("bt.png",45, 38));
		bar = new JProgressBar();
		
		//style & layout
		setLayout(new FlowLayout());
		t_url.setPreferredSize( new Dimension(470,35));
		bar.setPreferredSize( new Dimension(470,35));
		
		//add
		add(t_url);
		add(bt);
		add(bar);
		
		setVisible(true);
		setBounds(2400, 100, 500, 140);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void test() {
	}
	public void test2() {
	}
	public static void main(String[] args) {
		new DownLoader(); 
		
	}
}







