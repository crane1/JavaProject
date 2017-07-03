package com.sims.mvc.model.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sims.mvc.model.bean.Team;
import com.sims.mvc.model.dao.ITeamDAO;
import com.sims.mvc.model.dao.TeamDAOImp1;

public class TeamServiceImp implements ITeamService {
    private ITeamDAO iteamdao;
    
	public TeamServiceImp() {
	}

	@Override
	public Team findTeamById(String id) {
		return iteamdao.findTeamById(id);
	}

	@Override
	public List<Team> findTeamsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> findTeamsByLeaderID(String leaderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTeam(Team team) {		
		return iteamdao.addTeam(team);
	}

	@Override
	public int modifyTeam(Team team) {
		// TODO Auto-generated method stub
		return iteamdao.modifyTeam(team);
	}

	@Override
	public int deleteTeam(String teamID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Team> findTeamsByClassID(String classID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ITeamDAO getIteamdao() {
		return iteamdao;
	}

	public void setIteamdao(ITeamDAO iteamdao) {
		this.iteamdao = iteamdao;
	}

	@Test
	public void testContext() {
		ClassPathXmlApplicationContext ac =
				new ClassPathXmlApplicationContext("ContextApplication.xml");
		System.out.println(ac.getBean("teamServiceImp"));
		
	}
}
