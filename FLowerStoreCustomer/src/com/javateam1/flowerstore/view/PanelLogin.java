package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;

public class PanelLogin extends PanelDemo{
	private JLabel lbTop = new JLabel();
	private JLabel lbCLeft = new JLabel();
	private JComboBox<String> txId = new JComboBox<String>();
	private JPasswordField  txPwd = new JPasswordField();
	private JCheckBox cbJZMM = new JCheckBox("记住密码");
	private JButton btnLogin = new JButton("登录");
	private JButton btnSign = new JButton("注册账号");
	
	public PanelLogin(){
		this.setTitle("网上订花系统登录");
		
		lbTop.setIcon(new ImageIcon("img/bg1.png"));
		lbTop.setPreferredSize(new Dimension(485,195));
		this.getCon().add("North",lbTop);
		
		JPanel pCenter = new JPanel();
		pCenter.setPreferredSize(new Dimension(485,95));
		pCenter.setBackground(Color.white);
		
		lbCLeft.setIcon(new ImageIcon("img/boy.jpg"));
		pCenter.setAlignmentY(5);
		
		pCenter.add(lbCLeft);
		
		JPanel pCCenter = new JPanel();
		pCCenter.setLayout(new GridLayout(3,2,20,10));
		pCCenter.setAlignmentY(5);
		
		pCCenter.setBackground(Color.white);
		
		txId.setEditable(true);
		txId.setBackground(Color.white);
		pCCenter.add(txId);
		pCCenter.add(btnSign);
		
		
		pCCenter.add(txPwd);
		
		pCCenter.add(cbJZMM);
		cbJZMM.setBackground(Color.white);
		
		pCenter.add(pCCenter);
		
		this.getCon().add("Center", pCenter);
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.white);
		bottom.add(btnLogin);
		this.getCon().add("South",bottom);
		initPanel();
		
		// 登录监听
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String curId = (String) txId.getSelectedItem();
				char[] pwdArray = txPwd.getPassword();
				String curPwd = String.valueOf(pwdArray);
				if (curId != null && !curId.equals("")){
					if(!curPwd.equals("")){
						String[] dataArray = {DataType.LOGIN, curId, curPwd}; 
						String data = ArrayToString.arrayToString(dataArray);
						pushData(data);
					}else{
						JOptionPane.showMessageDialog(null, "密码不能为空");
					}
				}else{
					JOptionPane.showMessageDialog(null, "id不能为空");
				}
			}

			
		});
		
		btnSign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LayerManager.hideLayer(DataType.LOGIN);
				PanelSign sign = new PanelSign();
				LayerManager.addLayer(DataType.SIGN, sign);
			}
			
		});
	}
	
	public void hidePanel(){
		this.setVisible(false);
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}

}
