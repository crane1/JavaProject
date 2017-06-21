package com.sims.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.CClass;
import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.ClassServiceImp;
import com.sims.mvc.model.service.IClassService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/AdminClassServlet")
public class AdminClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminClassServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String action=request.getParameter("action");
			//通过班号查询
			if(action.equals("classByID")){
				String classID=request.getParameter("classID");
				System.out.println(classID);
				if(classID==null||classID.equals("")){
					request.setAttribute("classMes", "班级号不能为空！");
				}else{
					IClassService is=new ClassServiceImp();
					CClass findClass = is.findClassById(classID);
					List<CClass> classAll = new ArrayList<CClass>();
					
					if(findClass != null){
						classAll.add(findClass);
						request.setAttribute("clAll", classAll);
					}else{
						request.setAttribute("classMes", "查无此班！");
					}
				}
				request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
			}
				
			//查询所有班级
			if(action.equals("classAll")){
				IClassService ic=new ClassServiceImp();
				List<CClass> classAll = ic.getClassesAll();
				if(classAll == null){
					request.setAttribute("classMes", "没有班级，请创建！");
				}else{
					request.setAttribute("clAll", classAll);
				}
				request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
			}
			//新建班级
			if(action.equals("addClass")){
				String id=request.getParameter("id");
				String name=request.getParameter("name");
				String manTeacherID=request.getParameter("manTeacherID");
				String teacTeacherID=request.getParameter("teacTeacherID");
				
				if(id==null || id.equals("")||
					name==null || name.equals("")||
					manTeacherID==null || manTeacherID.equals("")||
					teacTeacherID==null || teacTeacherID.equals("")){
					request.setAttribute("addClMeg", "请填写所有项");
					request.getRequestDispatcher("/content/admin/CreateClass.jsp").forward(request, response);
				}else{
					IClassService ic=new ClassServiceImp();
					
					CClass cur_class = ic.findClassById(id);  //查看是否已有，其实可以做成ajax
					
					if(cur_class != null){
						request.setAttribute("addClMeg", "当前班级已经存在");
						request.getRequestDispatcher("/content/admin/CreateClass.jsp").forward(request, response);
						return;
					}else{
						CClass cc=new CClass(id, name, null, manTeacherID, teacTeacherID);
						int addClass = ic.addClass(cc);
						if(addClass>0){
							IStudentService stuService = new StudentServiceImp();
							Student manTeach = stuService.findStudentById(manTeacherID);
							manTeach.setClassID(id);
							manTeach.setC_man_teacher(1);
							stuService.modifyStudent(manTeach);
							Student techTeach = stuService.findStudentById(teacTeacherID);
							techTeach.setClassID(id);
							techTeach.setC_teac_teacher(1);
							stuService.modifyStudent(techTeach);
							
							request.setAttribute("addClMeg", "新建成功！");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}
					}
				}
			}
								
			
			//根据班级ID查询
			if(action.equals("cheClByClID")){
				String clID=request.getParameter("clID");
				if(clID.equals("")||clID==null){
					request.setAttribute("cheByIDMeg", "ID不能为空！");
					request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
				}else{
					IStudentService ist=new StudentServiceImp();
					List<Student> findStudentByClassID = ist.findStudentByClassID(clID);
					System.out.println(findStudentByClassID.size());
					request.setAttribute("findStudentByClassID", findStudentByClassID);
					request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
				}
			}
			
			//任命班主任/任课老师
			if(action.equals("appClLeader")){
				String clID=request.getParameter("clID");//班级ID
				String clLeader=request.getParameter("clLeader");//班主任ID
				int modifyNew =0;
			
				if(clID==null||clID.equals("")||clLeader==null||clLeader.equals("")){
					request.setAttribute("addLedMsg", "班级ID或班主任ID不能为空！");
					request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
				}else{
					IClassService ic=new ClassServiceImp();
					
					CClass findClassById = ic.findClassById(clID);  //根据传入的班级id获取班级
					String oldManTea = findClassById.getManTeacherID();//获取当前班班主任id
					
					IStudentService is=new StudentServiceImp();
					Student oldManTeacher = is.findStudentById(oldManTea);  //通过班主任id拿到班主任对象
					
					
					List<Student> classStudents = is.findStudentByClassID(clID);  // 获取本班学生集合
					
					if(classStudents != null){
						for(Student s:classStudents){
							//如果输入的班主任id是本班学生id
							if(s.getC_man_teacher()==0&&s.getId().equals(clLeader)){  
								
								//更新本班班主任id
								findClassById.setManTeacherID(clLeader);  
								int modifyClass = ic.modifyClass(findClassById);
								
								//如果更新成功，则设置此人权限
								if(modifyClass>0){
									if(oldManTeacher!=null){  //如果当前班原有班主任，则取消其权限
										oldManTeacher.setC_man_teacher(0);
										is.modifyStudent(oldManTeacher);
									}
									
									s.setC_man_teacher(1);
									modifyNew = is.modifyStudent(s);
									break;
								}
							}
						}
					}
					
					
					if(modifyNew>0){
						request.setAttribute("addLedMsg", "任命成功！");
						request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
					}else{
						request.setAttribute("addLedMsg", "任命失败！");
						request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
					}
					}
				}
			
			
			//任命任课老师
				if(action.equals("appClTeacher")){
					String clID=request.getParameter("clID");//班级ID
					String clTeacher=request.getParameter("clTeacher");//班主任ID
					int modifyNew =0;
				
					if(clID.equals("")||clID==null||clTeacher.equals("")||clTeacher==null){
						request.setAttribute("addTeaMsg", "班级ID或任课老师ID不能为空！");
						request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
					}else{
						IClassService ic=new ClassServiceImp();
						CClass findClassById = ic.findClassById(clID);
						String oldManTea = findClassById.getManTeacherID();
						
						IStudentService is=new StudentServiceImp();
						Student oldTeaTeacher = is.findStudentById(oldManTea);
						List<Student> findStudentByClassID = is.findStudentByClassID(clID);
						if(oldTeaTeacher!=null){
							oldTeaTeacher.setC_teac_teacher(0);
							is.modifyStudent(oldTeaTeacher);
						}
						for(Student s:findStudentByClassID){
								if(s.getC_man_teacher()==0&&s.getId().equals(clTeacher)){
									findClassById.setTeacTeacherID(clTeacher);
									int modifyClass = ic.modifyClass(findClassById);
									if(modifyClass>0){
										s.setC_teac_teacher(1);
										modifyNew = is.modifyStudent(s);
										System.out.println("modifyNew:"+modifyNew);
									}
								}
							}
						if(modifyNew>0){
							request.setAttribute("addTeaMsg", "任命成功！");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}else{
							request.setAttribute("addTeaMsg", "任命失败！");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}
						}
						
					
				}
			}
		
	}


