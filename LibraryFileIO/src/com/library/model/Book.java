/**
 *   �������ƣ�����
 *   ����˵������װ����Ϣ
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��17�� ����10:30:44
 *   �����ߣ�
 *   
 *   
 */
package com.library.model;

import com.library.tools.Tools;

/**
 *   �����ƣ�Book ��
 *   ��˵������װ����Ϣ
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��17�� ����10:30:44
 *   �����ߣ�
 *   
 *   
 */
public class Book {
	private String bookId = null;    //ͼ����  ͼ������� ����Ψһ�� һ���������ܸ���
	private String bookName = null;    //ͼ������
	private String bookAuthor = null;    //ͼ������
	private String bookPublish = null;    //ͼ�������
	private int bookTotalNum = 0;    //ͼ��������
	private int bookRemainderNum = 0;    //ͼ��������
	private String bookType = null;    //ͼ������
	
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
		return "Book [ͼ���ţ�" + bookId + ", ͼ�����ƣ�" + bookName
				+ ", ͼ�����ߣ�" + bookAuthor + ", �����磺" + bookPublish
				+ ", ͼ��������" + bookTotalNum + ", ͼ��������"
				+ bookRemainderNum + ", ͼ�����ͣ�" + bookType + "]";
	}
	
}
