package com.javateam1.flwoerstore.control;

import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.dao.AccountDao;
import com.javateam1.flowerstore.model.Account;

public class AccountManager {
	private static List<Account> accounts = new ArrayList<Account>();
	
	public AccountManager(){
		initAccountArray();
	}
	
	// ��ȡ���ݿ����û���
	private static void initAccountArray() {
		try {
			accounts = AccountDao.loadAllAccounts();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void saveAccountInfo(Account a){
		
		try {
			if(AccountDao.selectAccount(a.getId()) == null){
				AccountDao.insertAccount(a);
			}else{
				AccountDao.updateAccount(a);
			}
		} catch (Exception e) {
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
			System.out.println("�˻��Ѵ���");
			return false;
		}else {
			accounts.add(a);
			saveAccountInfo(a);
			System.out.println("�˻���ӳɹ�");
			if(a.getIsonline() == 0){
				a.getShoppingCart().initShoppingCart(a);
				a.getOrderlist().initOrderList(a);
				a.setIsonline(1);
				try {
					AccountDao.updateAccount(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
		}
	}
	
	public static Account authenticate(String id, String pwd){
		Account ad = findAccountById(id);
		
		if(ad == null){
			System.out.println("�˻�������");
		} else if (!ad.getPwd().equals(pwd)){
				System.out.println("�˻��������벻ƥ��");
				return null;
			} else{
				System.out.println("��֤�ɹ�");
				
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
			System.out.println("֧���ɹ�");
			return true;
		} else {
			System.out.println("֧��ʧ��");
			return false;
		}
	}
	
	public static void viewBalance(Account a){
		System.out.println("��ǰ��" + a.getBalance().getBalance() + "Ԫ");
	}
	
	public static void printAccountInfo(Account a){
		System.out.println("�˺ţ�" + a.getId() + "\t���룺" + a.getPwd());
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
			return "��";
		}else{
			return s;
		}
	}
}
