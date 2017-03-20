package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyComboBox extends JPanel{
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	public MyComboBox(String item){
		this.setBackground(Color.white);
		comboBox.addItem(item);
		this.add(comboBox);
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	
	public void addItem(String item){
		comboBox.addItem(item);
	}
	
	
}
