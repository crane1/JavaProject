package com.sims.mvc.model.service;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.ILoginDAO;
import com.sims.mvc.model.dao.LoginDAOImp;

public class LoginServiceImp implements ILoginService {
    private ILoginDAO loginDao;
    
    public LoginServiceImp(){
    	//资源准备
    	loginDao=new LoginDAOImp();
    }
    
	@Override
	public Student checkStuInfo(String id, String pwd) {
		return loginDao.checkLogin(id, pwd);
	}

	@Override
	public int checkID(String id) {
		return loginDao.checkID(id);
	}

	@Override
	public String checkPermi(String permissions, String userId) {
		return loginDao.checkPermi(permissions, userId);
	}
}
