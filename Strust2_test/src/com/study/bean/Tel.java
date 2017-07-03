package com.study.bean;

public class Tel {
	private String first  = null;
	private String second = null;
	
	
	public Tel() {}
	public Tel(String first, String second) {
		super();
		this.first = first;
		this.second = second;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	
	
}
