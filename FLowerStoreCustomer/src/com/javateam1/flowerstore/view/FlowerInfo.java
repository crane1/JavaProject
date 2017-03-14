package com.javateam1.flowerstore.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowerInfo extends JPanel {
	private JLabel pic = new JLabel(); 
	private JLabel name = new JLabel();
	private JLabel pname = new JLabel("心动价格");
	private JLabel price = new JLabel();
	
	public FlowerInfo(String picPath, String name, double price){
		this.pic.setIcon(new ImageIcon(picPath));
		this.name.setText(name);
		this.price.setText(String.valueOf(price));
		
		this.add(this.pic);
		this.add(this.name);
		this.add(this.pname);
		this.add(this.price);
	}
	
}
