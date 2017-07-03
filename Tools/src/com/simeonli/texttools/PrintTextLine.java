package com.simeonli.texttools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrintTextLine {
	static File file = new File("d:\\log.txt");
	
	static int filenum = 0;
	static BufferedWriter bw = null;
	{
		try {
			bw = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int printTextLine(File f){
//		System.out.println("Filename: " + f.getName());
		filenum++;
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = br.readLine()) != null){
				i++;
//				System.out.println(line+"         line" + i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int DelFile(File f){
		int i = 0;
		
		File[] farray = f.listFiles();
		if (farray == null){
			return 0;
		}
		
		for (File file : farray) {
			if (file.isFile() && file.getName().endsWith(".scc")){
				try {
					String name = file.getName();
					System.out.println("正在删除：" + name);
					bw.write("正在删除：" + name);
					file.delete();
					System.out.println("删除完成：" + name);
					bw.write("删除完成：" + name);
				} catch (IOException e) {
					System.out.println("异常了");
					e.printStackTrace();
				}
				i = i+1;
			}else{
				i += printDirTextLine(file);
			}
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
			if(file.getName().equals("dist")){
				continue;
			}
			if (file.isFile() && (file.getName().endsWith(".java")
					|| file.getName().endsWith(".jsp")
					|| file.getName().endsWith(".js")
					|| file.getName().endsWith(".css"))){
				i += printTextLine(file);
			}else{
				i += printDirTextLine(file);
			}
		}
		return i;
	}

	public static void main(String[] args) {
		new PrintTextLine();
		File dir = new File("D:\\workspace\\SIMSStruts2");
		int all = printDirTextLine(dir);
		System.out.println("共 "+all+" 行");
		System.out.println("共 "+filenum+" 个文件");
	}
}