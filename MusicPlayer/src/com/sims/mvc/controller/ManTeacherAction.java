package com.sims.mvc.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.ClassServiceImp;
import com.sims.mvc.model.service.IClassService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.StudentServiceImp;

public class ManTeacherAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	private String action = null;
	private String classid = null;
	private String studyid = null;
	private Map<String, Object> request = null;
	private Map<String, Object> session = null;
	private HttpServletResponse response = null;
	
	private String result = null;
	
	public ManTeacherAction() {
		response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
	}

	@Override
	public String execute() throws Exception {
		PrintWriter out = response.getWriter();
		//获取班id
		Student stu=(Student)session.get("stuInfo");
		String classId=stu.getClassID();
		
		//查询所有班级学员信息
		IStudentService stservice=new StudentServiceImp();
		IClassService clas=new ClassServiceImp();
		
		if(action.equals("quealclassstudent")){
			List<Student> list=stservice.findStudentByClassID(classId);
			JSONArray jsonArray = JSONArray.fromObject(list);
			result = jsonArray.toString();
		}
		
//		//查询所有未分班学员信息
//		if(action.equals("quealnotclassstudent")){
//			List<Student> list=stservice.findStudentByClassID("");
//			request.setAttribute("study", list);
//			System.out.println("123343=="+ list);
//			request.getRequestDispatcher("/content/classManger/NotManagerTacher.jsp").forward(request, response);
//		}
//		
//		//任命罢免班长
//		if(action.equals("classmanagee")){
//			String classid=request.getParameter("classid");
//			String studyid=request.getParameter("studyid");
//			CClass ClassById = clas.findClassById(classid);
//			List<Student> list=stservice.findStudentByClassID(classid);
//			for(Student s:list){
//				if(s.getC_monitor()==1){
//					s.setC_monitor(0);
//					stservice.modifyStudent(s);
//				}
//				if(studyid.equals(s.getId())&&s.getC_monitor()!=1){
//						s.setC_monitor(1);
//						stservice.modifyStudent(s);
//						ClassById.setId(classid);
//						ClassById.setMonitorID(studyid);
//						
//						clas.modifyClass(ClassById);
//						request.setAttribute("succ", "任命成功");
//						request.getRequestDispatcher("/content/classManger/ManagerTacher.jsp").forward(request, response);
//				}	
//			}
//		}
//		
//		//添加班级新成员
//		if(action.equals("insertstudents")){
//			String studyid=request.getParameter("studyid");	
//			Student s=stservice.findStudentById(studyid);
//				s.setClassID(classId);
//				stservice.modifyStudent(s);
//				request.getRequestDispatcher("/content/classManger/ManagerTacher.jsp").forward(request, response);
//		}
//		
//		//开除班级学生
//		if(action.equals("deletestudent")){
//			String studyid=request.getParameter("studyid");
//			Student s=stservice.findStudentById(studyid);
//			s.setClassID("");
//			stservice.modifyStudent(s);
//			request.getRequestDispatcher("/content/classManger/ManagerTacher.jsp").forward(request, response);
//		}
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getStudyid() {
		return studyid;
	}

	public void setStudyid(String studyid) {
		this.studyid = studyid;
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
