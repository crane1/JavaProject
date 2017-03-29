package com.javateam1.flwoerstore.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.Flower;
import com.javateam1.flowerstore.model.FlowerInfo;
import com.javateam1.flowerstore.model.Order;

public class OrderManager {
	private List<Order> orders = new ArrayList<Order>();
	private static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void initOrderList(Account a){
		try {
			File file = new File("config/orders/"+ a.getId() + "_order.csv");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String line = "";
			// 按行读取配置文件
			
			while((line = bf.readLine()) != null && line.length() > 0){
				if(line.charAt(0) == '#'){
					continue;
				}
				System.out.println(line);
				
				String[] attrs = line.split(",");
				for(String s : attrs){
					System.out.println(s);
				}
				
//				属性：id，, time, sumMoney, isPay, isDelete,flowerList
				Order order = new Order();
				order.setId(attrs[0]);
				order.setTime(attrs[1]);
				order.setSumMoney(Double.valueOf(attrs[2]));
				order.setPay(attrs[3].equals("1") ? true :false);
				order.setDelete(attrs[4].equals("1") ? true :false);
				
				List<FlowerInfo> flowerList = new ArrayList<FlowerInfo>(); 
				
				//后面的不定长位表示订单中花的列表，其中只保存ID，和数量
				for(int i = 5; i < attrs.length; i+=2){
					Flower f = FlowerManager.findFoodById(attrs[i]);
					if(f != null){
						FlowerInfo fi = new FlowerInfo(f.getId(), f.getName(), f.getPrice(), Integer.valueOf(attrs[i+1]));
						flowerList.add(fi);
					}
				}
				order.setFlowerList(flowerList);
				orders.add(order);
			}
			// 必须关闭所有打开的流，否则会报notfoundfile异常
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("无配置文件加载");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveOrderList(Account a){
		try {
			File file = new File("config/orders/"+ a.getId() + "_order.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String s = "";
//			属性：id，, time, sumMoney, isPay, isDelete,flowerList
			for(Order o : orders){
				//添加订单基础属性
				s =o.getId() + "," + o.getTime() + "," + o.getSumMoney() + "," +
						(o.isPay() ? 1 : 0) + "," + (o.isDelete() ? 1 : 0);
				//循环添加订单花属性
				for(FlowerInfo fi : o.getFlowerList()){
					s = s + "," + fi.getId() + "," + fi.getNum();
				}
				s = s + "\n"; //追加换行
				bw.write(s);
				bw.flush();
			}
			
			// 必须关闭所有打开的流，否则下次使用会报notfoundfile异常
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public  Order buildOrder(Account a, List<FlowerInfo> list){
		Order order = new Order();
		for(FlowerInfo fi : list){
			FlowerInfo f = new FlowerInfo();
			f.setId(fi.getId());
			f.setName(fi.getName());
			f.setNum(fi.getNum());
			f.setPrice(fi.getPrice());
			f.setTotal_price(fi.getTotal_price());
			//将获取到的花对象传递给订单中的花列表
			order.getFlowerList().add(f);
			order.addSumMoney(fi.getTotal_price());
		}
		orders.add(order);
		printOrderList();
		saveOrderList(a);
		return order;
	}
	
	public static boolean payOrder(Account a, Order order){
		double total_money = order.getSumMoney();
		if(AccountManager.pay(a, total_money)){
			order.setPay(true);
			return true;
		}else{
			return false;
		}
	}
	
	public List<String> getOrderList(){
		List<String> ordersStr = new ArrayList<String>();
		printOrderList();
		for(Order o : orders){
			// 返回没有删除的订单
			if(o.isDelete()){
				ordersStr.add(o.getId());
				StringBuffer s = new StringBuffer();
				for(FlowerInfo fi : o.getFlowerList()){
					s.append(fi.getName()+":");
					s.append(fi.getNum() + " ");
				}
				ordersStr.add(s.toString());
				ordersStr.add(String.valueOf(o.getSumMoney()));
				ordersStr.add(o.getTime());
				ordersStr.add(String.valueOf(o.isPay()));
			}
		}
		return ordersStr;
	}
	
	public void deleteOrder(Account a, String[] data){
		List<Order> list = a.getOrderlist().getOrders();
		for(int i = 1; i < data.length; i++){
			for(Order o : list){
				if (o.getId().equals(data[i])){
					o.setDelete(false);
					saveOrderList(a);
				}
			}
		}
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
