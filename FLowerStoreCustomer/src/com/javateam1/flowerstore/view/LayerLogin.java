package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
import com.javateam1.flowerstore.control.TCPClient;
import com.javateam1.flowerstore.model.Account;

public class LayerLogin extends LayerDemo{
	private JLabel lbTop = new JLabel();
	private JLabel lbCLeft = new JLabel();
	private JComboBox<String> txId = new JComboBox<String>();
	private JPasswordField  txPwd = new JPasswordField();
	private JCheckBox cbJZMM = new JCheckBox("记住密码");
	private JButton btnLogin = new JButton("登录");
	private JButton btnSign = new JButton("注册账号");
	private Set<Account> accountList = new HashSet<Account>();
	
	public LayerLogin(TCPClient client){
		super(client);
		readUserDate();
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
		
		int i = 0;
		for(Account a: accountList){
			if(i==0){
				txId.addItem(a.getId());
				txPwd.setText(a.getPwd());
				i++;
				continue;
			}
			txId.addItem(a.getId());
			i++;
		}
		
		pCCenter.add(txId);
		pCCenter.add(btnSign);
		txId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == txId){
					String id = (String) txId.getSelectedItem();
					for(Account a: accountList){
						if(a.getId().equals(id)){
							txPwd.setText(a.getPwd());
						}
					}
				}
				
			}
		});
		
		pCCenter.add(txPwd);
		
		pCCenter.add(cbJZMM);
		cbJZMM.setBackground(Color.white);
		cbJZMM.setSelected(true);
		
		
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
						LayerManager.pushData(data);
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
				LayerSign sign = new LayerSign(LayerManager.getClient());
				LayerManager.addLayer(DataType.SIGN, sign);
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.LOGIN);
				System.exit(0);
			}
		});
	}
	
	public void saveUserDate() {
		String fpath = "config/user_data.csv";
		File f = new File(fpath);
		
		try {
			if(!f.exists()){
				f.createNewFile();
			}
			FileWriter fr = new FileWriter(f);
			
			//保存当前用户信息
			String curId = (String) txId.getSelectedItem();
			char[] pwdArray = txPwd.getPassword();
			String curPwd = String.valueOf(pwdArray);
			String str = curId + ",";
			if(cbJZMM.isSelected()){
				str = str + curPwd;
			}
			fr.write(str + "\n");
			fr.flush();
			
			
			// 保存用户列表中的信息
			for(Account a : accountList){
				if(!a.getId().equals(curId)){
					String Id = a.getId();
					String Pwd = a.getPwd();
					str = Id + "," + Pwd;
					fr.write(str + "\n");
					fr.flush();
				}
			}
			fr.close();	
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void readUserDate(){
		String fpath = "config/user_data.csv";
		File f = new File(fpath);
		if(f.exists()){
			FileReader fr;
			try {
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String str = null;
				while((str = br.readLine()) != null){
					String[] data = str.split(",");
					Account a = new Account();
					a.setId(data[0]);
					if(data.length == 2){
						a.setPwd(data[1]);
					}
					accountList.add(a);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
	}

	

}
