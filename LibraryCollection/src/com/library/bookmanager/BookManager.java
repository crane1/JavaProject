package com.library.bookmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import com.library.book.Book;
import com.library.tools.ConstStr;
import com.library.tools.Tools;

public class BookManager {
	private List<Book> bookList = new ArrayList<Book>(); //书库
	
	public BookManager(){
		//准备语言包资源
		Tools.initResourse();
	}
	
	/**
	 * 
	 * 方法名： setBookInfo 设置图书信息<br>
	 * 功能说明： 设置图书除Id以外的其他信息，id信息在添加之前的查询时提供，修改时不修改id<br>
	 * @param book<br>
	 */
	public void setBookInfo(Book book){
		book.setBookName(Tools.getInputString("Mes_inputBookName"));
		book.setBookAuthor(Tools.getInputString("Mes_inputBookAuthor"));
		book.setBookPublish(Tools.getInputString("Mes_inputBookPublish"));
		book.setBookType(Tools.getInputString("Mes_inputBookType"));
		book.setBookTotalNum(Tools.getInputInt("Mes_inputBookTotal"));
		book.setBookRemainderNum(Tools.getInputInt("Mes_inputBookRemain"));
	}
	
	/**
	 * 
	 * 方法名： operateBook 操作一个Book元素<br>
	 * 功能说明： 接收一个操作类型，先接收用户输入的一个id，在书列表中查找，返回查询结果，再进行分类操作<br>
	 * @param type 操作类型
	 * @return 返回操作是否成功<br>
	 */
	public boolean operateBook(int type){
		String id = Tools.getInputString("Mes_inputBookId"); // 接收一个id
		Book isExist = findBookById(id);  //记录查询结果
		boolean flag = false; //记录操作结果，是否添加成功
		
		switch(type){
		case ConstStr.ADD_BOOK:
			flag = addBook(isExist, id);
			break;
		case ConstStr.DEL_BOOK:
			flag = deleteBook(isExist);
			break;
		case ConstStr.MOD_BOOK:
			flag = modifyBook(isExist);
			break;
		default:
			Tools.printContent("Mes_noIndefineOperation");
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 方法名： addBook  添加图书<br>
	 * 功能说明： 如果图书编号已存在，那么不添加，否则添加<br>
	 * @param book 传入的需要添加的元素<br>
	 * @return 返回是否添加成功<br>
	 */
	public boolean addBook(Book book, String id){
		boolean flag = false; //操作结果
		
		// 查询结果不为空，表示已有
		if (book != null) {
			Tools.printContent("Mes_bookHasExist");
		} else {
			//设置新图书信息,并添加进图书列表
			Book newbook = new Book();
			newbook.setBookId(id);
			setBookInfo(newbook);
			bookList.add(newbook);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 方法名： deleteBook 删除图书<br>
	 * 功能说明： 根据传入的图书操作，如果存在则删除，否则提示不存在<br>
	 * @param book 传入的需要删除的元素<br>
	 * @return<br>
	 */
	public boolean deleteBook(Book book){
		boolean flag = false; //记录操作结果，是否添加成功
		
		// 查询结果不为空，表示已有
		if (book == null) {
			Tools.printContent("Mes_delBookNoExist");
		} else {
			//从图书列表中删除图书
			bookList.remove(book);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 方法名： modifyBook 修改图书信息<br>
	 * 功能说明： 根据传入的book操作，如果存在则修改，不存在提示不存在<br>
	 * @param book 需要修改的图书
	 * @return 返回操作是否成功<br>
	 */
	public boolean modifyBook(Book book){
		boolean flag = false; //记录操作结果，是否添加成功
		
		// 查询结果不为空，表示已有
		if (book == null) {
			Tools.printContent("Mes_modBookNoExist");
		} else {
			//对图书信息进行修改
			setBookInfo(book);
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 方法名： findBookById 通过id查Book信息
	 * 功能说明： 通过id这个唯一的主键，查询Book信息
	 * @param id 需要查询的id
	 * @return 需要返回查询到的Book引用
	 */
	public Book findBookById(String id){
		Book b = null;
		
		//循环变量查找与给定id相同的book元素
		for(Book book : bookList){
			if(book.getBookId().equals(id)){
				b = book;
			}
		}
		
		return b;
	}
	
	/**
	 * 
	 * 方法名： findBookByKeyWord 通过关键字和类型查询图书<br>
	 * 功能说明： 根据传入类型获取相应属性，并通过name比对查找是否存在<br>
	 * @param keyWord 需要检索的关键字
	 * @param type
	 * @return<br>
	 */
	public List<Book> findBookByKeyWord(String keyWord, int type){
		//使用list列表接收查询非主键得到的多个元素值
		List<Book> books = new ArrayList<Book>();
		
		//循环变量查找与给定name相同的book元素
		for(Book b : bookList){
			String attr = "";
			
			//根据不同类型取不同的属性值
			switch(type){
			case ConstStr.ATTR_NAME:
				attr = b.getBookName();
				break;
			case ConstStr.ATTR_AUTHOR:
				attr = b.getBookAuthor();
				break;
			case ConstStr.ATTR_PUBLISH:
				attr = b.getBookPublish();
				break;
			case ConstStr.ATTR_TYPE:
				attr = b.getBookType();
				break;
			default:
				Tools.printComment("");
			}
		
			String pattern = String.format(".*%s.*", keyWord);
			if(attr.matches(pattern)){
				books.add(b);
			}
		}
		
		return books;
	}
	
	public void printBook(Book book){
		Tools.printContent2(book.toString());
	}
	
	public void printBooks(List<Book> books){
		int i = 1;
		for(Book book : books){
			Tools.printContent2( i + "." + book.toString());
			i++;
		}
	}
	
	public static void main(String[] args) {
		new BookManager();
	}
}
