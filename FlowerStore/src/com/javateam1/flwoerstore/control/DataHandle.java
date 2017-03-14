package com.javateam1.flwoerstore.control;

import com.javateam1.flowerstore.model.Account;

public class DataHandle {
	private TCPServer server;
	
	public void handleData(String str){
		String[] data = str.split(",");
		String type = data[0];
		if(type.equals(DataType.LOGIN)){
			authenticate(data);
		}else if(type.equals(DataType.SIGN)){
			signAccount(data);
		}
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

	public void authenticate(String[] data){
		Account account = AccountManager.authenticate(data[1],data[2]);
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

	public TCPServer getServer() {
		return server;
	}

	public void setServer(TCPServer server) {
		this.server = server;
	}
}
