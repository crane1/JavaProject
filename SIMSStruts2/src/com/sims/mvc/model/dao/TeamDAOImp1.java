package com.sims.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.mvc.model.bean.Team;
import com.sims.mvc.tools.DBUtil;

public class TeamDAOImp1 implements ITeamDAO {
	private DBUtil dbutil;
	List<Team> list=null;
	Team team=null;
	public TeamDAOImp1(){
		dbutil=dbutil.getInstance();
	}
	@Override
	public Team findTeamById(String id) {		
		String sql="SELECT s.t_id,s.t_name,s.t_leader,s.class_id FROM sims_team s WHERE s.t_id='"+id+"'";
		ResultSet rs = dbutil.query(sql);
		System.out.println(rs);
		 try {
			while(rs.next()){
				team=new Team();
				team.setId(rs.getString("t_id"));
				team.setName(rs.getString("t_name"));
				team.setLeaderID(rs.getString("t_leader"));
				team.setClassID(rs.getString("class_id"));		
//				System.out.println("12"+team.getId()+team.getName()+team.getLeaderID()+team.getClassID());
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		return team;
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

	@Override
	public int addTeam(Team team) {
		String sql="insert into sims_team values('";
			   sql+=team.getId()+"','";
			   sql+=team.getName()+"','";
			   sql+=team.getLeaderID()+"','";
			   sql+=team.getClassID()+"')";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int modifyTeam(Team team) {
		String sql="update SIMS_TEAM t "+
				"set t.t_name = '"+team.getName()+
				"', t.t_leader = '"+team.getLeaderID()+
				"', t.class_id= '"+team.getClassID()+
				"' where t.t_id='"+team.getId() + "'";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public int deleteTeam(String teamID) {
		// TODO Auto-generated method teamb
		return 0;
	}
	@Override
	public List<Team> findTeamsByClassID(String classID) {		
		String sql="SELECT s.t_id,s.t_name,s.t_leader,s.class_id FROM sims_team s WHERE s.class_id='"+classID+"'";
//		System.out.println("findTeamsByClassID---"+sql);
		ResultSet rs = dbutil.query(sql);
		try {
			while(rs.next()){
				team=new Team();
				team.setId(rs.getString("t_id"));				
				team.setName(rs.getString("t_name"));
				team.setLeaderID(rs.getString("t_leader"));
				team.setClassID(rs.getString("class_id"));
				if(rs.isFirst()){				
					list=new ArrayList<Team>();
				}
				list.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
