package com.study.mvc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.study.mvc.model.bean.Student;


public class DBUtil {
	private static DBUtil dbUtil = null;
	private  Connection conn = null;
	private  String driver = ""; 
	private  String url = "";
	private  String username = "";
	private  String pwd = "";
	
	private DBUtil(){
		Properties p = new Properties();
		try {
			//加载配置文件
			p.load(this.getClass().getResourceAsStream("config.properties"));
			driver = p.getProperty("driver","oracle.jdbc.OracleDriver");
			url = p.getProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
			username = p.getProperty("userName","scott");
			pwd = p.getProperty("pwd","tiger");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DBUtil getInstance(){
		if(dbUtil == null){
			dbUtil = new DBUtil();
		}
		return dbUtil;
	}
	
	public  Connection getConn(){
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接失败！");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private  void closeConn(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Map<String, String> queryStudent(String id, String pwd) {
		getConn(); //获取链接
		Map<String, String> infoMap = null;
		try {
			String sql = "select s.s_id, s.s_name, s.s_sex, s.s_age, s.s_gradinst, s.s_pwd from s_student s where s.s_id='" + id + "'"; 
			Statement state = conn.createStatement();
			
			ResultSet resultSet = state.executeQuery(sql);
			
			while(resultSet.next()){
				if(resultSet.getString("s_pwd").equals(pwd)){
					infoMap = new HashMap<String, String>();
					infoMap.put("name", resultSet.getString("s_name"));
					infoMap.put("sex", resultSet.getString("s_sex"));
					infoMap.put("age", resultSet.getString("s_age"));
					infoMap.put("gradinst", resultSet.getString("s_gradinst"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoMap;
	}
	
	public int executeUpdate(String sql){
		int res = -1;
		try {
			Statement state = conn.createStatement();
			res = state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ResultSet query(String sql){
		ResultSet res = null;
		
		try {
			Statement state = conn.createStatement();
			res = state.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
				
	}
	
	public static void main(String[] args) {
		DBUtil dbutil = DBUtil.getInstance();
		Map<String, String> uers = dbutil.queryStudent("java020701","123");
		System.out.println(uers);
	}

	
	
}
