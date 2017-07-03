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
		// 1.����һ���������
		BufferedImage image = new BufferedImage(100, 40,
				BufferedImage.TYPE_3BYTE_BGR);
		// 2. ��û���
		Graphics g = image.getGraphics();
		g.setFont(new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 26));
		// 3.�û��ʻ�����
		Random rand = new Random();
		String randNum = "";
		for (int i = 0; i < 4; i++) {
			String str = rand.nextInt(10) + "";// ��������
			randNum += str;// �������ݽ���ƴ��
			g.drawString(str, 20 * i + 9, 22 + i * 4);
		}
		// 4.���õ�ͼƬ����
		g.dispose();
		// 5.���浽�Ự��
		request.getSession().setAttribute("rand", randNum);
		// 6.��ͼƬ��������ʽ���ظ�ǰ��
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
