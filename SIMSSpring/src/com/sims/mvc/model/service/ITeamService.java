package com.sims.mvc.model.service;

import java.util.List;

import com.sims.mvc.model.bean.Team;

public interface ITeamService {
	//ͨ��id��ѯ��
	Team findTeamById(String id);
	
	//ͨ��������ѯ��
	List<Team> findTeamsByName(String name);
	
	//ͨ���鳤id��ѯ��
	List<Team> findTeamsByLeaderID(String leaderID);
	
	//ͨ���༶id��ѯ��
	List<Team> findTeamsByClassID(String classID);
	
	//�����
	int addTeam(Team team);
	
	//�޸���
	int modifyTeam(Team team);
	
	//ɾ����
	int deleteTeam(String teamID);
	
}
