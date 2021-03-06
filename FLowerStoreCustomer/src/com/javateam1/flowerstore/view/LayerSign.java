package com.javateam1.flowerstore.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;


@SuppressWarnings("serial")
public class LayerSign extends LayerDemo {
	private MyLabel lbtitle = new MyLabel("注册用户",new Font("宋体", Font.BOLD, 30));
	private LabelAndTextField ltId = new LabelAndTextField("账号",0);
	private LabelAndTextField ltPwd = new LabelAndTextField("密码",1);
	private LabelAndTextField ltName = new LabelAndTextField("昵称",0);
	private LabelAndTextField ltAddress = new LabelAndTextField("地址",0);
	private LabelAndTextField ltTel = new LabelAndTextField("电话",0);
	private MyButton btnSign = new MyButton("注册");
	public LayerSign(TCPClient client){
		super(client);
		this.setTitle("注册页面");
		this.setPreferredSize(new Dimension(485,400));
		this.getCon().setLayout(new GridLayout(7,1));
		
		
//		属性：id，pwd，name，address，telephone，orderList, balance, type
		
		this.getCon().add(lbtitle);
		
		this.getCon().add(ltId);
		this.getCon().add(ltPwd);
		this.getCon().add(ltName);
		this.getCon().add(ltAddress);
		this.getCon().add(ltTel);
		this.getCon().add(btnSign);
		initPanel();
		
		btnSign.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String curId = ltId.getTextField().getText();
				String curPwd = String.valueOf(((JPasswordField) ltPwd.getTextField()).getPassword());
				String curAddr = ltAddress.getTextField().getText();
				String curTel = ltTel.getTextField().getText();
				String curName = ltName.getTextField().getText();
				if ( ltId.getTextField()== null || curId.equals("")){
					JOptionPane.showMessageDialog(null, "账号不能为空");
				}else if(ltPwd.getTextField() == null || curPwd.equals("")){
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}else if(ltAddress.getTextField() == null || curAddr.equals("")){
					JOptionPane.showMessageDialog(null, "地址不能为空");
				}else if(ltTel.getTextField() == null || curTel.equals("")){
					JOptionPane.showMessageDialog(null, "电话不能为空");
				}else if(ltName.getTextField() == null || curTel.equals("")){
					JOptionPane.showMessageDialog(null, "姓名不能为空");
				}else {
					String[] dataArray = {DataType.SIGN, curId, curPwd, curName, curAddr, curTel}; 
					String data = ArrayToString.arrayToString(dataArray);
					pushData(data);
				}
				
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.SIGN);
			}
		});
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}
	
	public static void main(String[] args) {
	}

}
