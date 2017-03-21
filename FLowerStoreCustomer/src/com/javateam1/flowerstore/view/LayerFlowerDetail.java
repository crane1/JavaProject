package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

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

public class LayerFlowerDetail{
//	list.add(f.getId());
//	list.add(f.getName());
//	list.add(String.valueOf(f.getPrice()));
//	list.add(f.getMaterials());
//	list.add(f.getPackages());
//	list.add(String.valueOf(f.getNum()));
//	list.add(f.getType());
//	list.add(f.getFlowerWord());
	private static JFrame panel = new JFrame();
	private static Container con = panel.getContentPane();
	private static JLabel pic = new JLabel();
	private static MyLabel name = new MyLabel("������",new Font("����", Font.BOLD, 12));
	private static MyLabel price = new MyLabel("�۸�",new Font("����", Font.BOLD, 12));
	private static MyLabel materials = new MyLabel("���ģ�",new Font("����", Font.BOLD, 12));
	private static MyLabel Packages = new MyLabel("��װ��",new Font("����", Font.BOLD, 12));
	private static MyLabel nums = new MyLabel("������",new Font("����", Font.BOLD, 12));
	private static MyLabel type = new MyLabel("���ͣ�",new Font("����", Font.BOLD, 12));
	private static MyLabel flowerWord = new MyLabel("���",new Font("����", Font.BOLD, 12));
	private static int isshow = 0;
	public LayerFlowerDetail(){
		con.setBackground(Color.white);
		
		
	}
	
	public static void initPanel(){
		panel.pack();
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
		panel.addWindowListener(new WindowAdapter(){
			public void windowclosingn(WindowEvent w){
//				panel.setVisible(false);
				System.out.println("�ر�");
			}
		});
	}
	
	public static void showFlowerInfo(String[] data){
		if (isshow == 0){
			con.add("West", pic);
			JPanel left = new JPanel();
			left.setLayout(new GridLayout(7,1));
			left.add(name);
			left.add(price);
			left.add(materials);
			left.add(Packages);
			left.add(nums);
			left.add(type);
			left.add(flowerWord);
			con.add(left);
			isshow = 1;
		}
		pic.setIcon(new ImageIcon("img/"+ data[0] +".jpg"));
		
		name.getLabel().setText("������" + data[1]);
		price.getLabel().setText("�۸�" + data[2]);
		materials.getLabel().setText("���ģ�" + data[3]);
		Packages.getLabel().setText("��װ��" + data[4]);
		nums.getLabel().setText("֧����" + data[5]);
		type.getLabel().setText("���ͣ�" + data[6]);
		flowerWord.getLabel().setText("���" + data[7]);
		
		
		initPanel();
	}
}
