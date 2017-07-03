package com.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
	
	public Connection getConn(){
		
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接失败！");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	//更新数据
		public int executeUpdate(String sql){
			int res = -1;
			if(getConn() != null){
				try {
					Statement state = conn.createStatement();
					res = state.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return res;
		}
		
		//查询数据
		public ResultSet query(String sql){
			ResultSet res = null;
			if (getConn() != null){
				try {
					Statement state = conn.createStatement();
					res = state.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return res;
		}
		
	
	public static void main(String[] args) {
		DBUtil dbUtil = DBUtil.getInstance();
		ResultSet query = dbUtil.query("select * from userInfo");
		System.out.println(query);
	}
}
