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
	static BufferedWriter bw = null;
	{
		try {
			System.out.println("---------kaishi");
			bw = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int printTextLine(File f){
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			
			while(br.readLine() != null){
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			if (file.isFile() && file.getName().endsWith(".scc")){
				try {
					String name = file.getName();
					System.out.println("����ɾ����" + name);
					bw.write("����ɾ����" + name);
					file.delete();
					System.out.println("ɾ����ɣ�" + name);
					bw.write("ɾ����ɣ�" + name);
				} catch (IOException e) {
					System.out.println("�쳣��");
					e.printStackTrace();
				}
				
				
				i = i+1;
			}else{
				i += printDirTextLine(file);
			}
		}
		return i;
	}

	public static void main(String[] args) {
//		File f = new File("src/com/simeonli/texttools/PrintTextLine.java");
//		int lineNum = printTextLine(f);
//		System.out.println("�ļ���" + f.getName() + " " + lineNum + "��");
		
		new PrintTextLine();
		File dir = new File("d:\\workspace");
		int all = printDirTextLine(dir);
		System.out.println("ɾ���ļ� "+all+" ��");
	}
}