package com.javateam1.flowerstore.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;

public class LayerManager {
	private static Map<String, PanelDemo>  layers= new HashMap<String, PanelDemo>();
	private static TCPClient client;
	
	public LayerManager(){
		initLayerManager();
	}
	public LayerManager(TCPClient client){
		this.client = client;
		initLayerManager();
	}
	
	public void initLayerManager(){
		addLayer(DataType.LOGIN, new PanelLogin());
	}
	
	public static void showLayer(String name){
		PanelDemo panel = (PanelDemo) layers.get(name);
		panel.setVisible(true);
	}
	
	public static void hideLayer(String name){
		PanelDemo panel = (PanelDemo) layers.get(name);
		panel.setVisible(true);
	}
	
	public static  void addLayer(String name, PanelDemo panel){
		System.out.println("dfds" + LayerManager.client);
		layers.put(name, panel);
		panel.setClient(LayerManager.getClient());
	}
	public static TCPClient getClient() {
		return client;
	}
	public static void setClient(TCPClient client) {
		LayerManager.client = client;
	}
}
