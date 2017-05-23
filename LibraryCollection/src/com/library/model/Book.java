/**
 *   程序名称：书类
 *   功能说明：封装书信息
 *   做成者：ChianSofti.java170207.lizm    2017年4月17日 上午10:30:44
 *   更新者：
 *   
 *   
 */
package com.library.model;

import com.library.tools.Tools;

/**
 *   类名称：Book 书
 *   类说明：封装书信息
 *   做成者：ChianSofti.java170207.lizm    2017年4月17日 上午10:30:44
 *   更新者：
 *   
 *   
 */
public class Book {
	private String bookId = null;    //图书编号  图书的主键 具有唯一性 一旦给定不能更改
	private String bookName = null;    //图书名称
	private String bookAuthor = null;    //图书作者
	private String bookPublish = null;    //图书出版社
	private int bookTotalNum = 0;    //图书库存总量
	private int bookRemainderNum = 0;    //图书库存余量
	private String bookType = null;    //图书类型
	
	public Book() {
		super();
	}

	public Book(String bookId, String bookName, String bookAuthor,
			String bookPublish, int bookTotalNum, int bookRemainderNum,
			String bookType) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublish = bookPublish;
		this.bookTotalNum = bookTotalNum;
		this.bookRemainderNum = bookRemainderNum;
		this.bookType = bookType;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		if(this.bookId == null){
			this.bookId = bookId;
		}else{
			Tools.printComment("bookid" +this.bookId + ".");
			Tools.printContent("Mes_bookIdCantModify");
		}
		
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		if(bookName.equals("")){
			return;
		}
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		if(bookAuthor.equals("")){
			return;
		}
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(String bookPublish) {
		if(bookPublish.equals("")){
			return;
		}
		this.bookPublish = bookPublish;
	}

	public int getBookTotalNum() {
		return bookTotalNum;
	}

	public void setBookTotalNum(int bookTotalNum) {
		this.bookTotalNum = bookTotalNum;
	}

	public int getBookRemainderNum() {
		return bookRemainderNum;
	}

	public void setBookRemainderNum(int bookRemainderNum) {
		this.bookRemainderNum = bookRemainderNum;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		if(bookPublish.equals("")){
			return;
		}
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		return "Book [图书编号：" + bookId + ", 图书名称：" + bookName
				+ ", 图书作者：" + bookAuthor + ", 出版社：" + bookPublish
				+ ", 图书总量：" + bookTotalNum + ", 图书余量："
				+ bookRemainderNum + ", 图书类型：" + bookType + "]";
	}
	
}
