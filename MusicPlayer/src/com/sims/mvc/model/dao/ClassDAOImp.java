package com.sims.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.tools.DBUtil;

public class ClassDAOImp implements IClassDAO {
	
	DBUtil dbutil=null;
	public ClassDAOImp(){
		dbutil=dbutil.getInstance();
	}

	@Override
	public CClass findClassById(String id) {
		String sql="select s.c_id,s.c_name,s.c_monitor,s.c_man_teacher,s.c_teac_teacher from SIMS_CLASS s where s.c_id='"+id+"'";
		CClass cc=null;
		ResultSet rs=dbutil.query(sql);
		try {
			if(rs.next()){
				cc=new CClass(rs.getString("c_id"), rs.getString("c_name"), rs.getString("c_monitor"), rs.getString("c_man_teacher"), rs.getString("c_teac_teacher"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				"', s.c_monitor='"+cclass.getMonitorID()+
				"', s.c_man_teacher='"+cclass.getManTeacherID()+
				"', s.c_teac_teacher='"+cclass.getTeacTeacherID()+
				"' where s.c_id='"+cclass.getId() + "'";
		System.out.println("°à¼¶id===="+cclass.getMonitorID());
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int deleteClass(String cclassId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CClass> getClassesAll() {
		String sql="select s.c_id,s.c_name,s.c_monitor,s.c_man_teacher,s.c_teac_teacher from SIMS_CLASS s";
		CClass cc=null;
		ResultSet rs=dbutil.query(sql);
		List<CClass> list=null;
		try {
			while(rs.next()){
				if(rs.isFirst()){
					list=new ArrayList<CClass>();
				}
				cc=new CClass();
				cc.setId(rs.getString("c_id"));
				cc.setName(rs.getString("c_name"));
				cc.setMonitorID(rs.getString("c_monitor"));
				cc.setManTeacherID(rs.getString("c_man_teacher"));
				cc.setTeacTeacherID(rs.getString("c_teac_teacher"));
				list.add(cc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return list;
	}

}
