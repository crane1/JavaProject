package com.sims.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.bean.Team;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.ITeamService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.model.service.TeamServce;
import com.sims.mvc.model.service.TeamServiceImp;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/teamServlet")
public class teamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teamServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String path = request.getContextPath();

		Student stu = (Student) request.getSession().getAttribute("stuInfo");

		System.out.println("stu========" + stu);
		String action = request.getParameter("action");// 获取请求的action属性值
		String teamId = stu.getTeamID();// 获取组ID
		String classid=stu.getClassID();
		System.out.println("stu========" + teamId);
		
		// 查询本组的所有成员
		IStudentService StudentService = new StudentServiceImp();
		 ITeamService  teamservce=new TeamServiceImp();
		 
		if (action.equals("teamqurle")) {
			Team team=teamservce.findTeamById(teamId);
			request.setAttribute("team", team);
			List<Student> list = StudentService.findStudentByTeamID(teamId);
			request.setAttribute("teams", list);
			request.getRequestDispatcher("/content/teamLeader/Group.jsp").forward(request, response);
		}

		// 刪除组成员
		if (action.equals("teamdelete")) {
			String id = request.getParameter("id");// 获取学员ID
			if (id != null && !id.equals("")) {
				TeamServce teamService = new TeamServce();
				teamService.updateTeam("", id);
			}

			// 修改后跳转到查询页面
			List<Student> list = StudentService.findStudentByTeamID(teamId);
			request.setAttribute("teams", list);
			request.getRequestDispatcher("/content/teamLeader/Group.jsp")
					.forward(request, response);
		}

		// 未分组成员查询
		if (action.equals("teamselect")) {
			TeamServce teamService = new TeamServce();
			List<Student> list = teamService.findStudentByTeam(classid);
			request.setAttribute("team", list);
			request.getRequestDispatcher("/content/teamLeader/studyIM.jsp").forward(request,
					response);
		}

		// 添加组员
		if (action.equals("studentupdate")) {
			String s_id = request.getParameter("s_id");
			TeamServce teamService = new TeamServce();
			teamService.updateTeam(teamId, s_id);
			List<Student> list = StudentService.findStudentByTeamID(teamId);
			request.setAttribute("teams", list);
			response.sendRedirect(path + "/content/teamLeader/Group.jsp");
		}

	}
}
