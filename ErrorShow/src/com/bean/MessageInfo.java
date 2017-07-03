package com.bean;

import java.util.Date;

public class MessageInfo {
	private String title;
	private String userName;
	private String content;
	private Date date;
	
	public MessageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageInfo(String title, String userName, String content, Date date) {
		super();
		this.title = title;
		this.userName = userName;
		this.content = content;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
