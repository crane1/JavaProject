package test;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleTypes;


public class JDBCUtilMinMax {
	static Connection conn;
	
	public static Connection getConn(){
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "scott";
		String pwd = "tiger";
		
		
		try {
			//1.��������
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("1.�����������");
			
			//2.��ȡ����
			conn = DriverManager.getConnection(url, userName, pwd);
			System.out.println("2.�ѻ�ȡ���ݿ�����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int update(String sql){
		conn = getConn();
		int result = -1;
		try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void callProc(int deptno){
		Connection conn = getConn();
		try {
			String sql = "{call sal_operation_pack.addSal(?,?,?)}";
			// ��̬�Ự PreparedStatement
			CallableStatement cal = conn.prepareCall(sql);
			cal.setInt(1, deptno);
			cal.registerOutParameter(2, OracleTypes.CURSOR);
			cal.registerOutParameter(3, OracleTypes.VARCHAR);
			System.out.println("3.�������������");
			
			cal.execute();
			                                                              
			//����쳣Ϊ��Ϊ�գ����ӡ�쳣������������
			if(cal.getString(3) != null){
				System.out.println("exception:" + cal.getString(3));
			}else{				
				ResultSet result = (ResultSet) cal.getObject(2);
				
				System.out.println("deptno\tdname\tempno\tename\tsal");
				while(result.next()){
					System.out.println(result.getInt(1) + "\t" + result.getString(2) +"\t" + result.getInt(3)
							+ "\t" + result.getString(4) + "\t" + result.getInt(5));
					String sqlUpdate = "update emp set sal="+result.getInt(5) + " where empno=" + result.getInt(3);
					update(sqlUpdate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		callProc(20);  //sqlע��
	}
	
}
