package com.sims.mvc.model.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;

public class StudentUpdateDAOImp implements IStudentUpdateDAO {
	DBUtil dbutil=null;
	public StudentUpdateDAOImp(){
	}
	@Override
	public int addStudent(Student student, String pwd) {
		String sql="insert into sims_student values('"+student.getId()+"','"+pwd+"','"+student.getName()+"','"+student.getSex()+"',"+student.getAge()+",'"+student.getGradFrom()+"',"+student.getTel()+",'"+student.getAddr()+"','"+student.getIdCard()+"','"+student.getEmail()+"',null,null,0,0,0,0,0)";
		 
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int deleteStuent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyStudent(Student student) {
		String sql="update sims_student "
				+ " set s_name='"+student.getName()
				+ "',   s_sex='"+student.getSex()
				+"',    s_age="+student.getAge()
				+",     s_gradfrom='"+student.getGradFrom()
				+"',    s_tel="+student.getTel()
				+",     s_addr='"+student.getAddr()
				+"',    s_idCard='"+student.getIdCard()
				+"',    s_email='"+student.getEmail()
				+"',	s_teamid='"+(student.getTeamID()==null?"":student.getTeamID())
				+"',	s_classid='"+(student.getClassID()==null?"":student.getClassID())
				+"',    isleader="+student.getT_leader()
				+",     ismonitor="+student.getC_monitor()
				+",     isnormadmin="+student.getC_man_teacher()
				+",     isteacteach="+student.getC_teac_teacher()
				+",     ismanteach="+student.getNormal_manager()
				+"  where s_id='"+student.getId() + "'";
		return dbutil.executeUpdate(sql);
	}
	@Override
	public int modifyStudentPWD(String id, String pwd) {
		String sql="update sims_student s set s.s_pwd="+pwd+" where s.s_id='" + id + "'";
		return dbutil.executeUpdate(sql);
	}
	public DBUtil getDbutil() {
		return dbutil;
	}
	public void setDbutil(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	@Test
	public void testupdatedao(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ContextApplication.xml");
		IStudentUpdateDAO stuupdao = (IStudentUpdateDAO) ac.getBean("studentUpdateDAOImp");
		int res = stuupdao.modifyStudentPWD("1", "123");
		System.out.println(res);
	}

}
