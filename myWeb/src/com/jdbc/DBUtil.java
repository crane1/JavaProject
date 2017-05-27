package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.model.UserInfo;


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
	
	public  UserInfo queryUser(String id, String pwd){
		getConn(); //获取链接
		boolean flag = false;
		UserInfo user = null;
		try {
			String sql = "select id, name, pwd, qx from users where id=?"; //查询该id对应的用户是否存在
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, id);
			
			ResultSet resultSet = state.executeQuery();
			
			if(resultSet.next()){
				int qx = resultSet.getInt("qx");
				String rePwd = resultSet.getString("pwd");
				flag = pwd.equals(rePwd);  // 判断pwd是否相等
				if(flag){
					user = new UserInfo(id, resultSet.getString("name"), pwd, qx);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		closeConn();
		return user;
	}
	
	public  UserInfo queryUserById(String id){
		getConn(); //获取链接
		boolean flag = false;
		UserInfo user = null;
		try {
			String sql = "select id, name, pwd, qx from users where id=?"; //查询该id对应的用户是否存在
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, id);
			
			ResultSet resultSet = state.executeQuery();
			
			if(resultSet.next()){
				user = new UserInfo(id, resultSet.getString("name"), pwd, resultSet.getInt("qx"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		closeConn();
		return user;
	}
	
	public boolean addUser(UserInfo user){
		boolean flag = false;
		getConn(); //获取链接
		try {
			String sql = "insert into users(id, name, pwd, qx) values(?, ?, ?, ?)"; //查询该id对应的用户是否存在
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, user.getId());
			state.setString(2, user.getName());
			state.setString(3, user.getPwd());
			state.setInt(4, user.getQx());
			
			System.out.println(user);
			
			int result = state.executeUpdate();
			flag = result > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static void main(String[] args) {
		DBUtil dbutil = DBUtil.getInstance();
		UserInfo user = dbutil.queryUser("1","123");
		System.out.println("我是" + user.getName() + ", 我要找一个水瓶座的女朋友");
	}
	
}
