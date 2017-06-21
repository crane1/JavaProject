package com.sims.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.bean.Team;
import com.sims.mvc.model.service.ClassServiceImp;
import com.sims.mvc.model.service.IClassService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.ITeamService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.model.service.TeamServiceImp;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		IStudentService StudentService=null;		
		ITeamService teamServiceImp=null;
		IClassService ClassService=null;
		Team team=null;
		String path = request.getContextPath();
		Student stus=(Student)request.getSession().getAttribute("stuInfo");
		System.out.println("stus-----"+stus);
		String classid =stus.getClassID();
		String action = request.getParameter("action");
	    System.out.println("action===="+action);
//		查询班级成员信息
		if (action.equals("classStuQuery")) {
//			System.out.println("classStuQuery===2===classid:"+classid);
//			if(classid==null||classid.equals("")){
//				request.setAttribute("Err", "班级编号不能为空");
////				request.getRequestDispatcher("/content/classMonit/classMoniter.jsp").forward(request,
////						response);
//			}else{			
			 StudentService = new StudentServiceImp();
			System.out.println("classid============" + classid);
			ClassService=new ClassServiceImp();
			List<Student> findStudentByClassID = StudentService.findStudentByClassID(classid);
			request.setAttribute("clas", findStudentByClassID);
//			System.out.println("已接收到回馈信息");
//			System.out.println("-----------"+findStudentByClassID);	
//			System.out.println("已接收到回馈信息1:"+findStudentByClassID.get(1));
//		       }	
		
			request.getRequestDispatcher("/content/classMonit/classStuInfo.jsp").forward(request,
					response);
		}
	
//		查询班信息
		if (action.equals("classQuery")) {
			
//			System.out.println("classQuery===1===classid:"+classid);
//			if(classid==null||classid.equals("")){
//				request.setAttribute("Err", "班级编号不能为空");
////				request.getRequestDispatcher("/content/classMonit/classMoniter.jsp").forward(request,
////						response);
//			}else{
			System.out.println("classid============" + classid);
			ClassService=new ClassServiceImp();
			CClass findClassById = ClassService.findClassById(classid);
			request.setAttribute("classs", findClassById);
			System.out.println("-----------"+findClassById);
			
//		       }		
			request.getRequestDispatcher("/content/classMonit/classMoniter.jsp").forward(request,
					response);
		}
//		创建组
		
		if (action.equals("caeateTeams")) {           
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String monitorid=request.getParameter("monitorid");
            String classsid=request.getParameter("classsid");
            if(id==null||id.equals("")||name==null||name.equals("")||monitorid==null||monitorid.equals("")||classsid==null||classsid.equals("")){
				request.setAttribute("Err", "组id,name,monitorid或者classID不能为空");
//				request.getRequestDispatcher("/content/classMonit/classMoniter.jsp").forward(request,
//						response);
			}else{
//            System.out.println("----"+id+name+monitorid+classsid);
            team=new Team(id, name, monitorid,classsid);
            teamServiceImp = new TeamServiceImp();
            teamServiceImp.addTeam(team);  //在数据库中添加组信息
            
            
            StudentService = new StudentServiceImp();
            Student findStudentById = StudentService.findStudentById(monitorid);
            
            findStudentById.setT_leader(1);  //设置组长权限
            findStudentById.setTeamID(id);  //设置组id
            
            int res = StudentService.modifyStudent(findStudentById);
            
            if(res > 0){
            	System.out.println(monitorid + "组长权限授权");
            }
            
            out.write("创建成功");
		}
            request.getRequestDispatcher("/content/classMonit/checkTeamStudent.jsp").forward(request, response);   
		}
//		查看组信息
		
		if(action.equals("checkTeamStudent")){			
         String teamid=request.getParameter("teamid");
         if(teamid==null||teamid.equals("")){
        	 request.setAttribute("Err", "组id不能为空");
//				request.getRequestDispatcher("/content/classMonit/classMoniter.jsp").forward(request,
//						response);
         }else{
         StudentService = new StudentServiceImp();
         teamServiceImp = new TeamServiceImp();
//         System.out.println("--teamid--"+teamid);
         
         Team findTeamById = teamServiceImp.findTeamById(teamid);
         
         List<Student> findStudentByTeamID = StudentService.findStudentByTeamID(teamid);
         request.setAttribute("team",findTeamById );
         request.setAttribute("teamStudent",findStudentByTeamID );
          // System.out.println("---"+findTeamById.getId()+findTeamById.getName()+findTeamById.getLeaderID()+findTeamById.getClassID());
        
		}
         request.getRequestDispatcher("/content/classMonit/checkTeamStudent.jsp").forward(request, response); 
		  }
         //      任命组长   
         if(action.equals("appteamleader")){
             String teamid=request.getParameter("teamid");  
             String newleaderid=request.getParameter("newleaderid");
           
             if(teamid==null||teamid.equals("")||newleaderid==null||newleaderid.equals("")){
        	   request.setAttribute("Err", "组id或者新组长ID不能为空");
            }else{
             StudentService = new StudentServiceImp();
             teamServiceImp = new TeamServiceImp();
             Team findTeamById = teamServiceImp.findTeamById(teamid);           
            	 List<Student> list = StudentService.findStudentByTeamID(teamid);

	            //撤销组长	
            	 for (Student s:list) {
	//            		原组长 权限修改为0
							 if(s.getT_leader()==1){
								s.setT_leader(0);
								StudentService.modifyStudent(s);
							 }
            		 if(s.getId().equals(newleaderid)&&s.getT_leader()!=1){
            			 s.setT_leader(1);
 						 StudentService.modifyStudent(s);
 						findTeamById.setLeaderID(newleaderid);
 						teamServiceImp.modifyTeam(findTeamById);
 						request.setAttribute("Err", "任命成功");
					   }
						                
         }    
         }
             request.getRequestDispatcher("/content/classMonit/checkTeamStudent.jsp").forward(request, response); 
         }}}

