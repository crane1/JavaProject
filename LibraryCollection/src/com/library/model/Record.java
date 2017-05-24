package com.library.model;

public class Record {
	int id;  // ��¼���
	String userId;
	String bookId; // ͼ����
	int bookCnt; // ͼ���¼����
	String date; // ��¼����
	int type; //0���ģ�1����
	
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Record(int id, String userId, String bookId, int bookCnt,
			String date, int type) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.bookCnt = bookCnt;
		this.date = date;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getBookCnt() {
		return bookCnt;
	}

	public void setBookCnt(int bookCnt) {
		this.bookCnt = bookCnt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", userId=" + userId + ", bookId=" + bookId
				+ ", bookCnt=" + bookCnt + ", date=" + date + ", type=" + (type == 0?"borrow":"return")
				+ "]";
	}
}
