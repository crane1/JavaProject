package com.javateam1.flowerstore.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.model.Order;

public class AccountManager {
	private List<Account> accounts = new ArrayList<Account>();
	public AccountManager(){
		initAccountArray();
	}
	
	private void initAccountArray() {
		// 初始化管理员账户
		Account manager = new RestaurantManager();
		manager.setId("admin");
		manager.setPwd("admin");
		manager.setType(1);
		accounts.add(manager);
		
		Account account = new Account();
		accounts.add(account);
	}
	
	public void printAccountArray(){
		for (Account a : accounts){
			System.out.println(a);
		}
	}
	
	public Account findAccountById(String id){
		Account ad = null;
		for (Account a : accounts){
			if(a.getId().equals(id)){
				ad = a;
				break;
			}
		}
		return ad;
	}
	
	public Account findAccountByName(String name){
		Account ad = null;
		for (Account a : accounts){
			if(a.getName().equals(name)){
				ad = a;
				break;
			}
		}
		return ad;
	}
	
	public boolean addAccount(Account a){
		Account ad = findAccountById(a.getId());
		if (ad != null){
			System.out.println("账户已存在");
			return false;
		}else {
			accounts.add(a);
			return true;
		}
	}
	
	public Account authenticate(String id, String pwd){
		Account ad = findAccountById(id);
		
		if(ad == null){
			System.out.println("账户不存在");
		} else if (!ad.getPwd().equals(pwd)){
				System.out.println("账户名和密码不匹配");
				return null;
			} else{
				System.out.println("验证成功");
				return ad;
			}
		return ad;
		
	}
	
	public Account signIn(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账户名：");
		System.out.print("#:");
		String id = sc.next();
		System.out.println("请输入密码：");
		System.out.print("#:");
		String pwd = sc.next();
		Account account = authenticate(id, pwd);
		if ( account != null){
			return account;
		} else {
			return null;
		}
	}
	
	public static void payOrder(Account a){
		OrderManager orderList = a.getOrderlist();
		List<Order> list = orderList.getOrderNoPayList();
	}
	
	public static void recharge(Account a, double num){
		if (num > 0){
			a.getBalance().deposite(num);
		}
	}
	
	
	public static boolean pay(Account a, double num){
		if (a.getBalance().withDraw(num)){
			System.out.println("支付成功");
			return true;
		} else {
			System.out.println("支付失败");
			return false;
		}
	}
	
	public static void viewBalance(Account a){
		System.out.println("当前余额：" + a.getBalance().getBalance() + "元");
	}
	
	public static void printAccountInfo(Account a){
		System.out.println("账号：" + a.getId() + "\t密码：" + a.getPwd());
	}
	
	public void deletOrder(Order o){
		
	}

	public static void main(String[] args) {
		AccountManager a = new AccountManager();
		a.printAccountArray();
		a.printAccountArray();
	}
}
