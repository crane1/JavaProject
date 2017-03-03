package com.javateam1.technology.snaker;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private final static int FOOD_WIDTH = 20; // 食物最小大小
	private final static int FOOD_LEVEL = 5;  // 最大是蛇体的5倍
	private int x;
	private int y;
	private int width;
	private int size;
	
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
		this.size = (int)(Math.random() * FOOD_LEVEL + 1);
		this.width = this.size * FOOD_WIDTH;
		this.x = (int)(Math.random() * (PlayPanel.PANEL_WIDTH - width));
		this.y = (int)(Math.random() * (PlayPanel.PANEL_HEIGHT - width));
		
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.yellow);//设置画笔颜色  
		int x = this.x;
		int y = this.y;
		int width = this.width;
        g.fillOval(x, y, width, width);//画一个实心圆
//        System.out.println("drawFood:" + x + " " + y + " " + width);
	}
	
	public void flushFood(){
		initFood();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
