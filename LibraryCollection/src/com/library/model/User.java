/**
 *   �������ƣ��û���ģ��<br>
 *   ����˵������װ�û���<br>
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��19�� 19:30:05<br>
 *   �����ߣ�<br>
 *   
 *   
 */
package com.library.model;

/**
 *   �����ƣ��û���
 *   ��˵������װ�û���Ϣ
 *   �����ߣ�ChianSofti.java170207.lizm    2017��4��19�� 19:30:05
 *   �����ߣ�
 *   
 *   
 */
public class User {
	private String id;
	private String pwd;
	private String name;
	private int right;  //0��ͨ�û�   1 ����Ա  2 ��������Ա
	
	
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
