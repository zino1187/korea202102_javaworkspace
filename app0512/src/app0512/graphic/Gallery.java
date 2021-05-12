package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gallery extends JFrame{
	//커스터마이징 할 필요가 있으니, JPanel의 코드를 수정하자
	GalleryDetail galleryDetail; //상세이미지 그려질 패널
	
	JPanel p_south; //커스터마이징 할필요없으니깐 그냥 쓰자
	JButton bt_prev;
	JButton bt_next;
	
	//겔러리에 사용할 데이터 즉 배열을 준비하자!!!
	String dir="D:/workspace/korea202102_javaworkspace/app0512/res/images"; //디렉토리
	String[] arr= {"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg"};//파일명
	Toolkit kit;
	Image[] image=new Image[arr.length]; //배열생성
	
	public Gallery() {
		//생성
		galleryDetail = new GalleryDetail();
		p_south = new JPanel();
		bt_prev = new JButton("이전 사진");
		bt_next = new JButton("다음 사진");
		kit = Toolkit.getDefaultToolkit(); //인스턴스 얻기!! new하지 않고, 자바에서 준비된 메서드 이용
		
		for(int i=0;i<arr.length;i++) {
			image[i]=kit.getImage(dir+"/"+arr[i]);
		}
		
		//이미지가 생성되었으므로, 0번째 즉 첫번째 이미지를
		//디폴트로 그려지게 하자!!
		galleryDetail.setImage(image[0]);
		
		
		//레이아웃, 스타일 
		galleryDetail.setBackground(Color.CYAN);
		
		//조립 
		add(galleryDetail);//CENTER 영역에 부착
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south, BorderLayout.SOUTH);
		
		//보여주기
		setBounds(1600, 100,500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Gallery();
	}
}




