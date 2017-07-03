package com.sims.mvc.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUtil {
	private static DBUtil dbUtil = null;
	private  Connection conn = null;
	private  String driver = ""; 
	private  String url = "";
	private  String username = "";
	private  String pwd = "";
	
	public DBUtil(){
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
	
	private  boolean closeConn(){
		boolean flag = true;
		
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库关闭失败");
				flag = false;
			}
		}
		
		return flag;
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
	
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@SuppressWarnings("resource")
	@Test
	public void testDButil(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ContextApplication.xml");
		DBUtil dbutil = (DBUtil) ac.getBean("dbutil");
		String pwd = "1234";
		String id = "1";
		String sql = "update sims_student set s_pwd = '" + pwd + "' where s_id = '" + id + "'";
		System.out.println(sql);
		int res = dbutil.executeUpdate(sql);
		System.out.println(res);
	}
}
