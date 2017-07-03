package com.sims.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.bean.Team;
import com.sims.mvc.model.service.ClassServiceImp;
import com.sims.mvc.model.service.IClassService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.ITeamService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.model.service.TeamServiceImp;
import com.sims.mvc.tools.JsonMesg;


public class ClassAction extends ActionSupport implements SessionAware,
ServletRequestAware {
    
	private static final long serialVersionUID = 3218221768282980955L;
	
	HttpServletRequest request=null;
	private static Map<String, Object> session = null;
	private Student stu = null;
	private String classId=null;
	private String id=null;
	private String name=null;
	private String leaderId=null;
	private String page;
	
	private String teamId;
	private String teamName;
	private String result = null;
	IStudentService StudentService = new StudentServiceImp();
	ITeamService teamservce = new TeamServiceImp();
	IClassService  classService=new ClassServiceImp();
	
	
    public ClassAction() {
    	init();
	}
     
    public void init(){
    	session = ServletActionContext.getContext().getSession();
		stu = (Student)session.get("stuInfo");
		System.out.println("stu===="+stu.toString());
		teamId = stu.getTeamID();// ��ȡ��id
		classId = stu.getClassID();// ��ȡ��id
    }
    
//    ��ȡSession
    public static Student getSession() {
		Student stu = (Student) session.get("stuInfo");
		return stu;
	}
    
	//	�༶��Ա��Ϣ��ѯ
	public String checkClassStudent(){
		List<Student> list = StudentService.findStudentByClassID(classId);
		System.out.println("list:"+list);
		System.out.println("checkClassStudent--�༶��Ա��ѯ---classId:"+classId);
		result=JsonMesg.getJsonArray(list);
		System.out.println("checkClassStudent--�༶��Ա��ѯ-result:"+result);
		return SUCCESS;
	}
	
//	�༶��Ϣչʾ
    public String showClass(){
		CClass classInfo = classService.findClassById(classId);
		System.out.println("showClass--�༶��Ϣ�ṹ---classInfo:"+classInfo);
		result=JsonMesg.getJsonArray(classInfo);
		System.out.println("showClass--�༶��Ϣ�ṹ---result:"+result);
		return SUCCESS;
    }
	
    
//    ������
    public String createTeam(){
    	JsonMesg mesg = null;
    	System.out.println("teamName-------------" + teamName);
    	System.out.println("leaderId-------------" + leaderId);
    	
    	if(teamId==null||teamId.equals("")||teamName==null
    	   ||teamName.equals("")||leaderId==null||leaderId.equals("")){
    		System.out.println("teamId"+teamId+"teamName"+teamName+"leaderId"+leaderId);
    		  mesg = new JsonMesg("1");
    		  result = JsonMesg.getJsonObject(mesg);
    		  System.out.println("111111111111111---------------");
    		  return "success";
    	}else{
    	      Team team=new Team(teamId, teamName, leaderId,classId);
    	      StudentService = new StudentServiceImp();
    	      teamservce.addTeam(team);
    	      System.out.println("team:ID"+team.getId()+"team:name"+team.getName()+"team:getLeaderID"+team.getLeaderID()+"team:getClassID"+team.getClassID());
    	      System.out.println("222222222222---------------");
              Student student = StudentService.findStudentById(leaderId);
              
              student.setT_leader(1);  //�����鳤Ȩ��
              student.setTeamID(id);  //������id
              
              int res = StudentService.modifyStudent(student);
              System.out.println("222222222222---------------:"+res);
              if(res > 0){
              	System.out.println(leaderId + "�鳤Ȩ����Ȩ");
              }
              mesg=new JsonMesg("2");
              result=JsonMesg.getJsonObject(mesg); 
    	}
		return SUCCESS;	
    }
    
    
//    ���Ա��Ϣչʾ
    public String showTeamStudent(){
    	JsonMesg mesg = null;
    	
    	if(teamId==null||teamId.equals("")){
			mesg = new JsonMesg("1");
			result = JsonMesg.getJsonObject(mesg);
		    return "success";
    	}else{	
    		List<Student> list = StudentService.findStudentByTeamID(teamId, classId);
    		mesg = new JsonMesg("2");
    		System.out.println("showTeamStudent--���Ա---list:"+list);
    		result=JsonMesg.getJsonArray(list);
    		System.out.println("showTeamStudent--���Ա---result:"+result);
    	}
		return SUCCESS;
    }
    
    
//    ��������Ϣչʾ ͨ���೤��classID
    public String showTeam(){
    	List<Team> list = teamservce.findTeamsByClassID(classId);
    	System.out.println("showTeam--��ṹ--list"+list);
    	result=JsonMesg.getJsonArray(list);
    	System.out.println("showTeam--��ṹ--list"+result);
    	return SUCCESS;
    }
    
    
//    �����鳤
    public String appoinTeamLeader(){
    	System.out.println("----teamId:"+teamId+"----leaderId:"+leaderId);
    	JsonMesg mesg = null;
    	if(teamId==null||teamId.equals("")||leaderId==null||leaderId.equals("")){
    		mesg = new JsonMesg("1");
			result = JsonMesg.getJsonObject(mesg);
		    return "success";	
    	}else{
    		Team team = teamservce.findTeamById(teamId);
    		List<Student> list = StudentService.findStudentByTeamID(teamId, classId);
    		System.out.println("----team:"+team+"----teamId:"+teamId+"----leaderId:"+leaderId);
    		
    		for (Student s : list) {
    			 if(s.getT_leader()==1){
					 s.setT_leader(0);
					 StudentService.modifyStudent(s);
				   }
    			 
    			 System.out.println("list"+list);
    			 if(s.getId().equals(leaderId)&&s.getT_leader()!=1){
    				 s.setT_leader(1);
					 StudentService.modifyStudent(s);
					 team.setLeaderID(leaderId);
					 teamservce.modifyTeam(team);
					 mesg = new JsonMesg("2");
				   }
    			 
			}
    	}
		return SUCCESS;
    }
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
    
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
	    this.request=request;		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}


}