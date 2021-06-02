package app0602.cal.diary;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//날짜 한개를 표현할 박스
public class DateBox extends JPanel{
	public DateBox() {
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.YELLOW);
	}
}
