package com.sims.mvc.model.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.IStudentFindDAO;
import com.sims.mvc.model.dao.TeamDaoImp;

public class TeamServce{
	private TeamDaoImp stuFind;
	
	public List<Student> findStudentByTeam(String classid) {
		return stuFind.findStudentByTeam(classid);
	}
	public int updateTeam(String teamId,String id){
		return stuFind.updateTeam(teamId,id);
	}
	
	@Test
	public void testContext() {
		ClassPathXmlApplicationContext ac =
				new ClassPathXmlApplicationContext("ContextApplication.xml");
		System.out.println(ac.getBean("teamServce"));
		
	}
	public TeamDaoImp getStuFind() {
		return stuFind;
	}
	public void setStuFind(TeamDaoImp stuFind) {
		this.stuFind = stuFind;
	}
	
}
