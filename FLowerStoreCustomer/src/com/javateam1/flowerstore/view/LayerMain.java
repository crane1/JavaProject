package com.javateam1.flowerstore.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;


public class LayerMain extends LayerDemo {
	private MyLabel lbtitle = new MyLabel("���ϴ��Ȼ���",new Font("����", Font.BOLD, 30));
	private MyButton btnFirst = new MyButton("��ҳ");
	private MyButton btnMater = new MyButton("����"); 
	private MyButton btnPrice = new MyButton("�۸�");
	private MyButton btnType = new MyButton("����");
	private MyButton btnNum = new MyButton("֧��");
	private PanelDemo showArea;
	private Container con = this.getCon();
	
	public LayerMain(){
		super();
		this.setTitle("ע��ҳ��");
		this.setPreferredSize(new Dimension(485,400));
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,1));
		top.add(lbtitle);
		JPanel top2 = new JPanel();
		top2.setLayout(new GridLayout(1,5));
		top2.add(btnFirst);
		top2.add(btnMater);
		top2.add(btnPrice);
		top2.add(btnType);
		top2.add(btnNum);
		top.add(top2);
		con.add("North", top);
		
		initPanel();
		
		btnFirst.getButton().addActionListener(new myButtonListener());
		btnMater.getButton().addActionListener(new myButtonListener());
		btnPrice.getButton().addActionListener(new myButtonListener());
		btnType.getButton().addActionListener(new myButtonListener());
		btnNum.getButton().addActionListener(new myButtonListener());
	}
	
	class myButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnFirst.getButton()){
				showArea = new PanelDemo("��Ʒ�Ƽ�");
				showArea.setVisible(true);
				con.add("Center",showArea);
				System.out.println("��������");
				initPanel();
			}
		}
		
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}
	
	public static void main(String[] args) {
		new LayerMain();
	}

}
