package com.sims.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.LoginDAOImp;
import com.sims.mvc.model.service.ILoginService;
import com.sims.mvc.model.service.LoginServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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

		String userId = null;
		String pwd = null;
		String permissions = null;
		Student stuInfo = null;
		String randNum = null;
		userId = request.getParameter("userId");
		pwd = request.getParameter("pwd");
		permissions = request.getParameter("permissions");
		System.out.println("permissions=====" + permissions);
		randNum = request.getParameter("randNum");
		Object getRandNum = request.getSession().getAttribute("rand");

		if (userId == null || pwd == null || userId.equals("")
				|| pwd.equals("") || permissions == null
				|| permissions.equals("")) {
			request.setAttribute("loginErr", "�û����������Ȩ�޲���Ϊ�գ�");
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);
			return;
		} else {
			ILoginService iLoginService = new LoginServiceImp();
			stuInfo = iLoginService.checkStuInfo(userId, pwd);

			if (stuInfo == null) {
				request.setAttribute("loginErr", "�û�����������󣡣�");
				request.getRequestDispatcher("Login.jsp").forward(request,
						response);
			} else {
				String permi = LoginDAOImp.checkPermi(permissions, userId);
				if (permi.equals("fail")) {
					request.setAttribute("loginErr", "Ȩ�޲���");
					request.getRequestDispatcher("Login.jsp").forward(request,
							response);
					return;
				}
				if (!randNum.equals(getRandNum)) {
					request.setAttribute("loginErr", "��֤�벻ƥ��");
					request.getRequestDispatcher("Login.jsp").forward(request,
							response);
					return;
				}
				// ��stuInfo�ŵ�session
				request.getSession().setAttribute("stuInfo", stuInfo);
				System.out.println("permissions:" + permissions);

				if (stuInfo.getId().equals("admin")) {
					permissions = "admin";
				}
				request.getSession().setAttribute("user_right", permissions);

				// ��ת��ѧ����Ϣչʾҳ��
				request.getRequestDispatcher("/content/student/showStuInfo.jsp")
						.forward(request, response);
			}
		}

	}
}
