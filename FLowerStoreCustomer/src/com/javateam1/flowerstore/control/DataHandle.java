package com.javateam1.flowerstore.control;

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
		}
	}
	
	private void authenticate(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			LayerManager.hideLayer(DataType.LOGIN);
			LayerManager.showLayer(DataType.MAIN);
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
			layer.getPanelManager().addPanel("����", data);
		}else if(data[1].equals(DataType.PRICE)){
			layer.getPanelManager().addPanel("�۸�", data);
		}else if(data[1].equals(DataType.TYPE)){
			layer.getPanelManager().addPanel("����", data);
		}else if(data[1].equals(DataType.NUMBER)){
			layer.getPanelManager().addPanel("֧��", data);
		}
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	
}
