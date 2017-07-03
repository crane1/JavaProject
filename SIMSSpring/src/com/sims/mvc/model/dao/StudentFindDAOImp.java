package com.sims.mvc.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.jdbc.OracleTypes;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;
import com.sims.mvc.tools.PageManager;

public class StudentFindDAOImp implements IStudentFindDAO {
	private DBUtil dbutil;

	// 查询出过pwd(密码)的所有属性
	private final String SQL = "select s.s_id,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,"
			+ "s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_teamid,s.s_classid,s.isleader,"
			+ "s.ismonitor,s.ismanteach,s.isteacteach,s.isnormadmin from sims_student s ";

	// 一般分页查询所需要的属性，其他联合查询的属性可以自己拼接，拼接时注意第一个','号，参见findStudentByTeamID
	private final String CONDITION = " s_id,s_pwd,s_name,s_sex,s_age,s_gradfrom,"
			+ "s_tel,s_addr,s_idcard,s_email,s_teamid,s_classid,isleader,"
			+ "ismonitor,ismanteach,isteacteach,isnormadmin ";

	public StudentFindDAOImp() {
	}

	public String createSqlByString(String condition) {
		return SQL + condition;
	}

	@Override
	public Student findStudentById(String id) {
		String condition = " where s.s_id='" + id + "'";

		String sql = createSqlByString(condition);

		Student stu = null;
		ResultSet rs = dbutil.query(sql);
		try {
			if (rs.next()) {
				stu = createStudent(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentBySex(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByAgeRange(int startAge, int endAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByGradFrom(String gradFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByTelphone(int telephone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByIDCard(String idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByTeamID(String teamId, String classid) {
		List<Student> list = null;

		// 需要查询的属性字符串
		String attrStr = CONDITION + ",t_name ";

		// 需要查询的表和条件字符串
		String conditionStr = null;
		if (teamId == null || teamId.equals("")) {
			attrStr = CONDITION;
			conditionStr = " sims_student s where s.s_teamid is null and s.s_classid='"
					+ classid + "'";
		} else {
			conditionStr = " sims_student s,sims_team t where t.t_id = s.s_teamid and t.t_id='"
					+ teamId + "'";
		}

		// 需要查询记录条数的id
		String conditionId = "s_id";
		list = getQueryPage(attrStr, conditionStr, conditionId);

		return list;
	}

	@Override
	public List<Student> findStudentByClassID(String classId) {
		List<Student> list = null;

		// 需要查询的属性字符串
		String attrStr = CONDITION + ",c_name ";

		// 需要查询的表和条件字符串
		String conditionStr = null;
		if (classId == null || classId.equals("")) {
			attrStr = CONDITION;
			conditionStr = " sims_student where s_classid is null";
		} else {
			conditionStr = " sims_student s,sims_class c where c.c_id = s.s_classid and c.c_id='"
					+ classId + "'";
		}

		// 需要查询记录条数的id
		String conditionId = "s_id";
		list = getQueryPage(attrStr, conditionStr, conditionId);

		return list;
	}

	@Override
	public List<Student> findStudentByCondition(String id, String name,
			String sex, int startAge, int endAge, String gradFrom,
			int telephone, String address, String idCard, String email,
			String teamId, String classId) {

		return null;
	}

	@Override
	public List<Student> findStudentAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByIsAdmin() {
		List<Student> list = null;

		// 需要查询的属性字符串
		String attrStr = CONDITION;

		// 需要查询的表和条件字符串
		String conditionStr = " sims_student s WHERE s.isnormadmin=1 ";

		// 需要查询记录条数的id
		String conditionId = "s_id";
		list = getQueryPage(attrStr, conditionStr, conditionId);

		return list;
	}

	private Student createStudent(ResultSet rs) {
		Student stu = new Student();

		try {
			stu.setId(rs.getString("s_id"));
			stu.setName(rs.getString("s_name"));
			stu.setSex(rs.getString("s_sex"));
			stu.setAge(rs.getInt("s_age"));
			stu.setGradFrom(rs.getString("s_gradFrom"));
			stu.setTel(rs.getLong("s_tel"));
			stu.setAddr(rs.getString("s_addr"));
			stu.setIdCard(rs.getString("s_idcard"));
			stu.setEmail(rs.getString("s_email"));
			stu.setTeamID(rs.getString("s_teamid"));
			stu.setClassID(rs.getString("s_classid"));
			stu.setT_leader(rs.getInt("isleader"));
			stu.setC_monitor(rs.getInt("ismonitor"));
			stu.setC_man_teacher(rs.getInt("ismanteach"));
			stu.setC_teac_teacher(rs.getInt("isteacteach"));
			stu.setNormal_manager(rs.getInt("isnormadmin"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stu;
	}

	// 进行分页查询
	private List<Student> getQueryPage(String attrStr, String conditionStr,
			String conditionId) {
		List<Student> list = null;

		String sql = "{?= call getSimsPageRows(?,?,?,?,?,?,?)}";
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

			PageManager.setMaxRowNumber((int) (prepareCall.getObject(7)));

			ResultSet rs = (ResultSet) prepareCall.getObject(1);
			Student stu = null;
			while (rs.next()) {
				stu = createStudent(rs);
				if (rs.isFirst()) {
					list = new ArrayList<Student>();
				}
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	

	public DBUtil getDbutil() {
		return dbutil;
	}

	public void setDbutil(DBUtil dbutil) {
		this.dbutil = dbutil;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ContextApplication.xml");
		IStudentFindDAO stufind = (IStudentFindDAO) ac.getBean("studentFindDAOImp");
		List<Student> list = stufind.findStudentByClassID("1");
		System.out.println(list);
	}
}
