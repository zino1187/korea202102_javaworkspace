package app0526.ex2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiBar extends JFrame{
	JButton bt;
	BarThread bar1;
	BarThread bar2;
	BarThread bar3;
	
	Thread t1;
	Thread t2;
	Thread t3;
	
	public MultiBar() {
		bar1 = new BarThread();
		bar2 = new BarThread();
		bar3 = new BarThread();
		bt=new JButton("Start!!");
		
		Dimension d = new Dimension(275, 35);
		bar1.setPreferredSize(d);
		bar2.setPreferredSize(d);
		bar3.setPreferredSize(d);
		
		setLayout(new FlowLayout());
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		setVisible(true);
		setBounds(2400, 100, 300, 190);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MultiBar();
	}
}



