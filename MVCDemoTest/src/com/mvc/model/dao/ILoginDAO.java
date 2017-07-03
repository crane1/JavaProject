package com.mvc.model.dao;

import com.mvc.model.bean.User;

public interface ILoginDAO {
	User checkUserExist(int id, String pwd);
}
