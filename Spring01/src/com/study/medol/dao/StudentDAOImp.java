package com.study.medol.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.study.medol.bean.Student;

public class StudentDAOImp implements IStudentDAO {
	private JdbcTemplate jt;
	
	public StudentDAOImp() {
	}
	
	@Override
	public Student findStudenById(String id) {
		String sql = "select * from student where id='" + id + "'";
		return jt.query(sql, new ResultSetExtractor<Student>(){

			@Override
			public Student extractData(ResultSet res) throws SQLException,
					DataAccessException {
				Student stu = null;
				if(res.next()){
					stu = new Student();
					stu.setId(res.getString("id"));
					stu.setName(res.getString("name"));
				}
				return stu;
			}
			
		});
	}

	@Override
	public List<Student> findStudensByName(String name) {
		String sql = "select * from student where name like '%" + name + "%'";
		
		return jt.query(sql, new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet res, int arg1) throws SQLException {
				Student stu = null;
					stu = new Student();
					stu.setId(res.getString("id"));
					stu.setName(res.getString("name"));
				return stu;
			}
			
		});

	}

	@Override
	public int updateStudent(Student stu) {
		String sql = "update student set name=? where id=?";
		return jt.update(sql, new Object[] {stu.getName(), stu.getId()});
	}

	@Override
	public int addStudent(Student stu) {
		String sql = "insert into student values(?,?,?,?,?)";
		System.out.println("stu----------------" + stu);
		return jt.update(sql, new Object[] { stu.getId(), stu.getName(), stu.getAge(), stu.getSex(), stu.getGradFrom()});
	}

	@Override
	public int deleteStudent(String id) {
		String sql = "delete student where id=" + id;
		return jt.update(sql);
	}
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Test
	public void testDAo(){
		ClassPathXmlApplicationContext ac =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		IStudentDAO stuDAo = (IStudentDAO) ac.getBean("studentDAOImp");
		System.out.println(stuDAo.addStudent(new Student("2","李泽明", 23, 0, "草滩皇家工业学院")));
	}

}
