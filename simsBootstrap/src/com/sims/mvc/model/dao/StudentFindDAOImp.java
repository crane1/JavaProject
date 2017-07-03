package com.sims.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;

public class StudentFindDAOImp implements IStudentFindDAO{
	private DBUtil dbutil;
	
	//查询出过pwd(密码)的所有属性
	private final String SQL="select s.s_id,s.s_pwd,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,"
			+ "s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_team,s.s_class,s.t_leader,"
			+ "s.c_monitor,s.c_man_teacher,s.c_teac_teacher,s.normal_manager from sims_student s ";
	
	public StudentFindDAOImp(){
		dbutil=DBUtil.getInstance();
	}
	
	public String createSqlByString(String condition){
		return SQL + condition;
	}
	
	
	@Override
	public Student findStudentById(String id) {
		String condition =" where s.s_id='" + id + "'";
		
		String sql = createSqlByString(condition);
		
		Student stu=null;
		ResultSet rs=dbutil.query(sql);
		try {
			if(rs.next()){
				stu = createStudent(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentBySex(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByAgeRange(int startAge, int endAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByGradFrom(String gradFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByTelphone(int telephone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByIDCard(String idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByTeamID(String teamId) {
		List<Student> list=null;
		String sql=null;
		sql="select s.s_id,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_team,t.t_name from sims_student s,sims_team t where t.t_id = s.s_team and t.t_id='"+teamId+"'";
		ResultSet rs = dbutil.query(sql);
		try {
			while(rs.next()){
				Student stu=new Student();
				stu.setId(rs.getString("s_id"));
				stu.setName(rs.getString("s_name"));
				stu.setSex(rs.getString("s_sex"));
				stu.setAge(rs.getInt("s_age"));
				stu.setGradFrom(rs.getString("s_gradFrom"));
				stu.setAddr(rs.getString("s_addr"));
				stu.setIdCard(rs.getString("s_idcard"));
				stu.setEmail(rs.getString("s_email"));
				stu.setTeamID(rs.getString("s_team"));
				if(rs.isFirst()){
					list=new ArrayList<Student>();
				}
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findStudentByClassID(String classId) {
		String sql="";
		String condition = "";
		if(classId==null||classId.equals("")){
			condition = " WHERE sst.s_class is null";
			
		}else{
			condition = " WHERE sst.s_class='"+classId + "'";
		}
		
		sql= createSqlByString(condition);
		ResultSet rs = dbutil.query(sql);
		System.out.println(rs);
		List<Student> list=null;
	    Student stu=null;
	      try {
			while(rs.next()){
				 stu= createStudent(rs);
				 if(rs.isFirst()){
					 list=new ArrayList<Student>();
				 }
				 list.add(stu);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findStudentByCondition(String id, String name,
			String sex, int startAge, int endAge, String gradFrom,
			int telephone, String address, String idCard, String email,
			String teamId, String classId) {

		return null;
	}
	@Override
	public List<Student> findStudentAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Student> findStudentByIsAdmin() {
		String condition =" WHERE sst.normal_manager=1";
		String sql = createSqlByString(condition);
		
		ResultSet rs = dbutil.query(sql);
		System.out.println(rs);
		List<Student> list=null;
	    Student stu=null;
	      try {
			while(rs.next()){
				stu=createStudent(rs);
				 if(rs.isFirst()){
					 list=new ArrayList<Student>();
				 }
				 list.add(stu);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
		return list;
	}
	
	
	private Student createStudent(ResultSet rs){
		Student stu=new Student();
		
		try {
			stu.setId(rs.getString("s_id"));
			stu.setName(rs.getString("s_name"));
			stu.setSex(rs.getString("s_sex"));
			stu.setAge(rs.getInt("s_age"));
			stu.setGradFrom(rs.getString("s_gradFrom"));
			stu.setTel(rs.getLong("s_tel"));
			stu.setAddr(rs.getString("s_addr"));
			stu.setIdCard(rs.getString("s_idcard"));
			stu.setEmail(rs.getString("s_email"));
			stu.setTeamID(rs.getString("s_team"));
			stu.setClassID(rs.getString("s_class"));
			stu.setT_leader(rs.getInt("t_leader"));
			stu.setC_monitor(rs.getInt("c_monitor"));
			stu.setC_man_teacher(rs.getInt("c_man_teacher"));
			stu.setC_teac_teacher(rs.getInt("c_teac_teacher"));
			stu.setNormal_manager(rs.getInt("normal_manager"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}

}
