package com.library.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ReadList {
	/**
	 * 
	 * 方法名： saveData 保存数据到文件<br>
	 * 功能说明： 根据传入的List和类型对数据进行保存<br>
	 * @param list
	 * @param type
	 * @return<br>
	 */
	public static <T> List<T> readData( int type){
		List<T> list = null;
		
		switch(type){
		case ConstStr.READ_BOOK: 
			list = readDataFromFile( "book_list.data");
			break;
		case ConstStr.READ_USER: 
			list = readDataFromFile( "user_list.data");
			break;
		case ConstStr.READ_RECORD: 
			list = readDataFromFile( "record_list.data");
			break;
		default:
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> readDataFromFile(String filename){
		List<T> list = null;
		File file = new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			ObjectInputStream oos = new ObjectInputStream( new FileInputStream(file));
			list = (List<T>)oos.readObject();
			oos.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
