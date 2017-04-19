package com.library.bookmanager;

import java.util.List;

import com.library.book.Book;
import com.library.tools.ConstStr;
import com.library.tools.Tools;

public class Menu {
	BookManager manager = new BookManager();
	
	/**
	 * 
	 * 方法名： showMainMenu 显示主菜单<br>
	 * 功能说明： 显示主菜单<br>
	 */
	public void showMainMenu(){
		while(true){
			Tools.printContent("Mes_menuWelcom");
			Tools.printContent("Mes_findBooks");
			Tools.printContent("Mes_addBooks");
			Tools.printContent("Mes_modBooks");
			Tools.printContent("Mes_delBooks");
			int type = Tools.getInputInt("Mes_selectOperation");
			switch(type){
			case ConstStr.FIN_BOOK:
				showFindMenu();
				break;
			case ConstStr.ADD_BOOK:
				manager.operateBook(ConstStr.ADD_BOOK);
				break;
			case ConstStr.MOD_BOOK:
				manager.operateBook(ConstStr.MOD_BOOK);
				break;
			case ConstStr.DEL_BOOK:
				showFindMenu();
				break;
			default:
				Tools.printContent("Mes_noIndefineOperation");
			}
		}
	}
	
	public void showFindMenu(){
		while(true){
			Tools.printContent("Mes_selectFindType");
			Tools.printContent("Attr_Id");
			Tools.printContent("Attr_name");
			Tools.printContent("Attr_author");
			Tools.printContent("Attr_publish");
			Tools.printContent("Attr_type");
			int type = Tools.getInputInt("Mes_selectOperation");
			String keyWord = Tools.getInputString("Mes_inputFindContent");
			switch(type){
			case ConstStr.ATTR_ID:
				Book book= manager.findBookById(keyWord);
				if(book == null){
					Tools.printContent("Mes_noFindRecord");
				}else{
					manager.printBook(book);
				}
				
				break;
			case ConstStr.ATTR_NAME:
			case ConstStr.ATTR_AUTHOR:
			case ConstStr.ATTR_PUBLISH:
			case ConstStr.ATTR_TYPE:
				List<Book> books = manager.findBookByKeyWord(keyWord, type);
				if(books.size() == 0){
					Tools.printContent("Mes_noFindRecord");
				}else{
					manager.printBooks(books);
				}
				
				break;
			case ConstStr.BACK:
				return;
			default:
				Tools.printContent("Mes_noIndefineOperation");
			}
		}
	}
	
	public static void main(String[] args) {
		new Menu().showMainMenu();
	}

}
