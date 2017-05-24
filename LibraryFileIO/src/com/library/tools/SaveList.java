package com.library.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveList {
	/**
	 * 
	 * 方法名： saveData 保存数据到文件<br>
	 * 功能说明： 根据传入的List和类型对数据进行保存<br>
	 * @param list
	 * @param type
	 * @return<br>
	 */
	public static <T> boolean saveData(List<T> list, int type){
		boolean flag = false;
		switch(type){
		case ConstStr.SAVE_BOOK: 
			flag = saveDataToFile(list, "book_list.data");
			break;
		case ConstStr.SAVE_USER: 
			flag = saveDataToFile(list, "user_list.data");
			break;
		case ConstStr.SAVE_RECORD: 
			flag = saveDataToFile(list, "record_list.data");
			break;
		default:
		}
		
		return flag;
	}
	
	public static <T> boolean saveDataToFile(List<T> list, String filename){
		File file = new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(file));
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
