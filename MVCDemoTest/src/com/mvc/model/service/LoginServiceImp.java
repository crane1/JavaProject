package com.mvc.model.service;

import com.mvc.model.bean.User;
import com.mvc.model.dao.ILoginDAO;
import com.mvc.model.dao.LoginDAOImp;

public class LoginServiceImp implements ILoginService {
	ILoginDAO loginDAO = null;
	
	public LoginServiceImp() {
		loginDAO = new LoginDAOImp();
	}

	@Override
	public User checkUserExist(int id, String pwd) {
		return loginDAO.checkUserExist(id, pwd);
	}

}
