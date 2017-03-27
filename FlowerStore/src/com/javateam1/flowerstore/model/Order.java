package com.javateam1.flowerstore.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {
//	属性：id，flowerList, time, sumMoney, isPay, isDelete
	
	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static int counter = 1;
	private String id;
	private String time;
	private double sumMoney = 0;
	private boolean isPay;
	private List<FlowerInfo> flowerList;
	private boolean isDelete;
	
	public Order(){
		id = String.valueOf(counter);
		counter++;
		isPay = false;
		sumMoney = 0;
		setDelete(true);
		time = formater.format(new Date()); 
		flowerList = new ArrayList<FlowerInfo>();
	}
	public Order(List<FlowerInfo> flowers){
		this();
		this.flowerList = flowers;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
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
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<FlowerInfo> getFlowerList() {
		return flowerList;
	}
	public void setFlowerList(List<FlowerInfo> flowerList) {
		this.flowerList = flowerList;
	}
	
	public void addSumMoney(double price){
		this.sumMoney += price;
	}
	
	@Override
	public String toString() {
		return "Order [编号：" + id + ", 时间：" + time + ", 总金额：" + sumMoney
				+ ", 是否支付：" + isPay + ", 花列表：" + flowerList + "]";
	}
}
