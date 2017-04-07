package com.javateam1.flowerstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDao {
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "scott";
	static String pwd = "tiger";
	
	//链接数据库
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
	
	// 查询数据
	public static ResultSet select(Connection conn, String sql) throws Exception{
		ResultSet rs = null;  //执行查询后的结果
		if(conn != null && !conn.isClosed()){
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		}
		return rs;
	}
	
	
	//更新数据
	public static int update(Connection conn, String sql) throws Exception{
		int count = 0;
		if(conn != null && !conn.isClosed()){
			Statement stm = conn.createStatement();
			count = stm.executeUpdate(sql);
		}
		return count;
	}
	
	// 关闭数据库
	public void close(Connection conn, String sql) throws Exception{
		if(conn != null && !conn.isClosed()){
			conn.close();
			conn = null;
		}
	}
}
