package com.study.mvc.model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.OracleBlobInputStream;
import oracle.jdbc.oracore.OracleType;

import com.study.mvc.model.bean.Student;
import com.study.mvc.tools.DBUtil;
import com.study.mvc.tools.PageManager;

public class StudentDAOImp implements IStudentDAO {
	private DBUtil dbutil= DBUtil.getInstance();
	
	@Override
	public int insert(Student stu, String pwd) {
		String sql = "insert s_student values("
				+ stu.getS_id() + "," 
				+ stu.getS_name() + "', '" 
				+ stu.getS_sex() + "', " 
				+ stu.getS_age() + ", '" 
				+ stu.getS_gradInst() + "','"
				+ pwd + "'";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int modify(Student stu) {
		String sql = "update s_student set s_name='" 
				+ stu.getS_name() + "', s_sex='" 
				+ stu.getS_sex() + "', s_age=" 
				+ stu.getS_age() + ", s_gradinst='" 
				+ stu.getS_gradInst() + "' where s_id='"
				+ stu.getS_id() + "'";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int delete(String id) {
		String sql = "delete from s_student where s_id='" + id + "'";
		
		return dbutil.executeUpdate(sql);
	}

	@Override
	public List<Student> findAll() {
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student";
		return getResultList(sql);
	}

	@Override
	public Student findStuById(String id) {
		Student stu = null;
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student where s_id='" + id + "'";
		ResultSet res = dbutil.query(sql);
		
		try {
			while(res.next()){
				stu = new Student(res.getString("s_id"),
						res.getString("s_name"), 
						res.getString("s_sex"), 
						res.getInt("s_age"),
						res.getString("s_gradInst")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public List<Student> findStusByName(String name) {
		List<Student> list = null;
		String sql = "{? = call getPageRows(?, ?, ?, ?)}";
		CallableStatement stat;
		try {
			stat = dbutil.getConn().prepareCall(sql);
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			stat.registerOutParameter(5, OracleTypes.INTEGER);
			
			if(!PageManager.initFlag){
				PageManager.PageManagerInit(8, 1);
				PageManager.initFlag = true;
			}
			
			stat.setInt(2, PageManager.getMaxPageRows());
			stat.setInt(3, PageManager.getCurPageNo());
			stat.setString(4, name);
			
			System.out.println("11111" + PageManager.getMaxPageRows());
			System.out.println("11111" + PageManager.getCurPageNo());
			
			stat.execute();
			ResultSet res = (ResultSet)stat.getObject(1);
			System.out.println(stat.getObject(5));
			PageManager.setMaxRowNumber((int)stat.getObject(5));
			
			while(res.next()){
				if(list == null){
					list = new ArrayList<Student>();
				}
				
				Student stu = new Student();
				stu.setS_id(res.getString("s_id"));
				stu.setS_name(res.getString("s_name"));
				stu.setS_age(res.getInt("s_age"));
				stu.setS_sex(res.getString("s_sex"));
				stu.setS_gradInst(res.getString("s_gradinst"));
				
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("---------------imp list:" + list);
		return list;
	}

	@Override
	public List<Student> findStusBySex(String sex) {
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student where s_name='" + sex + "'";
		return getResultList(sql);
	}

	@Override
	public List<Student> findStusByAgeRange(int startAge, int endAge) {
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student where s_age between " + startAge + " and " + endAge;
		return getResultList(sql);
	}

	@Override
	public List<Student> findStusByGradInst(String gradInst) {
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student where s_name='" + gradInst + "'";
		return getResultList(sql);
	}
	
	@Override
	public List<Student> findStusByCondition(String id, String name, String sex, int startAge, int endAge, String gradInst){
		String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student where ";
		
		boolean needAnd = false;
		
		if(id != null && !id.equals("")){
			sql += needAnd ? (" and s_id='" + id + "' ") : ("s_id='" + id + "' ");
			needAnd = true;
		}
		
		if(name != null && !name.equals("")){
			sql += needAnd ? (" and s_name='" + name + "' ") : ("s_name='" + name + "' ");
			needAnd = true;
		}
		
		if(sex != null && !sex.equals("")){
			sql += needAnd ? (" and s_sex='" + sex + "' ") : ("s_sex='" + sex + "' ");
			needAnd = true;
		}
		
		if(startAge >= 0 && endAge >= 0){
			sql += needAnd ? (" and s_age>=" + startAge + " and s_age<=" + endAge +" ") : ("  s_age>=" + startAge + " and s_age<=" + endAge +" ");
			needAnd = true;
		}
		
		if(gradInst != null && !gradInst.equals("")){
			sql += needAnd ? (" and s_gradInst='" + gradInst + "' ") : ("s_gradInst='" + gradInst + "' ");
			needAnd = true;
		}
		
		System.out.println(sql);
//		System.out.println("size:" + getResultList(sql).size());
		return getResultList(sql);
	}
	
	public List<Student> getResultList(String sql){
		List<Student> list = null;
		
		ResultSet res = dbutil.query(sql);
		
		try {
			while(res.next()){
				if(list == null){
					list = new ArrayList<Student>();
				}
				Student stu = new Student(res.getString("s_id"),
						res.getString("s_name"), 
						res.getString("s_sex"), 
						res.getInt("s_age"),
						res.getString("s_gradInst")
						);
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
