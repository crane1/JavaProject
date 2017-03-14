package com.javateam1.flowerstore.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;


public class LayerSign extends LayerDemo {
	private MyLabel lbtitle = new MyLabel("ע���û�",new Font("����", Font.BOLD, 30));
	private LabelAndTextField ltId = new LabelAndTextField("�˺�",0);
	private LabelAndTextField ltPwd = new LabelAndTextField("����",1);
	private LabelAndTextField ltAddress = new LabelAndTextField("��ַ",0);
	private LabelAndTextField ltTel = new LabelAndTextField("�绰",0);
	private MyButton btnSign = new MyButton("ע��");
	public LayerSign(){
		super();
		this.setTitle("ע��ҳ��");
		this.setPreferredSize(new Dimension(485,400));
		this.getCon().setLayout(new GridLayout(6,1));
		
		
//		���ԣ�id��pwd��name��address��telephone��orderList, balance, type
		
		this.getCon().add(lbtitle);
		
		this.getCon().add(ltId);
		this.getCon().add(ltPwd);
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
				if ( ltId.getTextField()== null || curId.equals("")){
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��");
				}else if(ltPwd.getTextField() == null || curPwd.equals("")){
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
				}else if(ltAddress.getTextField() == null || curAddr.equals("")){
					JOptionPane.showMessageDialog(null, "��ַ����Ϊ��");
				}else if(ltTel.getTextField() == null || curTel.equals("")){
					JOptionPane.showMessageDialog(null, "�绰����Ϊ��");
				}else {
					String[] dataArray = {DataType.SIGN, curId, curPwd, curAddr, curTel}; 
					String data = ArrayToString.arrayToString(dataArray);
					pushData(data);
				}
				
			}
		});
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}
	
	public static void main(String[] args) {
		new LayerSign();
	}

}
