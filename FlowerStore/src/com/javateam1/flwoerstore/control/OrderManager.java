package com.javateam1.flwoerstore.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.FlowerInfo;
import com.javateam1.flowerstore.model.Order;

public class OrderManager {
	private List<Order> orders = new ArrayList<Order>();
	private static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public OrderManager(){
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order){
		orders.add(order);
	}
	
	public void deletOrder(Order order){
	}
	
	public void printOrderList(){
		for(Order o : orders){
			if(o.isDelete() ){
				System.out.println(o);
			}
		}
	}
	
	public List<Order> getOrderNoPayList(){
		List<Order> list = new ArrayList<Order>();
		for(Order o : orders){
			if (o.isPay()){
				continue;
			}else if(o.isDelete()){
				list.add(o);
			}
		}
		return list;
	}
	
	public  Order buildOrder(List<FlowerInfo> list){
		Order order = new Order();
		for(FlowerInfo fi : list){
			//将获取到的花对象传递给订单中的花列表
			order.getFlowerList().add(fi);
			order.addSumMoney(fi.getTotal_price());
		}
		
		return order;
	}
	
	public static boolean payOrder(Account a, Order order){
		double total_money = order.getSumMoney();
		if(AccountManager.pay(a, total_money)){
			return true;
		}else{
			return false;
		}
	}
	
	public static List<String> getOrderList(Account a){
		List<Order> list = a.getOrderlist().getOrders();
		List<String> ordersStr = new ArrayList<String>();
		
		for(Order o : list){
			ordersStr.add(o.getId());
			StringBuffer s = new StringBuffer();
			for(FlowerInfo fi : o.getFlowerList()){
				s.append(fi.getName()+":");
				s.append(fi.getNum() + " ");
			}
			ordersStr.add(s.toString());
			ordersStr.add(String.valueOf(o.getSumMoney()));
			ordersStr.add(formater.format(o.getTime()));
		}
		return ordersStr;
	}
}
