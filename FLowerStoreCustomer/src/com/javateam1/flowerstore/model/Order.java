package com.javateam1.flowerstore.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Order {
//	���ԣ�id��flowerList, time, sumMoney, isPay, isDelete
	
	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static int counter = 1;
	private String id;
	private Date time;
	private double sumMoney;
	private boolean isPay;
	private List<Flower> flowerList;
	private boolean isDelete;
	
	public Order(){
		id = String.format("%03d", counter);
		counter++;
		isPay = false;
		sumMoney = 0;
		setDelete(true);
		time = new Date(); 
	}
	public Order(List<Flower> flowers){
		this();
		this.flowerList = flowers;
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
	public List<Flower> getFlowerList() {
		return flowerList;
	}
	public void setFlowerList(List<Flower> flowerList) {
		this.flowerList = flowerList;
	}
	@Override
	public String toString() {
		return "Order [��ţ�" + id + ", ʱ�䣺" + time + ", �ܽ�" + sumMoney
				+ ", �Ƿ�֧����" + isPay + ", ���б�" + flowerList + "]";
	}
}
