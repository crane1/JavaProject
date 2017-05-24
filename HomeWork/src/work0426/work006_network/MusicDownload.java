package work0426.work006_network;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//网路下载文件
public class MusicDownload {
	public static void main(String[] args) {
		String address = "http://211.162.48.42/file3.data.weipan.cn/39184177/dfbc16a31ad01057d9b66cbe9a9afd295ac4f442?ip=1492506287,183.131.67.218&ssig=EkNqvXEroC&Expires=1492506887&KID=sae,l30zoo1wmz&fn=%E5%B0%8F%E5%B9%B8%E8%BF%90_%E7%94%B0%E9%A6%A5%E7%94%84.mp3&skiprd=2&se_ip_debug=183.131.67.218&corp=2&from=1221134&wsiphost=local";
		try {
			URL url = new URL(address);
			URLConnection opencoon = url.openConnection();
			opencoon.connect();
			InputStream in = opencoon.getInputStream();
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/小幸运.mp3"));
			
			byte[] b = new byte[1024];
			int n; 
			
			while((n = in.read(b)) != -1){
				bos.write(b, 0, n);
				System.out.println("下载完成"+n);
			}
			System.out.println("下载完成");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
