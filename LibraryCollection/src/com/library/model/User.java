/**
 *   程序名称：用户类模型<br>
 *   功能说明：封装用户类<br>
 *   做成者：ChianSofti.java170207.lizm    2017年4月19日 19:30:05<br>
 *   更新者：<br>
 *   
 *   
 */
package com.library.model;

/**
 *   类名称：用户类
 *   类说明：封装用户信息
 *   做成者：ChianSofti.java170207.lizm    2017年4月19日 19:30:05
 *   更新者：
 *   
 *   
 */
public class User {
	private String id;
	private String pwd;
	private String name;
	private int right;  //0普通用户   1 管理员  2 超级管理员
	
	
	public User(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.right = 0;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
}
