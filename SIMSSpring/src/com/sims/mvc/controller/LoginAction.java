package com.sims.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.LoginDAOImp;
import com.sims.mvc.model.service.ILoginService;
import com.sims.mvc.model.service.LoginServiceImp;
import com.sims.mvc.tools.AllObject;
import com.sims.mvc.tools.JsonMesg;

public class LoginAction extends ActionSupport implements RequestAware, SessionAware{
	private static final long serialVersionUID = 1L;
	private String userId = null;
	private String pwd = null;
	private String permissions = null;
	private String randNum = null;  
	private String result = null;
	
	private Student stuInfo = null;
	private Map<String, Object> request;
	private Map<String, Object> session;
	HttpServletResponse response = null;
	
	
	public LoginAction() {
		response = ServletActionContext.getResponse();
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String login() throws Exception{
		JsonMesg mesg = null;
		String getRandNum = (String)session.get("rand");
		if (userId == null || pwd == null || userId.equals("")
				|| pwd.equals("") || permissions == null
				|| permissions.equals("")) {
			mesg = new JsonMesg("1");
			result = JsonMesg.getJsonObject(mesg);
			return "success";
		} else {
			ILoginService iLoginService = AllObject.getLoginService();
			stuInfo = iLoginService.checkStuInfo(userId, pwd);
			if (stuInfo == null) {
				mesg = new JsonMesg("2");
				result = JsonMesg.getJsonObject(mesg);
				return "success";
			} else {
				String permi = LoginDAOImp.checkPermi(permissions, userId);
				
				//验证权限
				if (permi.equals("fail")) {
					
					mesg = new JsonMesg("3");
					result = JsonMesg.getJsonObject(mesg);
					return "success";
				}
				
				//验证码验证
				if (!randNum.equals(getRandNum)) {
					
					mesg = new JsonMesg("4");
					result = JsonMesg.getJsonObject(mesg);
					return "success";
				}
				
				// 把stuInfo放到session
				session.put("stuInfo", stuInfo);

				if (stuInfo.getId().equals("admin")) {
					permissions = "admin";
				}
				
				mesg = new JsonMesg("5");
				result = JsonMesg.getJsonObject(mesg);
				session.put("user_right", permissions);
				
				System.out.println("-------------------------login5 result:" + result);
				return SUCCESS;
			}
		}
		
	}
	
	public String regist(){
		
		return null;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Student getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(Student stuInfo) {
		this.stuInfo = stuInfo;
	}

	public String getRandNum() {
		return randNum;
	}

	public void setRandNum(String randNum) {
		this.randNum = randNum;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
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
	
	
}
