package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyLabel extends JPanel{
	private JLabel label;
	
	public MyLabel(String name, Font f){
		this.setBackground(Color.white);
		label = new JLabel(name);
		label.setFont(f);
		this.add(label);
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
