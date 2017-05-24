package com.model;

public class Message {
	int mesId;
	int userId;
	String userName;
	String mesg;
	String date;
	private static int count = 0;
	public int getMesId() {
		return mesId;
	}
	
	public Message( int userId, String userName, String mesg, String date) {
		super();
		this.mesId = ++count;
		this.userId = userId;
		this.userName = userName;
		this.mesg = mesg;
		this.date = date;
	}
	
	public Message() {
		super();
	}
	
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
