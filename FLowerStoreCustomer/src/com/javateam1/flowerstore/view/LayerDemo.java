package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.javateam1.flowerstore.control.TCPClient;

public class LayerDemo extends JFrame{
	private TCPClient client;
	private Container con = this.getContentPane();
	
	public LayerDemo(TCPClient client){
		this.client = client;
		con.setBackground(Color.white);
		con.setLayout(new BorderLayout(0, 10));
		
	}
	
	public void initPanel(){
		
		this.pack();
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	public Container getCon() {
		return con;
	}

	public void setCon(Container con) {
		this.con = con;
	}
	
	
}
