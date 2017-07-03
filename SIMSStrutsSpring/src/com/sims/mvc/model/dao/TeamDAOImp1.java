package com.sims.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.bean.Team;

public class TeamDAOImp1 implements ITeamDAO {
    private JdbcTemplate jt;
	List<Team> list=null;
	Team team=null;
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public Team findTeamById(String id) {		
		String sql="SELECT s.t_id,s.t_name,s.t_leader,s.class_id FROM sims_team s WHERE s.t_id='"+id+"'";
		return jt.query(sql, new ResultSetExtractor<Team>(){
			@Override
			public Team extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(rs!=null){
						return new Team(
						rs.getString("t_id"),
						rs.getString("t_name"),
						rs.getString("t_leader"),
						rs.getString("class_id"));	
				}
				return null;
			}}); 
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ac.getBean("teamDAOImp1", ITeamDAO.class);
		TeamDAOImp1 t=new TeamDAOImp1();
		System.out.println(t.findTeamById("1"));
	}

	@Override
	public List<Team> findTeamsByName(String name) {
		// TODO Auto-generated method teamb
		return null;
	}

	@Override
	public List<Team> findTeamsByLeaderID(String leaderID) {
		// TODO Auto-generated method teamb
		return null;
	}

//	@Override
//	public int addTeam(Team team) {
//		String sql="insert into sims_team values('";
//			   sql+=team.getId()+"','";
//			   sql+=team.getName()+"','";
//			   sql+=team.getLeaderID()+"','";
//			   sql+=team.getClassID()+"')";
//		return dbutil.executeUpdate(sql);
//	}

//	@Override
//	public int modifyTeam(Team team) {
//		String sql="update SIMS_TEAM t "+
//				"set t.t_name = '"+team.getName()+
//				"', t.t_leader = '"+team.getLeaderID()+
//				"', t.class_id= '"+team.getClassID()+
//				"' where t.t_id='"+team.getId() + "'";
//		return dbutil.executeUpdate(sql);
//	}

	@Override
	public int deleteTeam(String teamID) {
		// TODO Auto-generated method teamb
		return 0;
	}
//	@Override
//	public List<Team> findTeamsByClassID(String classID) {		
//		String sql="SELECT s.t_id,s.t_name,s.t_leader,s.class_id FROM sims_team s WHERE s.class_id='"+classID+"'";
////		System.out.println("findTeamsByClassID---"+sql);
//		ResultSet rs = dbutil.query(sql);
//		try {
//			while(rs.next()){
//				team=new Team();
//				team.setId(rs.getString("t_id"));				
//				team.setName(rs.getString("t_name"));
//				team.setLeaderID(rs.getString("t_leader"));
//				team.setClassID(rs.getString("class_id"));
//				if(rs.isFirst()){				
//					list=new ArrayList<Team>();
//				}
//				list.add(team);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	@Override
//	public List<Student> findStudentByTeam(String classid) {
//		List<Student> list=null;
//		String sql=null;
//		sql="select s.s_id,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_teamid from sims_student s where s.s_team is null and s.s_classid='"+classid+"'";
//		ResultSet rs = dbutil.query(sql);
//		try {
//			while(rs.next()){
//				Student stu=new Student();
//				stu.setId(rs.getString("s_id"));
//				System.out.println(stu.getId());
//				stu.setName(rs.getString("s_name"));
//				stu.setSex(rs.getString("s_sex"));
//				System.out.println(stu.getSex());
//				stu.setAge(rs.getInt("s_age"));
//				stu.setGradFrom(rs.getString("s_gradFrom"));
//				stu.setAddr(rs.getString("s_addr"));
//				stu.setIdCard(rs.getString("s_idcard"));
//				stu.setEmail(rs.getString("s_email"));
//				stu.setTeamID(rs.getString("s_teamid"));
//				if(rs.isFirst()){
//					list=new ArrayList<Student>();
//				}
//				list.add(stu);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
//	@Override
//	public int updateTeam(String teamId, String id) {
//		String sql=null;
//		sql="update sims_student  set s_teamid='"+teamId+"' where s_id='"+id+"'";
//		return dbutil.executeUpdate(sql);
//	}

	@Override
	public List<Team> findTeamsByClassID(String classID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTeam(Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyTeam(Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeam(String teamId, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findStudentByTeam(String classid) {
		// TODO Auto-generated method stub
		return null;
	}

}
