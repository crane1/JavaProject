package com.controll;

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

@WebServlet("/CreateNumServlet")
public class CreateNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateNumServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = img.getGraphics();
		
		g.setFont(new Font("ËÎÌו", Font.ITALIC, 18));
		
		String str = "";
		
		Random random = new Random();
		for(int i = 0; i < 4; i++){
			String num = random.nextInt(10) + "";
			g.drawString(num, 5 + 20 * i, 20);
			str += num;
		}
		
		g.dispose();
		
		request.getSession().setAttribute("randomNum", str);
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

}
