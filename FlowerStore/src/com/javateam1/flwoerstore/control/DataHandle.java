package com.javateam1.flwoerstore.control;

import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.Flower;
import com.javateam1.flowerstore.model.FlowerInfo;
import com.javateam1.flowerstore.model.Order;

public class DataHandle {
	private TCPServer server;
	private Account account;
	private FlowerManager manager = new FlowerManager();
	
	public void handleData(String str){
		String[] data = str.split(",");
		if (data != null && data.length >= 1){
			String type = data[0];
			if(type.equals(DataType.LOGIN)){
				authenticate(data);
			}else if(type.equals(DataType.SIGN)){
				signAccount(data);
			}else if(type.equals(DataType.MAIN)){
				getFlowerInfo(data);
			}else if(type.equals(DataType.ADD_SHOP)){
				addShoppingCart(data);
			}else if(type.equals(DataType.VIEW_SHOP)){
				System.out.println(type);
				viewShoppingCart(data);
			}else if(type.equals(DataType.PAY)){
				System.out.println(type);
				buildAndPayOrder(data);
			}else if(type.equals(DataType.VIEW_ACCOUNT)){
				System.out.println(type);
				getAccountInfo(data);
			}else if(type.equals(DataType.CHARGE)){
				System.out.println(type);
				chargeMoney(data);
			}else if(type.equals(DataType.VIEW_ORDER)){
				System.out.println(type);
				viewOrder(data);
			}
		}
	}

	public void authenticate(String[] data){
		account = AccountManager.authenticate(data[1],data[2]);
		String[] dataArray =new String[3];
		dataArray[0] = DataType.LOGIN;
		if (account != null){
			dataArray[1] = "1";
			dataArray[2] = account.getId();
		}else {
			dataArray[1] = "0";
			dataArray[2] = "";
		}
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	private void signAccount(String[] data) {
		Account account = new Account();
		account.setId(data[1]);
		account.setPwd(data[2]);
		account.setAddress(data[3]);
		account.setAddress(data[4]);
		boolean isSucceed = AccountManager.addAccount(account);
		String[] dataArray =new String[2];
		
		dataArray[0] = DataType.SIGN;
		if (isSucceed){
			dataArray[1] = "1";
		}else {
			dataArray[1] = "0";
		}
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void  getFlowerInfo(String[] data){
		List<String> list = null;
		if (data[1].equals(DataType.FIRST)){
			list = manager.getRecommendFlower();
		} else if(data[1].equals(DataType.MATER)){
			list = manager.getMaterFlower(data[2]);
		}else if(data[1].equals(DataType.PRICE)){
			String prices[] = data[2].split("-");
			double price1 = Double.parseDouble(prices[0]);
			double price2 = Double.parseDouble(prices[1]);
			list = manager.getPriceFlower(price1, price2);
			System.out.println(list.size());
		}else if(data[1].equals(DataType.TYPE)){
			list = manager.getTypeFlower(data[2]);
			System.out.println(list.size());
		}else if(data[1].equals(DataType.NUMBER)){
			list = manager.getNumFlower(Integer.parseInt(data[2]));
			System.out.println(list.size());
		}
		
		int size = list.size() + 3;
		String[] dataArray = new String[size];
		dataArray[0] = DataType.MAIN;
		dataArray[1] = data[1];
		dataArray[2] = data[2];
		
		for (int i = 0; i < list.size(); i++){
			dataArray[i+3] = list.get(i);
		}
		
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void addShoppingCart(String[] data){
		String flower = null;
		if (data.length == 2 && !data[1].equals("")){
			flower = FlowerManager.findFoodById(data[1]).getId();
		}
		
		boolean isAddSucceed = false;
		if (flower != null){
//			System.out.println("account+" + account);
			isAddSucceed = account.getShoppingCart().addFlower(flower);
		}
		
		String[] dataArray =new String[2];
		dataArray[0] = DataType.ADD_SHOP;
		if (isAddSucceed){
			dataArray[1] = "1";
		}else {
			dataArray[1] = "0";
		}
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void viewShoppingCart(String[] data){
		List<String> list = account.getShoppingCart().viewCart();
		int size = list.size() + 1;
		String[] dataArray = new String[size];
		dataArray[0] = DataType.VIEW_SHOP;
		
		for (int i = 0; i < list.size(); i++){
			dataArray[i+1] = list.get(i);
		}
		
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}

	public void buildAndPayOrder(String[] data){
		List<FlowerInfo> filist = new ArrayList<FlowerInfo>();
		
		for(int i = 1; i < data.length; i++){
			//根据客户端传递的花编号获取购物车中的花信息
			FlowerInfo f = account.getShoppingCart().getFlowerById(data[i]);
			filist.add(f);
		}
		Order order = account.getOrderlist().buildOrder(filist);
		account.getOrderlist().addOrder(order);
		boolean ispaySucceed = OrderManager.payOrder(account, order);
		
		String[] dataArray =new String[2];
		dataArray[0] = DataType.PAY;
		if (ispaySucceed){
			dataArray[1] = "1";
			for(FlowerInfo f : filist){
				account.getShoppingCart().getList().remove(f);
			}
		}else {
			dataArray[1] = "0";
		}
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void getAccountInfo(String[] data){
		List<String> list = AccountManager.getAccountInfo(account);
		int size = list.size()+1;
		String[] dataArray = new String[size];
		dataArray[0] = DataType.VIEW_ACCOUNT;
		
		for (int i = 0; i < list.size(); i++){
			dataArray[i+1] = list.get(i);
		}
		
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void chargeMoney(String[] data){
		boolean isCharge = AccountManager.recharge(account, Double.valueOf(data[1]));
		
		String[] dataArray =new String[3];
		dataArray[0] = DataType.CHARGE;
		if (isCharge){
			dataArray[1] = "1";
		}else {
			dataArray[1] = "0";
		}
		dataArray[2] = String.valueOf(account.getBalance().getBalance());
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public void viewOrder(String[] data){
		List<String> list = AccountManager.getAccountInfo(account);
		int size = list.size()+1;
		String[] dataArray = new String[size];
		dataArray[0] = DataType.VIEW_ACCOUNT;
		
		for (int i = 0; i < list.size(); i++){
			dataArray[i+1] = list.get(i);
		}
		
		String datas = ArrayToString.arrayToString(dataArray);
		server.pushData(datas);
	}
	
	public TCPServer getServer() {
		return server;
	}

	public void setServer(TCPServer server) {
		this.server = server;
	}
}
