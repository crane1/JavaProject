package com.javateam1.flowerstore.view;

import com.javateam1.flowerstore.control.AccountManager;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;
import com.javateam1.flowerstore.model.Account;

public class StartSystemClient {

	public static void main(String[] args) {
		AccountManager accoutManager = new AccountManager();
		Account account = new Account();
		TCPClient client = new TCPClient();
		
		// Æô¶¯¿Í»§¶Ë
		client.startTCP();
		LayerManager layerManager = new LayerManager(client);
		LayerManager.setClient(client);
	}
}
