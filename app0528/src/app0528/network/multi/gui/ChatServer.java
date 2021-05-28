package app0528.network.multi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server; //클라이언트의 접속을 감지하는 소켓!!(대화용 소켓 아님)
	/*쓰레드 구현의 3가지 방법
	 * 1.별도의 .java 파일로 생성(재사용성 높을때, 관리목적상 코드를 분리시키고 싶을때)
	 * 2. 내부익명으로..
	 * 3.Runnable 인터페이스를 구현
	 * */
	Thread serverThread; //메인메서드 대신 서버의 접속자 감지를 위한 무한대기를 처리할 쓰레드
	
	public ChatServer() {
		//생성 
		p_north = new JPanel();
		t_port = new JTextField(10);
		bt = new JButton("서버가동");
		area = new JTextArea();
		scroll  =new JScrollPane(area);
		
		//add
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//event 
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverThread = new Thread() {
					public void run() {
						startServer();
					}
				};
				serverThread.start(); //Runnable로 진입
			}
		});
		
		//view
		setVisible(true);
		setBounds(2700, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void startServer() {
		int port=Integer.parseInt(t_port.getText()); //포트 구하기
		
		try {
			server = new ServerSocket(port);
			
			area.append("서버 가동 및 접속자 감지중..\n");
			while(true) {
				Socket socket = server.accept(); //접속자 감지를 위한 대기!!(메인 쓰레드를 절대로 이용하지 말자)
				String ip = socket.getInetAddress().getHostAddress();
				area.append(ip+"님 접속\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}




