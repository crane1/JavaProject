package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
			//���������ļ�
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
				System.out.println("���ݿ�����ʧ�ܣ�");
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
	
	public  UserInfo queryUser(int id, String pwd){
		getConn(); //��ȡ����
		boolean flag = false;
		UserInfo user = null;
		try {
			Statement state = conn.createStatement();  // �����Ự
			String sql = "select id, name, pwd from users where id=" + id;  //��ѯ��id��Ӧ���û��Ƿ����
			System.out.println(sql);
			ResultSet resultSet = state.executeQuery(sql);
			
			if(resultSet.next()){
				String rePwd = resultSet.getString("pwd");
				flag = pwd.equals(rePwd);  // �ж�pwd�Ƿ����
				if(flag){
					user = new UserInfo(id, resultSet.getString("name"), pwd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		closeConn();
		return user;
	}
	
	
	public static void main(String[] args) {
		DBUtil dbutil = DBUtil.getInstance();
		UserInfo user = dbutil.queryUser(1,"123");
		System.out.println("����" + user.getName() + ", ��Ҫ��һ��ˮƿ����Ů����");
	}
	
}
