package com.lizm.beans;

public class Message {
	int id;
	String commod;
	String descript;
	String context;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String commod, String descript, String context) {
		super();
		this.id = id;
		this.commod = commod;
		this.descript = descript;
		this.context = context;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommod() {
		return commod;
	}
	public void setCommod(String commod) {
		this.commod = commod;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", commod=" + commod + ", descript=" + descript + ", context=" + context + "]";
	}
	
	
}
