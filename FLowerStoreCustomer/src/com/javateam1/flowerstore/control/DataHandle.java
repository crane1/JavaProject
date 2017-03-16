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
			JOptionPane.showMessageDialog(null, "登录成功");
			LayerManager.hideLayer(DataType.LOGIN);
			LayerManager.showLayer(DataType.MAIN);
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "登录失败");
		}
	}
	
	private void signAccout(String[] data) {
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "注册成功");
			LayerManager.hideLayer(DataType.SIGN);
			LayerManager.showLayer(DataType.LOGIN);
		} else{
			JOptionPane.showMessageDialog(null, "注册失败");
		}
	}
	
	private void getFlowerInfo(String[] data) {
		LayerMain layer = (LayerMain) LayerManager.getLayer(DataType.MAIN);
		if(data[1].equals(DataType.FIRST)){
			layer.getPanelManager().addPanel("精品推荐", data);
		}else if(data[1].equals(DataType.MATER)){
			layer.getPanelManager().addPanel("花材", data);
		}else if(data[1].equals(DataType.PRICE)){
			layer.getPanelManager().addPanel("价格", data);
		}else if(data[1].equals(DataType.TYPE)){
			layer.getPanelManager().addPanel("类型", data);
		}else if(data[1].equals(DataType.NUMBER)){
			layer.getPanelManager().addPanel("支数", data);
		}
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	
}
