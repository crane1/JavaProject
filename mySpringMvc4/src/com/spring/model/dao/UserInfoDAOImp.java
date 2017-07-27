package com.spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.bean.UserInfo;

public class UserInfoDAOImp implements IUserInfoDAO {

	JdbcTemplate jt = null;
	
	@Override
	public UserInfo findUserByID(String id) {
		String sql = "select s_id, s_name from sims_student where s_id='" + id + "'";
		
		return jt.query(sql, new ResultSetExtractor<UserInfo>(){

			@Override
			public UserInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				UserInfo user = null;
				if(rs.next()){
					user = new UserInfo();
					user.setId(rs.getString("s_id"));
					user.setName(rs.getString("s_name"));
				}
				return user;
			}
		});
	}

	@Override
	public List<UserInfo> findAllUser() {
		String sql = "select s_id, s_name from sims_student";
		return jt.query(sql, new RowMapper<UserInfo>(){

			@Override
			public UserInfo mapRow(ResultSet rs, int arg1)
					throws SQLException {
				UserInfo user = null;
				if(rs.next()){
					user = new UserInfo();
					user.setId(rs.getString("s_id"));
					user.setName(rs.getString("s_name"));
				}
				return user;
			}
		});
	}

	@Override
	public UserInfo checkUserInfo(String id, String pwd) {
		String sql = "select s_id, s_pwd, s_name from sims_student where s_id='" + id + "'";
		
		UserInfo userInfo =  jt.query(sql, new ResultSetExtractor<UserInfo>(){

			@Override
			public UserInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				UserInfo user = null;
				if(rs.next()){
					String s_pwd = rs.getString("s_pwd");
					System.out.println("pwd, s_pwd " + pwd +" ," + s_pwd);
					if(pwd.equals(s_pwd)){
						user = new UserInfo();
						user.setId(rs.getString("s_id"));
						user.setName(rs.getString("s_name"));
					}
				}
				return user;
			}
		});
		
		return userInfo;
	}
	

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Test
	public void testDAO(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		IUserInfoDAO userDao = (IUserInfoDAO) ac.getBean("userDAO");
		System.out.println(userDao.checkUserInfo("1", "123"));
	}

}
