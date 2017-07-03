package com.study.medol.dao;

import java.util.List;

import com.study.medol.bean.Student;

public interface IStudentService {
	
	Student findStudenById(String id);
	
	List<Student> findStudensByName(String name);
	
	int updateStudent(Student stu);
	
	int addStudent(Student stu);
	
	int deleteStudent(String id);
}
