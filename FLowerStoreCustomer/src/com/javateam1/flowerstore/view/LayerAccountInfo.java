package com.javateam1.flowerstore.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;


@SuppressWarnings("serial")
public class LayerAccountInfo extends LayerDemo {
	private MyLabel lbId = new MyLabel("�˺�",new Font("����", Font.BOLD, 20));
	private MyLabel lbname = new MyLabel("����",new Font("����", Font.BOLD, 20));
	private MyLabel lbtel = new MyLabel("�ֻ�",new Font("����", Font.BOLD, 20));
	private MyLabel lbbanl = new MyLabel("���",new Font("����", Font.BOLD, 20));
	private MyLabel lbaddr = new MyLabel("��ַ",new Font("����", Font.BOLD, 20));
	private MyButton btnCharge = new MyButton("��ֵ");
	
	public LayerAccountInfo(TCPClient client){
		super(client);
		this.setTitle("�˻���Ϣ");
		this.setPreferredSize(new Dimension(200,300));
		this.getCon().setLayout(new GridLayout(6,1));
		
//		���ԣ�id��pwd��name��address��telephone��orderList, balance, type
		
		this.getCon().add(lbId);
		
		this.getCon().add(lbname);
		this.getCon().add(lbtel);
		this.getCon().add(lbbanl);
		this.getCon().add(lbaddr);
		this.getCon().add(btnCharge);
		initPanel();
		
		btnCharge.getButton().addActionListener(new myButtonActionListener());
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.VIEW_ACCOUNT);
			}
		});
	}
	
	class myButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String snum = JOptionPane.showInputDialog("�������ֵ��");
			while(true){
				if(snum != null){
					try{
						double dnum = Double.valueOf(snum);
						if(dnum > 0){
							String[] dataArray = {DataType.CHARGE, snum}; 
							String data = ArrayToString.arrayToString(dataArray);
							LayerManager.pushData(data);
							break;
						}
					}catch(NumberFormatException es){
						JOptionPane.showMessageDialog(null, "��������");
						snum = JOptionPane.showInputDialog("�������ֵ��");
					}
				}
			}
			
		}
	}
	
	public void initAccountInfo(String[] data){
		
		lbId.setText("�˺ţ�" + data[1]);
		lbname.setText("������" + data[2]);
		lbtel.setText("�绰��" + data[3]);
		lbbanl.setText("������" + data[4]);
		lbaddr.setText("��ַ��" + data[5]);
	}
	
	
	
	public MyLabel getLbbanl() {
		return lbbanl;
	}

	public void setLbbanl(MyLabel lbbanl) {
		this.lbbanl = lbbanl;
	}

	public static void main(String[] args) {
	}

}
