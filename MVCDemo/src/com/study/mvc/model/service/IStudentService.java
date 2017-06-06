package com.study.mvc.model.service;

import java.util.List;

import com.study.mvc.model.bean.Student;

public interface IStudentService {
	//��������
	int insert(Student stu, String pwd);
	
	//�޸�����
	int modify(Student stu);
	
	//ɾ������
	int delete(String id);
	
	//��ѯ��������
	List<Student> findAll();
	
	//ʹ��id��ѯһ������
	Student findStuById(String id);
	
	//ʹ��name��ѯ��������
	List<Student> findStusByName(String name);
	
	//ʹ��sex��ѯ��������
	List<Student> findStusBySex(String sex);
	
	//ʹ��age��Χ��ѯ��������
	List<Student> findStusByAgeRange(int startAge, int endAge);
	
	//ʹ�ñ�ҵԺУ��ѯ��������
	List<Student> findStusByGradInst(String gradInst);
	
	List<Student> findStusByCondition(String id, String name, String sex, int startAge, int endAge, String gradInst);
}
