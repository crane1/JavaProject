package com.study.medol.dao;

import java.util.List;

import com.study.medol.bean.Student;

public class StudentService implements IStudentService{
	IStudentDAO stuDao = null;
	
	@Override
	public Student findStudenById(String id) {
		stuDao.findStudenById(id);
		return null;
	}

	@Override
	public List<Student> findStudensByName(String name) {
		stuDao.findStudensByName(name);
		return null;
	}

	@Override
	public int updateStudent(Student stu) {
		stuDao.updateStudent(stu);
		return 0;
	}

	@Override
	public int addStudent(Student stu) {
		stuDao.addStudent(stu);
		return 0;
	}

	@Override
	public int deleteStudent(String id) {
		stuDao.deleteStudent(id);
		return 0;
	}

	public IStudentDAO getStuDao() {
		return stuDao;
	}

	public void setStuDao(IStudentDAO stuDao) {
		this.stuDao = stuDao;
	}

}
