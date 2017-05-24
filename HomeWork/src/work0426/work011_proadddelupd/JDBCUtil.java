package work0426.work011_proadddelupd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JDBCUtil {
	private Scanner sc = new Scanner(System.in);
	private static JDBCUtil util;
	private String driver;
	private String url;
	private String user;
	private String pwd;
	private Connection conn;
	
	private JDBCUtil(){
		InputStream resourceAsStream = this.getClass().getResourceAsStream("config.properties");
		Properties p = new Properties();
		try {
			p.load(resourceAsStream);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JDBCUtil getInstance(){
		if(util == null){
			util = new JDBCUtil();
		}
		return util;
	}
	
	public Connection getConn(){
		if(conn == null){
			try {
				Class.forName(driver);//加载驱动
				conn = DriverManager.getConnection(url,user,pwd); //链接数据库
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
		
	}
	
	public int update(String sql){
		int result = -1;
		try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet query(String sql){
		ResultSet result = null;
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean callProc(String dmlType){
		boolean flag = false;
		try {
			String sql = "{call operateBooks(?)}";
			CallableStatement cal = conn.prepareCall(sql);
			cal.setString(1, dmlType);
			flag = cal.execute();
			System.out.println("flag =" + flag);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// 更新数据
	public void updateBook(String type){
		List<Book> books = new ArrayList<Book>();
		try {
			Book b = null;
			boolean autoCommit = false;
			int result = -1;
			String sql = null;
			String promt = null;
			
			if(type.equals("insert")){
				promt = "添加";
			}else if(type.equals("update")){
				promt = "更新";
			}else if(type.equals("delete")){
				promt = "删除";
			}
			
			conn = getConn();
			//设置自动更新为FALSE
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			
			while(true){
				b = getBookInfo();// 添加和更新数据
				sql = getSql(b);
				System.out.println(sql);
				result = update(sql);
				if(result > 0){
					System.out.println("数据" + promt + "成功");
				}
				
				String isadd = getString("是否继续"+ promt + "('y'or'n')", 0);
				if(isadd.equals("N")||isadd.equals("n")){
					break;
				}
			}
			
			boolean flag = callProc(type);
			System.out.println(flag);
			if(flag){
				System.out.println("数据" + promt + "完成");
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getSql(Book b){
		String sql = "insert into temp_books values('" + b.getBookId() + "','"+ b.getBookName() + "','"
				+ b.getBookAuthor() + "','"+ b.getBookPublish() + "',"
				+ b.getBookTotalNum() + ","+ b.getBookRemainderNum() + ",'"+ b.getBookType() + "')";
		return sql;
	}
	
	public Book getBookInfo(){
		String v_id = getString("请输入id",0);
		String v_name = getString("请输入名字",0);
		String v_author = getString("请输入作者",0);
		int v_totalnum = Integer.valueOf(getString("请输入总量", 1));
		int v_remaindernum = Integer.valueOf(getString("请输入余量",1));
		String v_type = getString("请输入类型",0);
		String v_publish = getString("请输入出版社",0);
		
		Book b = new Book(v_id,v_name,v_author,v_publish,v_totalnum,v_remaindernum,v_type);
		return b;
	}
	
	private String  getString(String promt, int type){
		String s = null;
		while(true){
			System.out.println(promt);
			s = sc.nextLine();
			if(type == 1){
				if(!s.matches("[0-9]+")){
					System.out.println("输入不匹配");
				}else{
					break;
				}
			}else{
				break;
			}
		}
		s = s.trim(); //因为nextLine后面有\n必须剔除掉后面的\n，也就是空白
		return s;
	}
	
	public static void main(String[] args) {
		JDBCUtil util = JDBCUtil.getInstance();
		util.getConn();
		util.updateBook("insert");
	}
}


