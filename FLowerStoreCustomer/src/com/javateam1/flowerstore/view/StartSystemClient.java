package com.javateam1.flowerstore.view;

import com.javateam1.flowerstore.control.AccountManager;
import com.javateam1.flowerstore.control.TCPClient;
import com.javateam1.flowerstore.model.Account;

public class StartSystemClient {

	public static void main(String[] args) {
		new AccountManager();
		new Account();
		TCPClient client = new TCPClient();
		
		// Æô¶¯¿Í»§¶Ë
		client.startTCP();
		new LayerManager(client);
		LayerManager.setClient(client);
	}
}
