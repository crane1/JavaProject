package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.model.Student;


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
	
	private  void getConn(){
		if(conn == null){
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(url, username, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接失败！");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
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
	
	
	public  List<Student> queryStudents(){
		getConn(); //获取链接
		List<Student> stu_list = null;
		try {
			String sql = "select s_id, s_name, s_sex, s_age, s_gradInst from s_student"; 
			Statement state = conn.createStatement();
			
			ResultSet resultSet = state.executeQuery(sql);
			
			while(resultSet.next()){
				if(stu_list == null){
					stu_list = new ArrayList<Student>();
				}
				Student stu_temp = new Student(resultSet.getString("s_id"),
						resultSet.getString("s_name"), 
						resultSet.getString("s_sex"), 
						resultSet.getInt("s_age"),
						resultSet.getString("s_gradInst")
						);
				stu_list.add(stu_temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu_list;
	}
	
	public static void main(String[] args) {
		DBUtil dbutil = DBUtil.getInstance();
		List<Student> uers = dbutil.queryStudents();
		System.out.println(uers);
	}
	
}
