package com.mvc.model.service;

import com.mvc.model.bean.User;

public interface ILoginService {
	User checkUserExist(int id, String pwd);
}
