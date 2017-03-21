package com.javateam1.flwoerstore.control;

import java.util.List;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.Flower;

public class DataHandle {
	private TCPServer server;
	private Account account;
	private FlowerManager manager = new FlowerManager();
	
	public void handleData(String str){
		String[] data = str.split(",");
		if (data != null && data.length > 1){
			String type = data[0];
			if(type.equals(DataType.LOGIN)){
				authenticate(data);
			}else if(type.equals(DataType.SIGN)){
				signAccount(data);
			}else if(type.equals(DataType.MAIN)){
				getFlowerInfo(data);
			}else if(type.equals(DataType.SHOP)){
				addShoppingCart(data);
			}
		}
	}

	public void authenticate(String[] data){
		account = AccountManager.authenticate(data[1],data[2]);
		String[] dataArray =new String[2];
		dataArray[0] = DataType.LOGIN;
		if (account != null){
			dataArray[1] = "1";
		}else {
			dataArray[1] = "0";
			
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
		Flower flower = null;
		if (data.length == 2 && !data[1].equals("")){
			flower = manager.findFoodById(data[1]);
		}
		
		boolean isAddSucceed = false;
		if (flower != null){
			System.out.println("account+" + account);
			isAddSucceed = account.getShoppingCart().addFlower(flower);
		}
		
		String[] dataArray =new String[2];
		dataArray[0] = DataType.SHOP;
		if (isAddSucceed){
			dataArray[1] = "1";
		}else {
			dataArray[1] = "0";
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
