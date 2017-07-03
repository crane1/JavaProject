package com.study.mvc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DButil {
	private static String driverName="";
	private static String url="";
	private static String user="";
	private static String pwd="";
	
	//连接数据   单例：针对数据库的交互比较频繁  平常类：按需分配
	static{
		try {
			Properties p=new Properties();
			try {
				p.load(DButil.class.getResourceAsStream("config.properties"));
				driverName=p.getProperty("driver", "oracle.jdbc.OracleDriver");
				url=p.getProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
				user=p.getProperty("userName", "scott");
				pwd=p.getProperty("pwd", "tiger");
			} catch (IOException e) {
				e.printStackTrace();
			}
			//1 加载驱动
			Class.forName(driverName);
			System.out.println("driver is ok!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public DButil(){
		
	}
	
	public Connection getConnection2(){
		Connection con=null;
		try {
			System.out.println("url:"+url);
			System.out.println("user:"+user);
			System.out.println("pwd:"+pwd);
			con=DriverManager.getConnection(url, user, pwd);
			System.out.println("conn db is OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Map<String, String> checkUserInfo(int id,String pwd){
		Map<String, String> hashMap=null;
		String sql="";
		System.out.println(111);
		//statement
		try {
			Statement st = getConnection2().createStatement();
			System.out.println(222);
			sql="select u.id,u.name,u.pwd from scott.users u where u.id="+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				if(rs.getString("pwd").equals(pwd)){
					hashMap=new HashMap<String, String>();
					hashMap.put("username", rs.getString("name"));
				}
			}
			rs.close();
			st.close();
			System.out.println(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	public static void main(String[] args) {
		DButil db=new DButil();
		db.checkUserInfo(1, "1");
	}
}
