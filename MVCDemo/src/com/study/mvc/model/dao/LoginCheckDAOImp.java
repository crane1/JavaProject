package com.study.mvc.model.dao;

import java.util.Map;

import com.study.mvc.model.bean.Student;
import com.study.mvc.tools.DBUtil;

public class LoginCheckDAOImp implements ILoginCheckDAO {

	@Override
	public Student checkLoginUser(String id, String pwd) {
		DBUtil util = DBUtil.getInstance();
		Student stu = null;
		
		Map<String, String> stuMap = util.queryStudent(id, pwd);
		
		if(stuMap != null){
			stu = new Student();
			stu.setS_id(id);
			stu.setS_name(stuMap.get("name"));
			stu.setS_sex(stuMap.get("sex"));
			stu.setS_age(Integer.parseInt(stuMap.get("age")));
			stu.setS_gradInst(stuMap.get("gradinst"));
		}
		
		return stu;
	}

}
