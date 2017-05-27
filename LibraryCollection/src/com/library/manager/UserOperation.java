package com.library.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.library.model.Book;
import com.library.model.Record;
import com.library.model.User;
import com.library.tools.Tools;

public class UserOperation {
	private static int idCount = 1;  //用于记录id自动计数
	private static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * 方法名： borrowBook 借书<br>
	 * 功能说明： 根据传入的用户，图书，和图书个数生成借书的记录,将这条记录添加入记录库中<br>
	 * @param user
	 * @param book
	 * @param bookCnt<br>
	 */
	public boolean borrowBook(User user, Book book, int bookCnt){
		boolean flag = false;
		
		if(book.getBookRemainderNum() - bookCnt >= 0){
			Record record = createRecord(user, book, bookCnt, 0);
			book.setBookRemainderNum(book.getBookRemainderNum() - bookCnt);
			Menu.recordManager.addRecord(record);
			flag = true;
		}else{
			Tools.printContent("Mes_cntNotEnough");
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 方法名： borrowBooks 借多本书<br>
	 * 功能说明： 重复收集借阅信息，添加借阅记录，直到用户退出借阅<br>
	 * @param user<br>
	 */
	public void borrowBooks(User user){
		while(true){
			String bookId = Tools.getInputString("Mes_inputBookId");
			Book book = Menu.bookManager.findBookById(bookId);
			if(book == null){
				Tools.printContent("Mes_borBookNoExist");
			}else{
				String str = Tools.getInputInt("Mes_borrowCnt");
				int bookCnt = -1;
				if(Tools.isBack(str)){
					return;
				}else{
					bookCnt = Integer.parseInt(str);
				}
				
				if(bookCnt > 0){
					borrowBook(user, book, bookCnt);
				}else{
					Tools.printContent("Mes_CntLessOne");
				}
			}
			String isContinue = Tools.getInputString("Mes_isContinue");
			if(!(isContinue.equals("Y") || isContinue.equals("y"))){
				break;
			}
		}
	}
	
	/**
	 * 
	 * 方法名： returnBook 还书<br>
	 * 功能说明： 根据传入的用户，图书，和图书个数生成还书的记录,将这条记录添加入记录库中<br>
	 * @param user
	 * @param book
	 * @param bookCnt<br>
	 */
	public void returnBook(User user, Book book, int bookCnt){
		Record record = createRecord(user, book, bookCnt, 1);
		book.setBookRemainderNum(book.getBookRemainderNum() + bookCnt);
		Menu.recordManager.addRecord(record);
	}
	
	public void returnBooks(User user){
		while(true){
			String bookId = Tools.getInputString("Mes_inputBookId");
			List<Record> records = Menu.recordManager.findRecordsByBookId(user, bookId);
			int recordCnt = 0;
			for(Record r: records){
				if(r.getType() == 0){
					recordCnt += r.getBookCnt();
				}else{
					recordCnt -= r.getBookCnt();
				}
				
			}
			if(recordCnt < 1){
				Tools.printContent("Mes_BookNoLend");
			}else{
				
				String str = Tools.getInputInt("Mes_returnCnt");
				int bookCnt = -1;
				if(Tools.isBack(str)){
					return;
				}else{
					bookCnt = Integer.parseInt(str);
				}
				
				if(bookCnt > 0){  //还书记录>0
					//还书记录<=借阅记录
					if(bookCnt <= recordCnt){
						Book book = Menu.bookManager.findBookById(bookId);
						returnBook(user, book, bookCnt);
					}else{
						Tools.printContent("Mes_cntMoreBor");
					}
				}else{
					Tools.printContent("Mes_CntLessOne");
				}
			}
			String isContinue = Tools.getInputString("Mes_isContinue");
			if(!(isContinue.equals("Y") || isContinue.equals("y"))){
				break;
			}
		}
	}
	
	/**
	 * 
	 * 方法名： createRecord 生成记录<br>
	 * 功能说明： 根据传入的用户，图书，图书个数和操作类型生成还书的记录,将这条记录添加入记录库中<br>
	 * @param user
	 * @param book
	 * @param bookCnt<br>
	 */
	public Record createRecord(User user, Book book, int bookCnt, int type){
		Record record = new Record();
		record.setBookId(book.getBookId());
		record.setBookCnt(bookCnt);
		record.setId(idCount++);
		record.setDate(formater.format(new Date()));
		record.setType(type);
		record.setUserId(user.getId());
		return record;
	}
}
