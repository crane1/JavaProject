package com.javateam1.flowerstore.control;

import javax.swing.JOptionPane;

public class DataHandle {
	private TCPClient client;
	
	public void handleData(String str){
		String[] data = str.split(",");
		String type = data[0];
		if(type.equals(DataType.LOGIN)){
			authenticate(data);
		}
	}
	
	public void authenticate(String[] data){
		if (data[1].equals("1")){
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
		}else if(data[1].equals("0")){
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
		}
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}

	
}
