package com.sims.mvc.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.jdbc.OracleTypes;

import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.tools.DBUtil;
import com.sims.mvc.tools.PageManager;

public class ClassDAOImp implements IClassDAO {
	
	private DBUtil dbutil=null;
	
	//一般分页查询所需要的属性，其他联合查询的属性可以自己拼接，拼接时注意第一个','号，参见
	private final String CONDITION = " c_id,c_name,c_monitor,c_man_teacher,c_teac_teacher ";
		
	public ClassDAOImp(){
	}

	@Override
	public CClass findClassById(String id) {
		//构建sql
		String sql="select " + CONDITION + " from SIMS_CLASS  where c_id='"+id+"'";
		
		System.out.println(sql);
		CClass cc=null;
		ResultSet rs=dbutil.query(sql);
		try {
			if(rs.next()){
				cc = createClass(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cc;
	}

	@Override
	public CClass findClassesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CClass findClassesByMonitorId(String monitorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CClass findClassesByManTeacherId(String manTeacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CClass findClassesByTeacTeacherId(String teacTeacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addClass(CClass cclass) {
		String sql="insert into SIMS_CLASS values('"+cclass.getId()+"','"+cclass.getName()+"','"
					+ (cclass.getMonitorID()==null ? "" : cclass.getMonitorID()) +
				"','"+cclass.getManTeacherID()+"','"+cclass.getTeacTeacherID()+"')";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int modifyClass(CClass cclass) {
		String sql="update SIMS_CLASS s "+
				"set s.c_id = '"+cclass.getId()+
				"', s.c_name = '"+cclass.getName()+
				"', s.c_monitor='"+(cclass.getMonitorID()==null?"":cclass.getMonitorID())+
				"', s.c_man_teacher='"+(cclass.getManTeacherID()==null?"":cclass.getManTeacherID())+
				"', s.c_teac_teacher='"+(cclass.getTeacTeacherID()==null?"":cclass.getTeacTeacherID())+
				"' where s.c_id='"+cclass.getId() + "'";
		System.out.println("班级id===="+cclass.getMonitorID());
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int deleteClass(String cclassId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CClass> getClassesAll() {
		List<CClass> list=null;
		
		//需要查询的属性字符串
		String attrStr = CONDITION;
		
		//需要查询的表和条件字符串
		String conditionStr = " SIMS_CLASS ";
		
		
		//需要查询记录条数的id
		String conditionId = " c_id ";
		list = getQueryPage(attrStr, conditionStr, conditionId);
		
		return list;
	}
	
	
	private CClass createClass(ResultSet rs){
		CClass cc = null;
		
		try {
			cc=new CClass(
				rs.getString("c_id"), 
				rs.getString("c_name"), 
				rs.getString("c_monitor"), 
				rs.getString("c_man_teacher"), 
				rs.getString("c_teac_teacher"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cc;
	}
	
	//进行分页查询
	private List<CClass> getQueryPage(String attrStr, String conditionStr, String conditionId){
		List<CClass> list = null;
		
		String sql = "{?= call getSimsPageRows(?,?,?,?,?,?,?)}";
		Connection conn = dbutil.getConn();
		try {
			CallableStatement prepareCall = conn.prepareCall(sql);
			prepareCall.registerOutParameter(1, OracleTypes.CURSOR);
			prepareCall.registerOutParameter(7, OracleTypes.INTEGER);
			prepareCall.registerOutParameter(8, OracleTypes.VARCHAR);
			
			if(!PageManager.initFlag){
				PageManager.PageManagerInit(8, 1);
				PageManager.initFlag = true;
			}
			
			prepareCall.setInt(2, PageManager.getMaxPageRows());   //每页最大行数
			prepareCall.setInt(3, PageManager.getCurPageNo());	//当前查询页
			prepareCall.setString(4, attrStr);   //需要查询的属性字符串
			prepareCall.setString(5, conditionStr);   //需要查询的表和条件字符串
			prepareCall.setString(6, conditionId);   //需要查询记录条数的id
			
			prepareCall.execute();
			
			PageManager.setMaxRowNumber((int)(prepareCall.getObject(7)));
			
			ResultSet rs = (ResultSet)prepareCall.getObject(1);
			CClass cla = null;
			while(rs.next()){
				cla = createClass(rs);
				if(rs.isFirst()){
					list=new ArrayList<CClass>();
				}
				list.add(cla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		List<CClass> list = new ClassDAOImp().getClassesAll();
		System.out.println(list.size());
	}

	public DBUtil getDbutil() {
		return dbutil;
	}

	public void setDbutil(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	@Test
	public void testclassdao(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("ContextApplication.xml");
		System.out.println((ClassDAOImp)ac.getBean("classDAOImp"));
	}
}
