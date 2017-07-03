package com.sims.mvc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
	
	private  boolean getConn(){
		boolean flag = true;
		
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���ݿ�����ʧ�ܣ�");
				flag = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		
		return flag;
	}
	
	private  boolean closeConn(){
		boolean flag = true;
		
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���ݿ�ر�ʧ��");
				flag = false;
			}
		}
		
		return flag;
	}
	
	//��������
	public int executeUpdate(String sql){
		int res = -1;
		if(getConn()){
			try {
				Statement state = conn.createStatement();
				System.out.println(sql);
				res = state.executeUpdate(sql);
				System.out.println(res);
			} catch (SQLException e) {
				//e.printStackTrace();
				
				System.out.println("���ݿ��쳣:" + e.getMessage());
			}
		}
		
		return res;
	}
	
	//��ѯ����
	public ResultSet query(String sql){
		ResultSet res = null;
		if (getConn()){
			try {
				Statement state = conn.createStatement();
				res = state.executeQuery(sql);
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("���ݿ��쳣:" + e.getMessage());
				StackTraceElement[] trace = e.getStackTrace();
				for(StackTraceElement ste : trace){
					
				}
				System.out.println("���ݿ��쳣:" + e.getMessage());
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		DBUtil dbutil = DBUtil.getInstance();
		String pwd = "1234";
		String id = "1";
		String sql = "update sims_student set s_pwd = '" + pwd + "' where s_id = '" + id + "'";
		System.out.println(sql);
		int res = dbutil.executeUpdate(sql);
		System.out.println(res);
	}
}
