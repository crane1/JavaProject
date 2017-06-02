package com.study.mvc.model.bean;

public class Student {
	private String s_id;
	private String s_name;
	private String s_sex;
	private int s_age;
	private String s_gradInst;
	public Student() {}
	public Student(String s_id, String s_name, String s_sex, int s_age,
			String s_gradInst) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_age = s_age;
		this.s_gradInst = s_gradInst;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public String getS_gradInst() {
		return s_gradInst;
	}
	public void setS_gradInst(String s_gradInst) {
		this.s_gradInst = s_gradInst;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_sex="
				+ s_sex + ", s_age=" + s_age + ", s_gradInst=" + s_gradInst
				+ "]";
	}
	
}
