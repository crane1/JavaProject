package com.sims.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.bean.Team;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.ITeamService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.model.service.TeamServce;
import com.sims.mvc.model.service.TeamServiceImp;
import com.sims.mvc.tools.JsonMesg;
import com.sims.mvc.tools.PageManager;

public class TeamAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = null;
	private static Map<String, Object> session = null;

	String teamid = null;// 获取组id
	String classid = null;// 获取班id
	Student stu = null;
	private String result = null;
	private String page;
	private String teamInfo = null;
	
	IStudentService StudentService = new StudentServiceImp();
	ITeamService teamservce = new TeamServiceImp();
	TeamServce teamService = new TeamServce();
	
	public TeamAction(){
		initData();
	}
	
	private void initData(){
		session = ServletActionContext.getContext().getSession();
		stu = (Student)session.get("stuInfo");
		teamid = stu.getTeamID();// 获取组id
		classid = stu.getClassID();// 获取班id
	}
	
	// 获取session里的值
	public static Student getSession() {
		Student stu = (Student) session.get("stuInfo");
		return stu;
	}

	// 查询本组成员
	public String checkTeamStudent() {
		List<Student> list = StudentService.findStudentByTeamID(teamid,classid);
		PageManager.setFindPage(page);
		result=JsonMesg.getJsonArray(list);
		ITeamService teamservce=new TeamServiceImp();
		Team team = teamservce.findTeamById(teamid);
		teamInfo=JsonMesg.getJsonObject(team);
		return SUCCESS;
	}

	// 删除组成员
	public String DeleteTeamStudent() {
		String id = request.getParameter("id");// 获取学员ID
		if (id != null && !id.equals("")) {
			teamService.updateTeam("", id);
		}
		return SUCCESS;
	}

	// 未分组成员查询

	public String NotTeamCheckStudent() {
		List<Student> list = StudentService.findStudentByTeamID("",classid);
		if(list!=null&&!list.equals("")){
		PageManager.setFindPage(page);
		result=JsonMesg.getJsonArray(list);
		}
		return SUCCESS;
	}

	// 添加组员

	public String AddTeamStudent() {
		String s_id = request.getParameter("s_id");
		teamService.updateTeam(teamid, s_id);
		List<Student> list = StudentService.findStudentByTeamID(teamid,classid);
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}

    
}
