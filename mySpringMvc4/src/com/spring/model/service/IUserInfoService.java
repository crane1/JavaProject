package com.spring.model.service;

import java.util.List;

import com.spring.model.bean.UserInfo;

public interface IUserInfoService {
	//通过唯一id查询
	UserInfo findUserByID(String id);
	
	//查询所有
	List<UserInfo> findAllUser();
	
	UserInfo checkUserInfo(String id, String pwd);
	
}
