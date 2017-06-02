package com.study.mvc.model.dao;

import com.study.mvc.model.bean.Student;

public interface ILoginCheckDAO {
	//验证用户正确性
	Student checkLoginUser(String id, String pwd);
}
