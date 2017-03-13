package com.javateam1.flwoerstore.control;


import java.io.BufferedReader;
import java.io.IOException;

public class InputThread extends Thread{
	private BufferedReader br;
	private TCPServer server;
	DataHandle dataHandle = new DataHandle();
	
	
	public InputThread(TCPServer server,BufferedReader br){
		this.br = br;
		this.setServer(server);
		dataHandle.setServer(server);
		
	}
	
	public void run(){
		String str = null;
		while(true){
			try {
				str = br.readLine();
				dataHandle.handleData(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public TCPServer getServer() {
		return server;
	}

	public void setServer(TCPServer server) {
		this.server = server;
	}
}
