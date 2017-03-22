package com.javateam1.flowerstore.control;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.javateam1.flowerstore.view.*;

public class DataHandle {
	private TCPClient client;
	
	public void handleData(String str){
		String[] data = str.split(",");
		String type = data[0];
		if(type.equals(DataType.LOGIN)){
			authenticate(data);
		}else if(type.equals(DataType.SIGN)){
			signAccout(data);
		}else if(type.equals(DataType.MAIN)){
			getFlowerInfo(data);
		}else if(type.equals(DataType.ADD_SHOP)){
			addShoppingCart(data);
		}else if(type.equals(DataType.VIEW_SHOP)){
			System.out.println(type);
			viewShoppingCart(data);
		}else if(type.equals(DataType.PAY)){
			System.out.println(type);
			payOrder(data);
		}
	}
	
	private void authenticate(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			LayerManager.hideLayer(DataType.LOGIN);
			LayerMain layer = (LayerMain)LayerManager.showLayer(DataType.MAIN);
			layer.getLbAccount().getLabel().setText(data[2]);
			layer.getLbAccount().setTextColor(Color.blue);
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
		}
	}
	
	private void signAccout(String[] data) {
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "ע��ɹ�");
			LayerManager.hideLayer(DataType.SIGN);
			LayerManager.showLayer(DataType.LOGIN);
		} else{
			JOptionPane.showMessageDialog(null, "ע��ʧ��");
		}
	}
	
	private void getFlowerInfo(String[] data) {
		LayerMain layer = (LayerMain) LayerManager.getLayer(DataType.MAIN);
		if(data[1].equals(DataType.FIRST)){
			layer.getPanelManager().addPanel("��Ʒ�Ƽ�", data);
		}else if(data[1].equals(DataType.MATER)){
			layer.getPanelManager().addPanel(data[2], data);
		}else if(data[1].equals(DataType.PRICE)){
			layer.getPanelManager().addPanel(data[2]+"Ԫ", data);
		}else if(data[1].equals(DataType.TYPE)){
			layer.getPanelManager().addPanel(data[2], data);
		}else if(data[1].equals(DataType.NUMBER)){
			layer.getPanelManager().addPanel(data[2]+"֧", data);
		}
		// ����ɼ��غ��ҳ�����ˢ��
		layer.initPanel();
	}
	
	private void addShoppingCart(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "��ӹ��ﳵ�ɹ�");
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "��ӹ��ﳵʧ��");
		}
	}
	
	private void viewShoppingCart(String[] data){
		LayerShoppingCart cart = (LayerShoppingCart) LayerManager.showLayer(DataType.VIEW_SHOP);
		cart.addFlowerInfoList(data);
		LayerManager.showLayer(DataType.VIEW_SHOP);
	}
	
	private void payOrder(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "֧���ɹ�");
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "֧��ʧ��");
		}
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	
}
