package com.javateam1.flowerstore.view;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyComboBox extends JPanel{
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	public MyComboBox(){
		this.setBackground(Color.white);
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
