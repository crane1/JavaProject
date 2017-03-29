package com.javateam1.flowerstore.start;

import com.javateam1.flowerstore.control.TCPClient;
import com.javateam1.flowerstore.model.Account;
import com.javateam1.flowerstore.view.LayerManager;

public class StartSystemClient {

	public static void main(String[] args) {
		new Account();
		TCPClient client = new TCPClient();
		
		// Æô¶¯¿Í»§¶Ë
		client.startTCP();
		new LayerManager(client);
		LayerManager.setClient(client);
	}
}
