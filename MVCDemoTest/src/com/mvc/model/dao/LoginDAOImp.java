package com.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.model.bean.User;
import com.mvc.tools.DBUtil;

public class LoginDAOImp implements ILoginDAO {
	private DBUtil dbutil= null;
	
	public LoginDAOImp() {
		dbutil = DBUtil.getInstance();  //»ñÈ¡µ¥Àýjdbc
	}

	@Override
	public User checkUserExist(int id, String pwd) {
		String sql = "select u.id, u.pwd from userTest u where id=" + id;
		
		User user = null;
		
		
		try {
			ResultSet res = dbutil.query(sql);
			while (res.next()) {
				String qPwd = res.getString("pwd");
				if(qPwd != null && qPwd.equals(pwd) ){
					user = new User(id, pwd);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
