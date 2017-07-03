package com.mvc.ctroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.bean.User;
import com.mvc.model.service.ILoginService;
import com.mvc.model.service.LoginServiceImp;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.set����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. ��ȡֵ
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//3.�ǿ��ж�
		//���ж�ID�Ƿ�Ϊnull��Ȼ�����ж�equals����    ��ΪidΪnull��ֱ�ӵ���equals�ᱨ��ָ���쳣
		if(id == null || id.equals("") || pwd == null || pwd.equals("")){
			response.sendRedirect("Login.jsp?mesg=id or pwd not null");
			return;
		}
		
		int iId = -1;
		if(id.matches("^[0-9]+$")){
			iId = Integer.parseInt(id);  //���ͻ��˵Ļ�ȡ��idת��Ϊint
		}else{
			response.sendRedirect("Login.jsp?mesg=id is string");
			return;
		}
		
		//4.��ȷ���ж�
		ILoginService loginService = new LoginServiceImp();
		
		User user = loginService.checkUserExist(iId, pwd);
		
		if(user != null){
			request.getRequestDispatcher("welcome.jsp").forward(request, response);  //�ɹ���½��ҳ����ת
		}else{
			response.sendRedirect("Login.jsp?mesg=id or pwd is false");
			return;
		}
	}
}
