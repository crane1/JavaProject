/**
 *   程序名称：图书类
 *   功能说明：封装图书信息
 *   做成者：ChianSofti.java170207.lizm    2017年4月13日 下午12:20:43
 *   更新者：
 *   
 *   
 */
package com.bookmanager;

/**
 *   类名称：图书类
 *   类说明：封装图书信息
 *   做成者：ChianSofti.java170207.lizm    2017年4月13日 下午12:20:43
 *   更新者：
 *   
 *   
 */
public class Book {
	private String bookId;    //图书编号
	private String bookName;    //图书名称
	private String bookAuthor;    //图书作者
	private String bookPublish;    //图书出版社
	private int bookTotalNum;    //图书库存总量
	private int bookRemainderNum;    //图书库存余量
	private String bookType;    //图书类型
	
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
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(String bookPublish) {
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
