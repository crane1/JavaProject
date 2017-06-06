package com.sims.mvc.model.bean;

public class Student {
	private String id;	//学号
	private String name;	//姓名
	private String sex;	//性别
	private int age;	//年龄
	private String gradFrom;	//毕业院校
	private int tel;	//电话号码
	private String addr;	//地址
	private String idCard;	//身份证号码
	private String email;	//邮箱
	private String teamID;	//组id
	private String classID;	//班级id
	
	public Student() {}

	public Student(String id, String name, String sex, int age,
			String gradFrom, int tel, String addr, String idCard, String email,
			String teamID, String classID) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.gradFrom = gradFrom;
		this.tel = tel;
		this.addr = addr;
		this.idCard = idCard;
		this.email = email;
		this.teamID = teamID;
		this.classID = classID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGradFrom() {
		return gradFrom;
	}

	public void setGradFrom(String gradFrom) {
		this.gradFrom = gradFrom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}
}
