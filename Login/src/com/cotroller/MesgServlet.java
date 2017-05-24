package com.cotroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Message;
import com.model.UserInfo;

/**
 * Servlet implementation class MesgServlet
 */
@WebServlet("/MesgServlet")
public class MesgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MesgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("追加留言开始----------------");
		String mesgStr = request.getParameter("guest_mes");
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		
		Message mesg = new Message(user.getId(), user.getName(), mesgStr, dateString);
		
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		List<Message> mesgs = (List<Message>)context.getAttribute("Message");
		
		if(mesgs == null){
			mesgs = new ArrayList<Message>();
		}
		
		mesgs.add(mesg);
		context.setAttribute("Message", mesgs);
		System.out.println("留言size----------------" + mesgs.size());
		System.out.println("追加留言结束----------------");
		response.sendRedirect("MessageBoard.jsp");
		session.setAttribute("succ_mes", "留言成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
