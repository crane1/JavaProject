package work0426.work013_minmaxsal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleTypes;


public class JDBCUtilMinMax {
	Connection conn;
	
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
	
	public static void callFunc(){
		Connection conn = getConn();
		try {
			String sql = "{?= call getdeptInfo(?)}";
			// ��̬�Ự PreparedStatement
			CallableStatement cal = conn.prepareCall(sql);
			cal.registerOutParameter(1, OracleTypes.CURSOR);
			cal.registerOutParameter(2, OracleTypes.VARCHAR);
			System.out.println("3.�������������");
			
			cal.execute();
			
			//����쳣Ϊ��Ϊ�գ����ӡ�쳣������������
			if(cal.getString(2) != null){
				System.out.println("exception:" + cal.getString(2));
			}else{				
				ResultSet result = (ResultSet) cal.getObject(1);
				
				System.out.println("empno:\tename:\tjob:\tsal:\tdeptno:");
				while(result.next()){
					System.out.println(result.getInt(1) + "\t" + result.getString(2) +"\t" + result.getString(3)
							+ "\t" + result.getInt(4) + "\t" + result.getInt(5));
				}
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		callFunc();  //sqlע��
	}
	
}
