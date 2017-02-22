package com.javateam1.restuarant.control;

import com.javateam1.restuarant.model.Order;

public class OrderManager {
	private Order[] orders;
	private int listLength = 0;
	
	public OrderManager(){
		orders = new Order[100];
	}
	
	public Order[] getOrders() {
		return orders;
	}
	public void setOrders(Order[] orders) {
		this.orders = orders;
	}
	public int getListLength() {
		return listLength;
	}
	public void setListLength(int listLength) {
		this.listLength = listLength;
	}
	
	public void addOrder(Order order){
		if (listLength < orders.length){
			orders[listLength] = order;
			listLength++;
		} else {
			System.out.println("已超过存储上限！");
		}
	}
	
	public void deletOrder(int index){
		int num = 0;  
		for (int i = 0; i < listLength; i++){
			if (!orders[i].isDelete()){
				continue;
			}
			num++;
			if (num == index){
				orders[i].setDelete(false);
			}
		}
	}
	
	public void printOrderList(){
		int i = 1;
		for(Order o : orders){
			if (o == null ){
				break;
			}else if(o.isDelete() ){
				System.out.println("\n账单" + i);
				o.printInfo();
				i++;
			}
		}
	}
	
	public void printOrderNoPayList(){
		int i = 1;
		for(Order o : orders){
			if (o == null || o.isPay()){
				break;
			}else if(o.isDelete()){
				System.out.println("\n账单" + i);
				o.printInfo();
				i++;
			}
		}
	}
	
	public int getNoPayIndex(int index){
		int num = 0; 
		int real_index = 0;
		for (int i = 0; i < listLength; i++){
			// 已经被删除和被支付
			if (!orders[i].isDelete() || orders[i].isPay()){
				continue;
			}
			num++;
			if (num == index){
				real_index = i;
			}
		}
		return real_index;
	}
	
	
}
