package com.javateam1.restuarant.model;

import java.util.Scanner;

import com.javateam1.restuarant.control.FoodManager;
import com.javateam1.restuarant.control.OrderManager;
import com.javateam1.restuarant.view.Menu;

public class Account {
	private final int INIT_FOODLIST_NUM = 10;
	private Scanner sc = new Scanner(System.in);
	private static int i = 1;
	private String id;
	private String pwd;
	private Balance balance;
	private OrderManager orderlist;
	private int type; // 0 普通账户  1 管理员
	
	public Account(){
		id = String.format("%04d", i++);
		pwd = id;
		balance = new Balance();
		orderlist = new OrderManager();
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

	public void printOrderInfo() {
		orderlist.printOrderList();
	}

	
	public void order(FoodManager foods, Restaurant rest){
		Food[] foodlist = new Food[INIT_FOODLIST_NUM];
		Order order = new Order();
		int i = 0;
		foods.printList();
		while(true){
			System.out.println("\n请输入菜名(q.退出)：");
			System.out.print("#:");
			String name = sc.next();
			if (name.equals("Q") || name.equals("q")){
				if(i>0){
					order.setFoods(foodlist);
					order.setPay(false);
					order.calSumMoney();
					order.printInfo();
					this.orderlist.addOrder(order);
					rest.getOrders().addOrder(order);
				}
				break;
			}
			int index = foods.findFood(name);
			if (index >= 0){
				if ( i < foodlist.length){
					foodlist[i] = foods.getFoodList()[index];
					i++;
				} else {
					System.out.println("每次最多" + foodlist.length + "份菜");
					break;
				}
			} else {
				System.out.println("\n输入的菜名不存在，请重新输入");
			}
		}
	}
	
	public void payOrder(){
		orderlist.printOrderNoPayList();
		System.out.println("\n请输入需要支付的订单编号：");
		System.out.print("#:");
		int str = Menu.getInputIntNum();
		int num = orderlist.getNoPayIndex(str);
		Order order = orderlist.getOrders()[num];
		double payMoney = order.getSumMoney();
		if(pay(payMoney)){
			order.setPay(true);
		}
	}
	
	public void recharge(){
		System.out.println("\n请输入充值金额：");
		System.out.print("#:");
		double num = sc.nextDouble();
		if (num > 0){
			balance.deposite(num);
		} else {
			System.out.println("请输入正确金额数");
		}
	}
	
	
	public boolean pay(double num){
		if (balance.withDraw(num)){
			System.out.println("支付成功");
			return true;
		} else {
			System.out.println("支付失败");
			return false;
		}
	}
	
	public void viewBalance(){
		System.out.println("当前余额：" + balance.getBalance() + "元");
	}
	
	public void printAccountInfo(){
		System.out.println("账号：" + getId() + "\t密码：" + getPwd());
	}
	
	public void deletOrder(){
		orderlist.printOrderList();
		System.out.println("请输入你要删除的订单编号");
		System.out.println("#");
		int num = sc.nextInt();
		orderlist.deletOrder(num);
	}
}
