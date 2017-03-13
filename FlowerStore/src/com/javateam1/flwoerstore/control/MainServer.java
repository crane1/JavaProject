package com.javateam1.flwoerstore.control;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainServer {
	public void initMainServer(){
		ServerSocket server = null;
		Socket client = null;
		try {
			// 1.创建ServerSocket对象，并绑定端口
			server = new ServerSocket(4700);
			System.out.println("服务器启动成功");
			
			while(true){
				client = server.accept();
				SocketAddress s = client.getRemoteSocketAddress();
				InetAddress is = client.getInetAddress();
				System.out.println(is + "链接成功");
				
				TCPServer tcp = new TCPServer(client);
				tcp.start();
			}
			
		} catch (IOException e) {
			System.out.println("服务器启动失败");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MainServer ms = new MainServer();
		ms.initMainServer();
	}
	
}
