package com.sims.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;

public class LoginDAOImp implements ILoginDAO {
	static DBUtil dbutil = null;

	public LoginDAOImp() {
	}

	@Override
	public Student checkLogin(String id, String pwd) {

		String sql = "select s.s_id,s.s_pwd,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,"
			+ "s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_teamid,s.s_classid,s.isleader,"
			+ "s.ismonitor,s.ismanteach,s.isteacteach,s.isnormadmin "
			+ "from sims_student s  where s.s_id='"+ id + "'";
		Student stu = null;
		ResultSet rs = dbutil.query(sql);
		try {
			if (rs.next()) {
				if (pwd.equals(rs.getString("s_pwd"))) {
					stu = new Student();
					stu.setId(rs.getString("s_id"));
					stu.setName(rs.getString("s_name"));
					stu.setSex(rs.getString("s_sex"));
					stu.setAge(rs.getInt("s_age"));
					stu.setGradFrom(rs.getString("s_gradFrom"));
					stu.setTel(rs.getLong("s_tel"));
					stu.setAddr(rs.getString("s_addr"));
					stu.setIdCard(rs.getString("s_idcard"));
					stu.setEmail(rs.getString("s_email"));
					stu.setTeamID(rs.getString("s_teamid"));
					stu.setClassID(rs.getString("s_classid"));
					stu.setT_leader(rs.getInt("isleader"));
					stu.setC_monitor(rs.getInt("ismonitor"));
					stu.setC_man_teacher(rs.getInt("ismanteach"));
					stu.setC_teac_teacher(rs.getInt("isteacteach"));
					stu.setNormal_manager(rs.getInt("isnormadmin"));
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public int checkID(String id) {
		int rec = -1;
		String sql = "select s.s_id,s.s_name from sims_student s where s.s_id='"
				+ id + "'";
		ResultSet rs = dbutil.query(sql);
		System.out.println(rs);
		try {
			if (rs.next()) {
				rec = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rec;
	}

	public static String checkPermi(String per, String id) {
		String rec = "";
		if (per.equals("stu")) {
			rec = "success";
		} else {
			String sql = "select " + per + " from sims_student  where s_id='"
					+ id + "'";
			ResultSet rs = null;
			try {
				rs = dbutil.query(sql);
				while (rs.next()) {
					int perda = rs.getInt(per);
					if (perda == 1) {
						rec = "success";
					} else {
						rec = "fail";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rec;
	}

	public static DBUtil getDbutil() {
		return dbutil;
	}

	public static void setDbutil(DBUtil dbutil) {
		LoginDAOImp.dbutil = dbutil;
	}
	
	
}
