package com.spring.model.dao;

import java.util.List;

import com.spring.model.bean.UserInfo;

public interface IUserInfoDAO {
	//通过唯一id查询
	UserInfo findUserByID(String id);
	
	//查询所有
	List<UserInfo> findAllUser();
	
	//验证用户名和密码
	UserInfo checkUserInfo(String id, String pwd);
		
}
