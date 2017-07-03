package com.study.medol.bean;

public class Student {
	private String id;
	private String name;
	private int age;
	private int sex;
	private String gradFrom; 

	public Student() {}

	public Student(String id, String name, int age, int sex, String gradFrom) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.gradFrom = gradFrom;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getGradFrom() {
		return gradFrom;
	}

	public void setGradFrom(String gradFrom) {
		this.gradFrom = gradFrom;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", gradFrom=" + gradFrom + "]";
	}

}
