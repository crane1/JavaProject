package com.sims.mvc.model.dao;

import com.sims.mvc.model.bean.Student;

public interface IStudentUpdateDAO {
	
	//添加学生
	int addStudent(Student student);
	
	//删除学生
	int deleteStuent(Student student);
	
	//修改学生
	int modifyStudent(Student student);
}
