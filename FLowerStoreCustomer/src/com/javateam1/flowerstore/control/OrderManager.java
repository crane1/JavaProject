package com.javateam1.flowerstore.control;

import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Order;

public class OrderManager {
	private List<Order> orders = new ArrayList<Order>();
	
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
}
