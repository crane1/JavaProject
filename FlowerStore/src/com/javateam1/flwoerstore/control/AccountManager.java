package com.javateam1.flwoerstore.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javateam1.flowerstore.model.Account;

public class AccountManager {
	private static List<Account> accounts = new ArrayList<Account>();
	private static Map<String, Integer> isLogin = new HashMap<String, Integer>();
	
	public AccountManager(){
		initAccountArray();
	}
	
	// 读取用户表配置文件
	private void initAccountArray() {
		try {
			File file = new File("config/accountlist.csv");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String line = "";
			// 按行读取配置文件
			while((line = bf.readLine()) != null){
				// 注释行省略
				if(line.charAt(0) == '#'){
					continue;
				}
				
				//将读取到的属性按，划分开，分别存储
				String[] attrs = line.split(",");
				Account account = new Account();
				account.setId(attrs[0]);
				account.setPwd(attrs[1]);
				account.setName(attrs[2]);
				account.setAddress(attrs[3]);
				account.setTelephone(attrs[4]);
				account.setType(Integer.valueOf(attrs[5]));
				account.getBalance().setUser_id(account.getId());
				account.getBalance().readBalance();  //读入余额
				accounts.add(account);
				isLogin.put(account.getId(), 0);
			}
			// 必须关闭所有打开的流，否则会报notfoundfile异常
			bf.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void saveAccountInfo(Account a){
		try {
			File file = new File("config/accountlist.csv");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String s =a.getId() + "," + a.getPwd() + "," + a.getName()
					 + "," + a.getAddress()+ "," + a.getTelephone() + "," + a.getType();
			bw.write(s);
			bw.flush();
			// 必须关闭所有打开的流，否则会报notfoundfile异常
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printAccountArray(){
		for (Account a : accounts){
			System.out.println(a);
		}
	}
	
	public static Account findAccountById(String id){
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
	
	public static boolean addAccount(Account a){
		Account ad = findAccountById(a.getId());
		if (ad != null){
			System.out.println("账户已存在");
			return false;
		}else {
			accounts.add(a);
			saveAccountInfo(a);
			System.out.println("账户添加成功");
			return true;
		}
	}
	
	public static Account authenticate(String id, String pwd){
		Account ad = findAccountById(id);
		
		if(ad == null){
			System.out.println("账户不存在");
		} else if (!ad.getPwd().equals(pwd)){
				System.out.println("账户名和密码不匹配");
				return null;
			} else{
				System.out.println("验证成功");
				if (isLogin != null && isLogin.get(ad.getId()) != 1){
					ad.getShoppingCart().initShoppingCart(ad);
					ad.getOrderlist().initOrderList(ad);
					isLogin.put(ad.getId(), 1);
					return ad;
				}
				
			}
		return ad;
	}
	
	public static boolean recharge(Account a, double num){
		if (num > 0){
			a.getBalance().deposite(num);
			return true;
		}else {
			return false;
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
	
	public static List<String> getAccountInfo(Account a){
		List<String> accountInfo = new ArrayList<String>();
		accountInfo.add(getString(a.getId()));
		accountInfo.add(getString(a.getName()));
		accountInfo.add(getString(a.getTelephone()));
		accountInfo.add(getString(String.valueOf(a.getBalance().getBalance())));
		accountInfo.add(getString(a.getAddress()));
		return accountInfo;
	}
	
	public static String getString(String s){
		if(s==null){
			return "无";
		}else{
			return s;
		}
	}
}
