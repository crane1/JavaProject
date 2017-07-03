package com.mvc.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
	
	//重定向输出到文件
	public void setPrintToFile(String FileName){
		PrintStream printStream = null;
		
		{
			try {
				printStream = new PrintStream(new FileOutputStream(new File(FileName), true));
				System.setOut(printStream);
				System.setErr(printStream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
