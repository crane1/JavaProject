package com.sims.mvc.controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imgServlet
 */
@WebServlet("/imgServlet")
public class imgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public imgServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 1.定义一个缓存对象
		BufferedImage image = new BufferedImage(100, 40,
				BufferedImage.TYPE_3BYTE_BGR);
		// 2. 获得画笔
		Graphics g = image.getGraphics();
		g.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 26));
		// 3.用画笔画数字
		Random rand = new Random();
		String randNum = "";
		for (int i = 0; i < 4; i++) {
			String str = rand.nextInt(10) + "";// 画的内容
			randNum += str;// 画的内容进行拼接
			g.drawString(str, 20 * i + 9, 22 + i * 4);
		}
		// 4.画好的图片定型
		g.dispose();
		// 5.保存到会话中
		request.getSession().setAttribute("rand", randNum);
		// 6.将图片以流的形式返回给前端
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
