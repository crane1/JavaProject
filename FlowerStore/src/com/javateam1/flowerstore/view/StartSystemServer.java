package com.javateam1.flowerstore.view;

import com.javateam1.flwoerstore.control.AccountManager;
import com.javateam1.flwoerstore.control.MainServer;


public class StartSystemServer {

	public static void main(String[] args) {
		AccountManager accountManager = new AccountManager();
		MainServer server = new MainServer();
		
		// Æô¶¯·şÎñÆ÷
		server.initMainServer();
	}

}
