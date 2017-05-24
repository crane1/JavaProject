package work0426.work003_filepath;
import java.io.File;


public class PrintFilePath {
	public static void printFilePath(File f){
		if(f.isFile()){
			String allPath = f.getPath();
			String path = allPath.substring(0,allPath.lastIndexOf("\\") - 1);
			String fileName = allPath.substring(allPath.lastIndexOf("\\") + 1);
			System.out.println("路径：" + path + ",    文件名" +fileName);
		} else {
			File[] flist = f.listFiles();
			for(File file : flist){
				printFilePath(file);
			}
		}
		
	}
	public static void main(String[] args) {
		printFilePath(new File("F:/Sinuous"));
	}
}
