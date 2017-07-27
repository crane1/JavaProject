package com.spring.model.service;

import java.util.List;

import com.spring.model.bean.UserInfo;

public interface IUserInfoService {
	//ͨ��Ψһid��ѯ
	UserInfo findUserByID(String id);
	
	//��ѯ����
	List<UserInfo> findAllUser();
	
	UserInfo checkUserInfo(String id, String pwd);
	
}
