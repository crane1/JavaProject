package com.javateam1.technology.snaker;

import java.awt.Color;
import java.awt.Graphics;

public class Snaker {
	private SnakerBody[] snaker = new SnakerBody[301];
	private int snakerLength;
	
	public Snaker(){
		snaker[0] = new SnakerBody(0,0,Direction.RIGHT);
		snakerLength = 1;
	}

	public int getSnakerLength() {
		return snakerLength;
	}

	public void setSnakerLength(int snakerLength) {
		this.snakerLength = snakerLength;
	}

	public SnakerBody[] getSnaker() {
		return snaker;
	}

	public void setSnaker(SnakerBody[] snaker) {
		this.snaker = snaker;
	}
	
	// 绘制蛇身
	public void drawSnaker(Graphics g){
		int i = 0;
		for (SnakerBody sb : snaker){
			if (sb == null) {
				break;
			}
//			System.out.println("_________draw");
			g.setColor(Color.yellow);//设置画笔颜色  
			int x = sb.getX();
			int y = sb.getY();
			int width = sb.getBODY_WIDTH();
	        g.fillRect(x, y, width, width);//画一个实心矩形
		}
	}
	
	public void move(){
//		System.out.println("-----move");
		moveBody();
		Direction dir = snaker[0].getDir();
		int diff = 0;
		switch(dir){
		case UP:
			diff = snaker[0].getY() - snaker[0].getBODY_WIDTH();
			snaker[0].setY(diff);
			break;
		case RIGHT:
			diff = snaker[0].getX() + snaker[0].getBODY_WIDTH();
			snaker[0].setX(diff);
			break;
		case DOWN:
			diff = snaker[0].getY() + snaker[0].getBODY_WIDTH();
			snaker[0].setY(diff);
			break;
		case LEFT:
			diff = snaker[0].getX() - snaker[0].getBODY_WIDTH();
			snaker[0].setX(diff);
			break;
		}
	}
	
	public void moveBody(){
//		System.out.println("-----movebody");
		if (snaker.length == 1){
			return;
		}
		for (int i = snakerLength -1; i > 0; i--){
			if (snaker[i] == null){
				break;
			}
			snaker[i].setX(snaker[i-1].getX());
			snaker[i].setY(snaker[i-1].getY());
			snaker[i].setDir(snaker[i-1].getDir());
		}
	}
	
	public void turnHead(Direction dir){
		eatFood();
		Direction snakerDir = snaker[0].getDir();
		switch (dir){
		case UP:
			if (snakerDir == Direction.DOWN) break;
			snaker[0].setDir(Direction.UP);
			break;
		case RIGHT:
			if (snakerDir == Direction.LEFT) break;
			snaker[0].setDir(Direction.RIGHT);
			break;
		case DOWN:
			if (snakerDir == Direction.UP) break;
			snaker[0].setDir(Direction.DOWN);
			break;
		case LEFT:
			if (snakerDir == Direction.RIGHT) break;
			snaker[0].setDir(Direction.LEFT);
			break;
		}
		printSnaker();
	}
	
	public void eatFood(){
//		System.out.println("len:" + snakerLength + ",ary: " + snaker.length);
		if (snakerLength < snaker.length){
			SnakerBody forward = snaker[snakerLength - 1];
			System.out.println(forward);
			int x = forward.getX();
			int y = forward.getY();
			Direction dir = forward.getDir();
			SnakerBody sb = new SnakerBody(x, y, dir);
			snaker[snakerLength] = sb;
			snakerLength++;
		}
	}
	
	public void printSnaker(){
		System.out.println();
		for(SnakerBody sb : snaker){
			if (sb == null) break;
			System.out.println(sb);
		}
	}
}
