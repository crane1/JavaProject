package com.study.mvc.model.dao;

import com.study.mvc.model.bean.Student;

public interface ILoginCheckDAO {
	//��֤�û���ȷ��
	Student checkLoginUser(String id, String pwd);
}
