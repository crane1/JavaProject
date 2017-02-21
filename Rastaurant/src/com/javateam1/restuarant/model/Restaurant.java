package com.javateam1.restuarant.model;

public class Restaurant {
	private FoodList foodlist;
	private Balance balance;
	private OrderList orders;
	
	public Restaurant(){
		foodlist = new FoodList();
		balance = new Balance();
		setOrders(new OrderList());
	}

	public FoodList getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(FoodList foodlist) {
		this.foodlist = foodlist;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public OrderList getOrders() {
		return orders;
	}

	public void setOrders(OrderList orders) {
		this.orders = orders;
	}
	
	
}
