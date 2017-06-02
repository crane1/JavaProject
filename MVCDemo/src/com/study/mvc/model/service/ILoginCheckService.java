package com.study.mvc.model.service;

import com.study.mvc.model.bean.Student;

public interface ILoginCheckService {
	
	//验证用户正确性
	Student checkLoginUser(String id, String pwd);
}
