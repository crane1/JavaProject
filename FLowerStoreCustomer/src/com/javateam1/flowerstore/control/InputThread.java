package com.javateam1.flowerstore.control;


import java.io.BufferedReader;
import java.io.IOException;


public class InputThread extends Thread{
	private BufferedReader br;
	private TCPClient client;
	DataHandle dataHandle = new DataHandle();
	
	
	public InputThread(TCPClient client,BufferedReader br){
		this.br = br;
		this.setClient(client);
		dataHandle.setClient(client);
		
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

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}
}
