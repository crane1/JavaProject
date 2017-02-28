package com.javateam1.technology.snaker;

public class SnakerBody {
	
	// 蛇体宽高
	public final static int BODY_WIDTH = 20;
	
	// x,y轴坐标，以及朝向
	private int x;
	private int y;
	private Direction dir;
	
	public SnakerBody(){}
	public SnakerBody(int x, int y, Direction dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
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
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public int getBODY_WIDTH() {
		return BODY_WIDTH;
	}
	
	public String toString(){
		return "x=" + x + ",y=" + y + ",dir=" + dir; 
	}
	
}
