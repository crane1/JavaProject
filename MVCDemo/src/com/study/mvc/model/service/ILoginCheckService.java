package com.study.mvc.model.service;

import com.study.mvc.model.bean.Student;

public interface ILoginCheckService {
	
	//��֤�û���ȷ��
	Student checkLoginUser(String id, String pwd);
}
