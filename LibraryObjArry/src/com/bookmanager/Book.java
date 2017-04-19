/**
 *   �������ƣ�ͼ����
 *   ����˵������װͼ����Ϣ
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��13�� ����12:20:43
 *   �����ߣ�
 *   
 *   
 */
package com.bookmanager;

/**
 *   �����ƣ�ͼ����
 *   ��˵������װͼ����Ϣ
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��13�� ����12:20:43
 *   �����ߣ�
 *   
 *   
 */
public class Book {
	private String bookId;    //ͼ����
	private String bookName;    //ͼ������
	private String bookAuthor;    //ͼ������
	private String bookPublish;    //ͼ�������
	private int bookTotalNum;    //ͼ��������
	private int bookRemainderNum;    //ͼ��������
	private String bookType;    //ͼ������
	
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
		return "Book [ͼ���ţ�" + bookId + ", ͼ�����ƣ�" + bookName
				+ ", ͼ�����ߣ�" + bookAuthor + ", �����磺" + bookPublish
				+ ", ͼ��������" + bookTotalNum + ", ͼ��������"
				+ bookRemainderNum + ", ͼ�����ͣ�" + bookType + "]";
	}
	
	
}
