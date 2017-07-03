package com.study.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.study.bean.User;

public class HelloAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String mesg = null;

	@Override
	public String execute() throws MyException {
		throw new MyException("--------fdskfjs");
	}
	
	public String add() throws Exception {
		System.out.println("add");
		throw new MyException("--------fdskfjs");
	}
	
	public String del() throws Exception {
		System.out.println("del");
		return SUCCESS;
	}
	
	public String upd() throws Exception {
		System.out.println("upd");
		return SUCCESS;
	}
	
	public String fin() throws Exception {
		System.out.println("fin");
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
}
