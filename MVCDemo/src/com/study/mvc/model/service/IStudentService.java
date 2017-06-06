package com.study.mvc.model.service;

import java.util.List;

import com.study.mvc.model.bean.Student;

public interface IStudentService {
	//插入数据
	int insert(Student stu, String pwd);
	
	//修改数据
	int modify(Student stu);
	
	//删除数据
	int delete(String id);
	
	//查询所有数据
	List<Student> findAll();
	
	//使用id查询一条数据
	Student findStuById(String id);
	
	//使用name查询多条数据
	List<Student> findStusByName(String name);
	
	//使用sex查询多条数据
	List<Student> findStusBySex(String sex);
	
	//使用age范围查询多条数据
	List<Student> findStusByAgeRange(int startAge, int endAge);
	
	//使用毕业院校查询多条数据
	List<Student> findStusByGradInst(String gradInst);
	
	List<Student> findStusByCondition(String id, String name, String sex, int startAge, int endAge, String gradInst);
}
