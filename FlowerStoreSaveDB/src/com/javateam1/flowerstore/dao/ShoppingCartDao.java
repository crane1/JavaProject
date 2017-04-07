package com.javateam1.flowerstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javateam1.flowerstore.model.Account;

public class ShoppingCartDao extends JDBCDao{
	private static  List<Account> list = new ArrayList<Account>();
	
	public static List<Account> loadAllAccounts() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from accounts";
		ResultSet rs = select(conn, sql);
		if(rs != null){
			while(rs.next()){
				Account account = new Account();
				account.setId(rs.getString(1));
				account.setPwd(rs.getString(2));
				account.setName(rs.getString(3));
				account.setAddress(rs.getString(4));
				account.setTelephone(rs.getString(5));
				account.setType(Integer.valueOf(rs.getString(6)));
				account.getBalance().setUser_id(account.getId());
				account.getBalance().setBalance(rs.getDouble(7));  //读入余额
				account.setIsonline(rs.getInt(8));
				list.add(account);
			}
			System.out.println("操作成功");
		}else{
			System.out.println("操作失败");
		}
		conn.close();
		return list;
	}
	
	public static Account selectAccount(String id) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from accounts where id='" + id + "'";
		ResultSet rs = select(conn, sql);
		Account account = null;
		if(rs != null){
			while(rs.next()){
				account = new Account();
				account.setId(rs.getString(1));
				account.setPwd(rs.getString(2));
				account.setName(rs.getString(3));
				account.setAddress(rs.getString(4));
				account.setTelephone(rs.getString(5));
				account.setType(Integer.valueOf(rs.getString(6)));
				account.getBalance().setUser_id(account.getId());
				account.getBalance().setBalance(rs.getDouble(7));
				account.setIsonline(rs.getInt(8));
			}
			
		}else {
			System.out.println("查询失败");
		}
		conn.close();
		return account;
	}
	
	public static void updateAccount(Account s) throws Exception{
		Account account = selectAccount(s.getId());
		String set = "";
		if(!account.getPwd().equals(s.getPwd())){
			set = set + "pwd='" + s.getPwd() + "',";
		}
		if(!account.getName().equals(s.getName())){
			set = set + "name='" + s.getName() + "',"; 
		}
		if(!account.getAddress().equals(s.getAddress())){
			set = set + "address='" + s.getAddress() + "',"; 
		}
		if(!account.getTelephone().equals(s.getTelephone())){
			set = set + "telephone='" + s.getTelephone() + "',"; 
		}
		if(account.getBalance().getBalance() != (s.getBalance().getBalance())){
			set = set + "balance=" + s.getBalance().getBalance() + ","; 
		}
		if(account.getType() !=(s.getType())){
			set = set + "type=" + s.getType() + ","; 
		}
		if(account.getIsonline() !=(s.getIsonline())){
			set = set + "isonline=" + s.getIsonline() + ","; 
		}
		
		if(set.length() > 0){
			set = set.substring(0,set.length()-1);
			String sql = "update accounts set " + set + " where id='" + s.getId() + "'";
			System.out.println(sql);
			Connection conn = getConnection();
			
			int count = update(conn, sql);
			if(count > 0){
				System.out.println("更新成功");
			}else {
				System.out.println("更新失败");
			}
			conn.close(); 
		}
		
	}
	
	public static void delectAccount(Account s) throws Exception{
		Connection conn = getConnection();
		String sql = "delete accounts where id=" + s.getId();
		int count = update(conn, sql);
		if(count > 0){
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		conn.close();
	}
	
	public static void insertAccount(Account a) throws Exception{
		Connection conn = getConnection();
		System.out.println(a);
		String sql = "insert into accounts values('"+ a.getId() + "','" + a.getPwd() + "','" + a.getName()
				 + "','" + a.getAddress()+ "','" + a.getTelephone() + "'," + a.getType()  + "," + a.getBalance().getBalance()
				 + ","+a.getIsonline()+")";
		int count = update(conn, sql);
		if(count > 0){
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		conn.close();
	}
	
	public void printList(){
		for(Account s : list){
			System.out.println(s);
		}
	}

}
