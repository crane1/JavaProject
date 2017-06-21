package com.sims.mvc.model.dao;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;

public class StudentUpdateDAOImp implements IStudentUpdateDAO {
	DBUtil dbutil=null;
	public StudentUpdateDAOImp(){
		dbutil=dbutil.getInstance();
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
				+"',	s_team='"+(student.getTeamID()==null?"":student.getTeamID())
				+"',	s_class='"+(student.getClassID()==null?"":student.getClassID())
				+"',    t_leader="+student.getT_leader()
				+",     c_monitor="+student.getC_monitor()
				+",     c_man_teacher="+student.getC_man_teacher()
				+",     c_teac_teacher="+student.getC_teac_teacher()
				+",     normal_manager="+student.getNormal_manager()
				+"  where s_id='"+student.getId() + "'";
		System.out.println(sql);
		System.out.println("°àid:-------------------"+student.getC_monitor());
		System.out.println("db:"+dbutil.executeUpdate(sql));
		return dbutil.executeUpdate(sql);
	}
	@Override
	public int modifyStudentPWD(String id, String pwd) {
		String sql="update sims_student s set s.s_pwd="+pwd+" where s.s_id='" + id + "'";
		return dbutil.executeUpdate(sql);
	}

}
