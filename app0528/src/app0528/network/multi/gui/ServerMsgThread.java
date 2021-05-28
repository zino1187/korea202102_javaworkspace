package app0528.network.multi.gui;

import java.net.Socket;

public class ServerMsgThread extends Thread{
	
	Socket socket;
	
	public ServerMsgThread(Socket socket) {
		this.socket=socket;
		
	}
}
