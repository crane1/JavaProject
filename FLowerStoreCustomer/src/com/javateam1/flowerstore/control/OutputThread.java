package com.javateam1.flowerstore.control;

import java.io.PrintStream;

public class OutputThread extends Thread{
	private PrintStream br;
	private String data;
	
	public OutputThread(PrintStream br, String data){
		this.br = br;
		this.data = data;
	}
	
	public void run(){
		br.println(data);
	}
}
