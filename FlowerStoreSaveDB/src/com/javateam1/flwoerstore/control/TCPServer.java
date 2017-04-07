package com.javateam1.flwoerstore.control;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCPServer extends Thread{
	Socket client;
	BufferedReader cin;
	PrintStream cout;
	static int num = 0;
	
	
	public TCPServer(Socket s){
		this.client = s;
	}
	
	public void run(){
		try{
			//获取客户端输入流
			cin = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			
			// 获取客户端输出流
			cout = new PrintStream(this.client.getOutputStream());
			
			InputThread input = new InputThread(this,cin);
			input.start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void pushData(String data){
		OutputThread output = new OutputThread(cout, data);
		output.start();
	}
}
