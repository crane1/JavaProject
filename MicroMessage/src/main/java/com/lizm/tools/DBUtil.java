package com.lizm.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DBUtil {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=GBK";
	private String username = "root";
	private String pwd = "root";
	
	private Connection conn;
	
	public void getConn(){
		try {
			Class.forName(driver); //加载驱动
			conn = DriverManager.getConnection(url,username, pwd); //获取链接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet excuteQuery(String sql){
		ResultSet res = null;
		getConn();
		try {
			Statement statement = conn.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Test
	public void testDB(){
		String sql = "select id, commod, descript, context from micro_message  where id is not null  and commod like '%你%' and descript like '%语%'"; 
		ResultSet excuteQuery = excuteQuery(sql);
		System.out.println(sql);
		try {
			if(excuteQuery.next()){
				System.out.println("commod:" + excuteQuery.getString("commod"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
