package app0601.json.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//모든 접속 클라이언트 마다 1:1 대응하여, 서버측에 생성되는 대화용 클라이언트 쓰레드
//따라서 클라이언트가 접속을 끊으면, 서버측에 대응되는 이 객체 또한 소멸되어야 한다.
public class ServerMsgThread extends Thread{
	ChatServer chatServer;
	Socket socket;
	BufferedReader buffr;//듣고
	BufferedWriter buffw;//말하기
	boolean flag=true;
	
	public ServerMsgThread(Socket socket, ChatServer chatServer) {
		this.socket=socket;
		this.chatServer=chatServer;
		
		try {
			buffr= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고
	public void listen() {
		String msg=null;
		try {
			msg= buffr.readLine();
			
			//broadcasting !!!
			for(int i=0;i<chatServer.clientList.size();i++) {
				ServerMsgThread msgThread=chatServer.clientList.get(i);
				msgThread.send(msg);
			}
			
			chatServer.area.append(msg+"\n");//area에 로그 남기기 
		} catch (IOException e) {
			//e.printStackTrace();
			flag=false; //쓰레드 dead 상태로 두기 
			chatServer.clientList.remove(this);//명단에서도 제거
			chatServer.area.append("현재까지 참여자 수 : "+chatServer.clientList.size()+"\n");
		}
	}
	
	//말하기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고,말하는 행위는 서버이기에 끝없이!!! 즉 쓰레드가 절대 죽으면 안됨 
	public void run() {
		while(flag) {
			listen();
		}
	}
	
}













