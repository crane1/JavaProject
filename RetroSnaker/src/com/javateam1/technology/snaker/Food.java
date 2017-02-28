package com.javateam1.technology.snaker;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private final static int FOOD_WIDTH = 20; // ʳ����С��С
	private final static int FOOD_LEVEL = 5;  // ����������5��
	private int x;
	private int y;
	private int width;
	
	public Food(){
		initFood();
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	private void initFood(){
		this.x = (int)(Math.random() * RetroSnaker.PANEL_WIDTH);
		this.y = (int)(Math.random() * RetroSnaker.PANEL_HEIGHT);
		this.width = (int)((Math.random() * FOOD_LEVEL + 1) * FOOD_WIDTH);
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.yellow);//���û�����ɫ  
		int x = this.x;
		int y = this.y;
		int width = this.width;
        g.fillOval(x, y, width, width);//��һ��ʵ��Բ
        System.out.println("drawFood:" + x + " " + y + " " + width);
	}
	
	public void flushFood(){
		initFood();
	}
	
	
}
