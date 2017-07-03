package com.sims.mvc.model.service;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.ILoginDAO;
import com.sims.mvc.model.dao.LoginDAOImp;

public class LoginServiceImp implements ILoginService {
    private ILoginDAO loginDao;
    
    public LoginServiceImp(){
    }
    
	@Override
	public Student checkStuInfo(String id, String pwd) {
		return loginDao.checkLogin(id, pwd);
	}

	@Override
	public int checkID(String id) {
		return loginDao.checkID(id);
	}

	public ILoginDAO getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	
}
