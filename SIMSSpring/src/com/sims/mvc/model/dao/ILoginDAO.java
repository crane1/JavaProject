package com.sims.mvc.model.dao;

import com.sims.mvc.model.bean.Student;

public interface ILoginDAO {
	//΢�۾���ִ���ߵ����ܹ�������
	public Student checkLogin(String id,String pwd);
	
	public int checkID(String id);
}
