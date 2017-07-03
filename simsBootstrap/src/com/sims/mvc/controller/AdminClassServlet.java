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
			//ͨ����Ų�ѯ
			if(action.equals("classByID")){
				String classID=request.getParameter("classID");
				System.out.println(classID);
				if(classID==null||classID.equals("")){
					request.setAttribute("classMes", "�༶�Ų���Ϊ�գ�");
				}else{
					IClassService is=new ClassServiceImp();
					CClass findClass = is.findClassById(classID);
					List<CClass> classAll = new ArrayList<CClass>();
					
					if(findClass != null){
						classAll.add(findClass);
						request.setAttribute("clAll", classAll);
					}else{
						request.setAttribute("classMes", "���޴˰࣡");
					}
				}
				request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
			}
				
			//��ѯ���а༶
			if(action.equals("classAll")){
				IClassService ic=new ClassServiceImp();
				List<CClass> classAll = ic.getClassesAll();
				if(classAll == null){
					request.setAttribute("classMes", "û�а༶���봴����");
				}else{
					request.setAttribute("clAll", classAll);
				}
				request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
			}
			//�½��༶
			if(action.equals("addClass")){
				String id=request.getParameter("id");
				String name=request.getParameter("name");
				String manTeacherID=request.getParameter("manTeacherID");
				String teacTeacherID=request.getParameter("teacTeacherID");
				
				if(id==null || id.equals("")||
					name==null || name.equals("")||
					manTeacherID==null || manTeacherID.equals("")||
					teacTeacherID==null || teacTeacherID.equals("")){
					request.setAttribute("addClMeg", "����д������");
					request.getRequestDispatcher("/content/admin/CreateClass.jsp").forward(request, response);
				}else{
					IClassService ic=new ClassServiceImp();
					
					CClass cur_class = ic.findClassById(id);  //�鿴�Ƿ����У���ʵ��������ajax
					
					if(cur_class != null){
						request.setAttribute("addClMeg", "��ǰ�༶�Ѿ�����");
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
							
							request.setAttribute("addClMeg", "�½��ɹ���");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}
					}
				}
			}
								
			
			//���ݰ༶ID��ѯ
			if(action.equals("cheClByClID")){
				String clID=request.getParameter("clID");
				if(clID.equals("")||clID==null){
					request.setAttribute("cheByIDMeg", "ID����Ϊ�գ�");
					request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
				}else{
					IStudentService ist=new StudentServiceImp();
					List<Student> findStudentByClassID = ist.findStudentByClassID(clID);
					System.out.println(findStudentByClassID.size());
					request.setAttribute("findStudentByClassID", findStudentByClassID);
					request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
				}
			}
			
			//����������/�ο���ʦ
			if(action.equals("appClLeader")){
				String clID=request.getParameter("clID");//�༶ID
				String clLeader=request.getParameter("clLeader");//������ID
				int modifyNew =0;
			
				if(clID==null||clID.equals("")||clLeader==null||clLeader.equals("")){
					request.setAttribute("addLedMsg", "�༶ID�������ID����Ϊ�գ�");
					request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
				}else{
					IClassService ic=new ClassServiceImp();
					
					CClass findClassById = ic.findClassById(clID);  //���ݴ���İ༶id��ȡ�༶
					String oldManTea = findClassById.getManTeacherID();//��ȡ��ǰ�������id
					
					IStudentService is=new StudentServiceImp();
					Student oldManTeacher = is.findStudentById(oldManTea);  //ͨ��������id�õ������ζ���
					
					
					List<Student> classStudents = is.findStudentByClassID(clID);  // ��ȡ����ѧ������
					
					if(classStudents != null){
						for(Student s:classStudents){
							//�������İ�����id�Ǳ���ѧ��id
							if(s.getC_man_teacher()==0&&s.getId().equals(clLeader)){  
								
								//���±��������id
								findClassById.setManTeacherID(clLeader);  
								int modifyClass = ic.modifyClass(findClassById);
								
								//������³ɹ��������ô���Ȩ��
								if(modifyClass>0){
									if(oldManTeacher!=null){  //�����ǰ��ԭ�а����Σ���ȡ����Ȩ��
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
						request.setAttribute("addLedMsg", "�����ɹ���");
						request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
					}else{
						request.setAttribute("addLedMsg", "����ʧ�ܣ�");
						request.getRequestDispatcher("/content/admin/appClassLeader.jsp").forward(request, response);
					}
					}
				}
			
			
			//�����ο���ʦ
				if(action.equals("appClTeacher")){
					String clID=request.getParameter("clID");//�༶ID
					String clTeacher=request.getParameter("clTeacher");//������ID
					int modifyNew =0;
				
					if(clID.equals("")||clID==null||clTeacher.equals("")||clTeacher==null){
						request.setAttribute("addTeaMsg", "�༶ID���ο���ʦID����Ϊ�գ�");
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
							request.setAttribute("addTeaMsg", "�����ɹ���");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}else{
							request.setAttribute("addTeaMsg", "����ʧ�ܣ�");
							request.getRequestDispatcher("/content/admin/Admin.jsp").forward(request, response);
						}
						}
						
					
				}
			}
		
	}


