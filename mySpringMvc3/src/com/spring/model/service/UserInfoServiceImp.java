package com.spring.model.service;

import java.util.List;

import com.spring.model.bean.UserInfo;
import com.spring.model.dao.IUserInfoDAO;

public class UserInfoServiceImp implements IUserInfoService {
	IUserInfoDAO userDAO = null;
	
	@Override
	public UserInfo findUserByID(String id) {
		
		return userDAO.findUserByID(id);
	}

	@Override
	public List<UserInfo> findAllUser() {
		
		return userDAO.findAllUser();
	}

	public IUserInfoDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserInfoDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserInfo checkUserInfo(String id, String pwd) {
		
		return userDAO.checkUserInfo(id, pwd);
	}
	
}
