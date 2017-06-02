package com.library.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
	String id;  // ��¼���
	String userId;
	String bookId; // ͼ����
	int bookCnt; // ͼ���¼����
	Date date; // ��¼����
	int type; //0���ģ�1����
	
	public Record() {
		super();
	}

	public Record(String userId, String bookId, int bookCnt,
			String date, int type) {
		super();
		this.id = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		this.userId = userId;
		this.bookId = bookId;
		this.bookCnt = bookCnt;
		this.date = new Date();
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
