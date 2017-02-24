package com.simeonli.texttools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintTextLine {
	
	public static int printTextLine(File f){
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			
			while(br.readLine() != null){
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static int printDirTextLine(File f){
		int i = 0;
		File[] farray = f.listFiles();
		if (farray == null){
			return 0;
		}
		for (File file : farray) {
			if (file.isFile() && file.getName().endsWith(".java")){
				int num = printTextLine(file);
				System.out.println("文件" + file.getAbsolutePath()+ ": " + num + "行");
				i += num;
			}else{
				i += printDirTextLine(file);
			}
		}
		return i;
	}

	public static void main(String[] args) {
//		File f = new File("src/com/simeonli/texttools/PrintTextLine.java");
//		int lineNum = printTextLine(f);
//		System.out.println("文件：" + f.getName() + " " + lineNum + "行");
		
		File dir = new File("d:\\workspace");
		int all = printDirTextLine(dir);
		System.out.println(dir.getName() + "下java文件总共" + all + "行");
	}
}