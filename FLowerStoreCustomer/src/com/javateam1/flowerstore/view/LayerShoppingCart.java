package com.javateam1.flowerstore.view;

import com.javateam1.flowerstore.control.TCPClient;

public class LayerShoppingCart extends LayerDemo{
	
	public LayerShoppingCart(TCPClient client){
		super(client);
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}
	
	public void hidePanel(){
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
	}

}
