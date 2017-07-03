package com.sims.mvc.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sims.mvc.model.service.IClassService;
import com.sims.mvc.model.service.ILoginService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.ITeamService;

public class AllObject {
	private static ApplicationContext ac = null;
	static{
		ac = new ClassPathXmlApplicationContext("ContextApplication.xml");
	}
	public AllObject(){
		
	}
	
	public static IClassService getClassService(){
		return (IClassService)ac.getBean("classServiceImp");
	}
	
	public static ITeamService getTeamService(){
		return (ITeamService)ac.getBean("teamServiceImp");
	}
	
	public static IStudentService getStuService(){
		return (IStudentService)ac.getBean("studentServiceImp");
	}
	
	public static ILoginService getLoginService(){
		return (ILoginService)ac.getBean("loginServiceImp");
	}

}
