package com.study.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.study.bean.Tel;

public class LoginAction extends ActionSupport implements ValidationAware{

	private static final long serialVersionUID = 1L;
	
	private String name = null;
	private Tel tel = null;
	private int age = 0;
	private String[] love = null;
	private String mesg = null;
	
//	public void validateExecute(){
//		if(age<0 || age>60){
//			addActionError("年龄不能超过60岁");
//		}
//	}


//	@Override
//	public void validate() {
////		if(age<0 || age>60){
////			addActionError("年龄不能超过60岁");
////		}
//	}

	@Override
	public String execute() throws Exception {
		//直接在action里面验证
//		if(age<0 || age>60){
//			setMesg("年龄不能超过60岁");
//			return INPUT;
//		}
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tel getTel() {
		return tel;
	}

	public void setTel(Tel tel) {
		this.tel = tel;
	}

	public String[] getLove() {
		return love;
	}

	public void setLove(String[] love) {
		this.love = love;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	

}
