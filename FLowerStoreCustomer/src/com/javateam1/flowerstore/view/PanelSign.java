package com.javateam1.flowerstore.view;

import java.awt.Dimension;


public class PanelSign extends PanelDemo {
	
	public PanelSign(){
		super();
		this.setTitle("ע��ҳ��");
		this.setPreferredSize(new Dimension(485,400));
//		���ԣ�id��pwd��name��address��telephone��orderList, balance, type
		initPanel();
	}
	
	public static void main(String[] args) {
		new PanelSign();
	}

}
