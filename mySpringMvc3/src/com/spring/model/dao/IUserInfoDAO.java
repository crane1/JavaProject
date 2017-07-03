package com.spring.model.dao;

import java.util.List;

import com.spring.model.bean.UserInfo;

public interface IUserInfoDAO {
	//ͨ��Ψһid��ѯ
	UserInfo findUserByID(String id);
	
	//��ѯ����
	List<UserInfo> findAllUser();
	
	//��֤�û���������
	UserInfo checkUserInfo(String id, String pwd);
		
}
