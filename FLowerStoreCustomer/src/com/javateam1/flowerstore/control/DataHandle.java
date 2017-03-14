package com.javateam1.flowerstore.control;

import javax.swing.JOptionPane;

import com.javateam1.flowerstore.view.LayerManager;

public class DataHandle {
	private TCPClient client;
	
	public void handleData(String str){
		String[] data = str.split(",");
		String type = data[0];
		if(type.equals(DataType.LOGIN)){
			authenticate(data);
		}else if(type.equals(DataType.SIGN)){
			signAccout(data);
		}
	}
	
	private void signAccout(String[] data) {
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "×¢²á³É¹¦");
			LayerManager.hideLayer(DataType.SIGN);
			LayerManager.showLayer(DataType.LOGIN);
		} else{
			JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü");
		}
		
	}

	public void authenticate(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦");
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");
		}
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	
}
