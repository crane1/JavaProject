package com.javateam1.flowerstore.control;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	private Socket  socket = null;
	private BufferedReader cin = null;
	static PrintStream cout = null;
	
	public void startTCP(){
		try {
			socket = new Socket("127.0.0.1",4700);
			
			//��ȡsocket������
			cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// ��ȡsocket�����
			cout = new PrintStream(socket.getOutputStream());
			
			InputThread input = new InputThread(this,cin);
			input.start();
		} catch (UnknownHostException e) {
			System.out.println("����ʧ�ܣ�δ�ҵ�����");
			e.printStackTrace();
		} catch (ConnectException e){
			System.out.println("�����쳣");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void pushData(String data){
		OutputThread output = new OutputThread(cout, data);
		output.start();
	}

}
