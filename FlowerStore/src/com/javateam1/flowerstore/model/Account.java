package com.javateam1.flowerstore.model;

import java.util.Scanner;

import com.javateam1.flwoerstore.control.FlowerManager;
import com.javateam1.flwoerstore.control.OrderManager;

public class Account {
//	属性：id，pwd，name，address，telephone，orderList, balance, type
	private static int i = 1; 
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String telephone;
	private Balance balance;
	private ShoppingCart shoppingCart;
	private OrderManager orderlist;
	private int type; // 0 普通账户  1 管理员
	
	public Account(){
		id = String.format("%03d", i++);
		pwd = id;
		balance = new Balance();
		orderlist = new OrderManager();
		shoppingCart = new ShoppingCart();
		setType(0);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public OrderManager getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(OrderManager orderlist) {
		this.orderlist = orderlist;
	}

	public void printOrderInfo() {
		orderlist.printOrderList();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", address=" + address + ", telephone=" + telephone
				+ ", balance=" + balance + ", type=" + type + "]";
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
