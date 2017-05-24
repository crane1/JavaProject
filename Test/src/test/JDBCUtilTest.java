package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;


public class JDBCUtilTest {
	Connection conn;
	
	public static Connection getConn(){
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "scott";
		String pwd = "tiger";
		
		
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("1.驱动加载完毕");
			
			//2.获取链接
			conn = DriverManager.getConnection(url, userName, pwd);
			System.out.println("2.已获取数据库链接");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void callProc(int deptno){
		Connection conn = getConn();
		try {
			String sql = "{call sal_operation_pack.addSal(?,?,?)}";
			// 动态会话 PreparedStatement
			CallableStatement cal = conn.prepareCall(sql);
			cal.setInt(1, deptno);
			cal.registerOutParameter(2, OracleTypes.CURSOR);
			cal.registerOutParameter(3, OracleTypes.VARCHAR);
			System.out.println("3.创建语句对象完毕");
			
			cal.execute();
			
			//如果异常为不为空，则打印异常，否则输出结果
			if(cal.getString(3) != null){
				System.out.println("exception:" + cal.getString(3));
			}else{				
				ResultSet result = (ResultSet) cal.getObject(2);
				
				System.out.println("deptno\tdname\tempno\tename\tsal");
				while(result.next()){
					System.out.println(result.getInt(1) + "\t" + result.getString(2) +"\t" + result.getInt(3)
							+ "\t" + result.getString(4) + "\t" + result.getInt(5));
				}
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		callProc(30);  //sql注入
	}
	
}
