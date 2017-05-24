package work0426.work008_chat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			final Socket client = new Socket("127.0.0.1", 8888);
			
			new Thread(){
				public void run() {
					BufferedReader bis;
					try {
						bis = new BufferedReader(new InputStreamReader(client.getInputStream()));
						String str = null;
						while(true){
							str = bis.readLine();
							System.out.println("服务器说：" + str);
							if(str.equals("88")){
								System.out.println("服务器下线");
								return;
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				};
			}.start();
			
			new Thread(){
				public void run() {
					BufferedWriter bw;
					try {
						bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
						String str = null;
						while(true){
							str = sc.nextLine();
							bw.write(str + "\n");
							bw.flush();
							if(str.equals("88")){
								System.out.println("下线");
								return;
							}
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				};
			}.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
