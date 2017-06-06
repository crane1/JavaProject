package com.study.mvc.model.service;

import java.util.List;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.dao.IStudentDAO;
import com.study.mvc.model.dao.StudentDAOImp;

public class StudentServiceImp implements IStudentService{
	private IStudentDAO stuDAO = new StudentDAOImp();

	@Override
	public int insert(Student stu, String pwd) {
		return stuDAO.insert(stu, pwd);
	}

	@Override
	public int modify(Student stu) {
		return stuDAO.modify(stu);
	}

	@Override
	public int delete(String id) {
		return stuDAO.delete(id);
	}

	@Override
	public List<Student> findAll() {
		return stuDAO.findAll();
	}

	@Override
	public Student findStuById(String id) {
		return stuDAO.findStuById(id);
	}

	@Override
	public List<Student> findStusByName(String name) {
		return stuDAO.findStusByName(name);
	}

	@Override
	public List<Student> findStusBySex(String sex) {
		return stuDAO.findStusBySex(sex);
	}

	@Override
	public List<Student> findStusByAgeRange(int startAge, int endAge) {
		return stuDAO.findStusByAgeRange(startAge, endAge);
	}

	@Override
	public List<Student> findStusByGradInst(String gradInst) {
		return stuDAO.findStusByGradInst(gradInst);
	}

	@Override
	public List<Student> findStusByCondition(String id, String name,
			String sex, int startAge, int endAge, String gradInst) {
		return stuDAO.findStusByCondition(id, name, sex, startAge, endAge, gradInst);
	}

}
