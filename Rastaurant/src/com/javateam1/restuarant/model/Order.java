package com.javateam1.restuarant.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Order {
	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static int counter = 1;
	private int number;
	private Food[] foods;
	private Date time;
	private double sumMoney;
	private boolean isPay;
	private boolean isDelete;
	
	public Order(){
		number = counter++;
		isPay = false;
		sumMoney = 0;
		setDelete(true);
		time = new Date(); 
	}
	public Order(Food[] food){
		number = counter++;
		this.foods = food;
		isPay = false;
		sumMoney = 0;
		setDelete(true);
		time = new Date();
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Food[] getFoods() {
		return foods;
	}
	public void setFoods(Food[] foods) {
		this.foods = foods;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	public boolean isPay() {
		return isPay;
	}
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}
	
	public void calSumMoney(){
		double sum = 0;
		if (foods == null){
			this.sumMoney = 0;
		} else {
			for(Food f : foods){
				if (f == null){
					break;
				}
				sum += f.getPrice();
			}
		}
		this.sumMoney = sum;
	}
	
	public void viewSumMoney(){
		System.out.println("订单总额为：" + getSumMoney() + "元");
	}
	
	public void printInfo(){
		System.out.println("\nTeam1 餐馆");
		System.out.printf("取餐号：%010d\n",number);
		if (foods == null){
			System.out.println("您还没有点餐");
		}else {
			System.out.println(foods.length);
			for(int i = 0; i < foods.length; i++){
				if (foods[i] == null){
					break;
				}
				foods[i].printInfo();
			}
		}
		viewSumMoney();
		System.out.println("点餐时间：" + formater.format(time));
		System.out.println("支付状态：" + getPayStatus());
	}
	
	public String getPayStatus(){
		return isPay ? "已支付" : "未支付"; 
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
