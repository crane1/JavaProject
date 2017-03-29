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
			// ���ж�ȡ�����ļ�
			
			while((line = bf.readLine()) != null && line.length() > 0){
				if(line.charAt(0) == '#'){
					continue;
				}
				System.out.println(line);
				
				String[] attrs = line.split(",");
				for(String s : attrs){
					System.out.println(s);
				}
				
//				���ԣ�id��, time, sumMoney, isPay, isDelete,flowerList
				Order order = new Order();
				order.setId(attrs[0]);
				order.setTime(attrs[1]);
				order.setSumMoney(Double.valueOf(attrs[2]));
				order.setPay(attrs[3].equals("1") ? true :false);
				order.setDelete(attrs[4].equals("1") ? true :false);
				
				List<FlowerInfo> flowerList = new ArrayList<FlowerInfo>(); 
				
				//����Ĳ�����λ��ʾ�����л����б�����ֻ����ID��������
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
			// ����ر����д򿪵���������ᱨnotfoundfile�쳣
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�������ļ�����");
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
//			���ԣ�id��, time, sumMoney, isPay, isDelete,flowerList
			for(Order o : orders){
				//��Ӷ�����������
				s =o.getId() + "," + o.getTime() + "," + o.getSumMoney() + "," +
						(o.isPay() ? 1 : 0) + "," + (o.isDelete() ? 1 : 0);
				//ѭ����Ӷ���������
				for(FlowerInfo fi : o.getFlowerList()){
					s = s + "," + fi.getId() + "," + fi.getNum();
				}
				s = s + "\n"; //׷�ӻ���
				bw.write(s);
				bw.flush();
			}
			
			// ����ر����д򿪵����������´�ʹ�ûᱨnotfoundfile�쳣
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
			//����ȡ���Ļ����󴫵ݸ������еĻ��б�
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
			// ����û��ɾ���Ķ���
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
