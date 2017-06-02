package com.study.mvc.model.service;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.dao.ILoginCheckDAO;
import com.study.mvc.model.dao.LoginCheckDAOImp;

public class LoginCheckServiceImp implements ILoginCheckService {

	@Override
	public Student checkLoginUser(String id, String pwd) {
		ILoginCheckDAO checkDao = new LoginCheckDAOImp();
		return checkDao.checkLoginUser(id, pwd);
	}

}
