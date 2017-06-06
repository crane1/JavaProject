package com.sims.mvc.model.service;

import java.util.List;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.IStudentFindDAO;
import com.sims.mvc.model.dao.IStudentUpdateDAO;
import com.sims.mvc.model.dao.StudentFindDAOImp;
import com.sims.mvc.model.dao.StudentUpdateDAOImp;

public class StudentServiceImp implements IStudentService{
	private IStudentFindDAO stuFind;
	private IStudentUpdateDAO stuUpdate;
	
	public StudentServiceImp() {
		stuFind = new StudentFindDAOImp();
		stuUpdate = new StudentUpdateDAOImp();
	}
	

	@Override
	public int addStudent(Student student) {
		return stuUpdate.addStudent(student);
	}

	@Override
	public int deleteStuent(Student student) {
		return stuUpdate.deleteStuent(student);
	}

	@Override
	public int modifyStudent(Student student) {
		return stuUpdate.modifyStudent(student);
	}

	@Override
	public Student findStudentById(String id) {
		return stuFind.findStudentById(id);
	}

	@Override
	public List<Student> findStudentByName(String name) {
		return stuFind.findStudentByName(name);
	}

	@Override
	public List<Student> findStudentBySex(String sex) {
		return stuFind.findStudentBySex(sex);
	}

	@Override
	public List<Student> findStudentByAgeRange(int startAge, int endAge) {
		return stuFind.findStudentByAgeRange(startAge, endAge);
	}

	@Override
	public List<Student> findStudentByGradFrom(String gradFrom) {
		return stuFind.findStudentByGradFrom(gradFrom);
	}

	@Override
	public List<Student> findStudentByTelphone(int telephone) {
		return stuFind.findStudentByTelphone(telephone);
	}

	@Override
	public List<Student> findStudentByAddress(String address) {
		return stuFind.findStudentByAddress(address);
	}

	@Override
	public List<Student> findStudentByIDCard(String idCard) {
		return stuFind.findStudentByIDCard(idCard);
	}

	@Override
	public List<Student> findStudentByEmail(String email) {
		return stuFind.findStudentByEmail(email);
	}

	@Override
	public List<Student> findStudentByTeamID(String teamId) {
		return stuFind.findStudentByTeamID(teamId);
	}

	@Override
	public List<Student> findStudentByClassID(String classId) {
		return stuFind.findStudentByClassID(classId);
	}

	@Override
	public List<Student> findStudentByCondition(String id, String name,
			String sex, int startAge, int endAge, String gradFrom,
			int telephone, String address, String idCard, String email,
			String teamId, String classId) {
		return stuFind.findStudentByCondition(id, name, sex, startAge, endAge,
				gradFrom, telephone, address, idCard, email, teamId, classId);
	}

}
