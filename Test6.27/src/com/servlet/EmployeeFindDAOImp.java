package com.servlet;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






import oracle.jdbc.OracleTypes;

import com.bean.Employee;
import com.tools.DBUtil;
import com.tools.PageManager;

public class EmployeeFindDAOImp {
	DBUtil dbutil;
	public EmployeeFindDAOImp() {
		dbutil = DBUtil.getInstance();
	}
	
	public List<Employee> findEmployeeByTeamID() {
		List<Employee> list = null;

		// 需要查询的属性字符串
		String attrStr =  " emp_no, name, salary, age ";

		// 需要查询的表和条件字符串
		String conditionStr = " employee ";

		// 需要查询记录条数的id 
		String conditionId = " emp_no ";
		list = getQueryPage(attrStr, conditionStr, conditionId);

		return list;
	}


	// 进行分页查询
	private List<Employee> getQueryPage(String attrStr, String conditionStr,
			String conditionId) {
		List<Employee> list = null;

		String sql = "{?= call getPageRows(?,?,?,?,?,?,?)}";
		Connection conn = dbutil.getConn();

		try {
			CallableStatement prepareCall = conn.prepareCall(sql);
			prepareCall.registerOutParameter(1, OracleTypes.CURSOR);
			prepareCall.registerOutParameter(7, OracleTypes.INTEGER);
			prepareCall.registerOutParameter(8, OracleTypes.VARCHAR);

			if (!PageManager.initFlag) {
				PageManager.PageManagerInit(8, 1);
				PageManager.initFlag = true;
			}

			prepareCall.setInt(2, PageManager.getMaxPageRows()); // 每页最大行数
			prepareCall.setInt(3, PageManager.getCurPageNo()); // 当前查询页
			prepareCall.setString(4, attrStr); // 需要查询的属性字符串
			prepareCall.setString(5, conditionStr); // 需要查询的表和条件字符串
			prepareCall.setString(6, conditionId); // 需要查询记录条数的id

			prepareCall.execute();
			java.sql.Statement createStatement = conn.createStatement();

			PageManager.setMaxRowNumber((int) (prepareCall.getObject(7)));

			ResultSet rs = (ResultSet) prepareCall.getObject(1);
			Employee emp = null;
			while (rs.next()) {
				if (rs.isFirst()) {
					list = new ArrayList<Employee>();
				}
				emp = createEmployee(rs);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	


	private Employee createEmployee(ResultSet rs) {
		Employee emp = null;
		try {
			emp = new Employee(rs.getInt("emp_no"), 
				rs.getString("name"), 
				rs.getDouble("salary"), 
				rs.getInt("age"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public static void main(String[] args) {
	}
}
