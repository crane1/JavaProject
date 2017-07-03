package com.mvc.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
	
	//�ض���������ļ�
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
