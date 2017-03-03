package com.javateam1.technology.snaker;

import java.awt.Color;
import java.awt.Graphics;

public class Snaker {
	private final static int SNAKER_WIDTH = 18;
	private SnakerBody[] snaker = new SnakerBody[301];
	private int snakerLength;
	private int deep;
	private int score;
	
	public Snaker(){
		snaker[0] = new SnakerBody(0,0,Direction.RIGHT);
		snakerLength = 1;
		deep = 0;
		setScore(0);
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
	
	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	// 绘制蛇身
	public void drawSnaker(Graphics g){
		for (SnakerBody sb : snaker){
			if (sb == null) {
				break;
			}
			g.setColor(Color.yellow);//设置画笔颜色  
			int x = sb.getX();
			int y = sb.getY();
			int width = SNAKER_WIDTH;
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
		
		if (checkedBorder()){
			System.out.println("触碰边界");
			System.exit(0);
		}
		
		if (checkedEatSelf()){
			System.out.println("吞噬自己");
			System.exit(0);
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
	
	public boolean checkedBorder(){
		SnakerBody head = getHeadPoint();
		int sx = head.getX();
		int sy = head.getY();
		System.out.println("sx=" + sx + "xy=" + sy);
		
		// 检测左和上边界
		if (sx < 0 || sy < 0 || sx > PlayPanel.PANEL_WIDTH || 
				sy > PlayPanel.PANEL_HEIGHT){
			return true;
		}
		
		return false;
	}
	
	public boolean checkedEatSelf(){
		SnakerBody head = snaker[0];
		int sx = head.getX();
		int sy = head.getY();
		
		// 检测是否与自身某个元素同坐标
		for(int i = 1; i < snakerLength; i++){
			SnakerBody body = snaker[i];
			if (body.getX() == sx && 
				body.getY() == sy){
//				System.out.println("day");
//				System.out.println("bx=" + body.getX() +  "by=" + body.getY());
//				System.out.println("sx=" + sx +  "sy=" + sy);
//				printSnaker();
				return true;
			}
		}
		
		return false;
	}
	
	public void turnHead(Direction dir){
//		eatFood();
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
//		printSnaker();
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
	
	public boolean eatFood(Food f){
		SnakerBody shead = getHeadPoint();
		int sX = shead.getX();
		int sY = shead.getY();
		
		int fX = f.getX();
		int fY = f.getY();
		int fw = f.getWidth();
		
		int fsize = f.getSize();
		
		boolean xIsInner = sX >= fX && sX <= fX + fw;
		boolean yIsInner = sY >= fY && sY <= fY + fw;
		
		if(xIsInner && yIsInner){
			for(int i = 0; i < fsize; i++){
				eatFood();
			}
			f.flushFood();
			DeepUp();
			this.score += 2 * fsize;
			return true;
		}
		return false;
	}
	
	public SnakerBody getHeadPoint(){
		SnakerBody sb = new SnakerBody();
		int x = 0;
		int y = 0;
		int halfWidth = (int) (SnakerBody.BODY_WIDTH * 0.5);
		switch(snaker[0].getDir()){
		case UP:
			x = snaker[0].getX() + halfWidth;
			y = snaker[0].getY();
			break;
		case RIGHT:
			x = snaker[0].getX() + halfWidth * 2;
			y = snaker[0].getY() + halfWidth;
			break;
		case DOWN:
			x = snaker[0].getX() + halfWidth;
			y = snaker[0].getY() + halfWidth * 2;
			break;
		case LEFT:
			x = snaker[0].getX();
			y = snaker[0].getY() + halfWidth;
			break;
		}
		sb.setX(x);
		sb.setY(y);
		return sb;
	}
	
	public void DeepUp(){
		if(this.score / 10 > this.deep){
			this.setDeep(this.deep + 1);
		}
	}
	
	public int getSnakerDeep(){
		int current_deep = 1000 - this.deep * 100;
		if (current_deep > 100){
			return current_deep;
		} else {
			return 100;
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
