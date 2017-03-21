package com.javateam1.flowerstore.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;

public class LayerManager {
	private static Map<String, LayerDemo>  layers= new HashMap<String, LayerDemo>();
	private static TCPClient client;
	
	public LayerManager(){
		initLayerManager();
	}
	public LayerManager(TCPClient client){
		this.client = client;
		initLayerManager();
	}
	
	public void initLayerManager(){
		addLayer(DataType.LOGIN, new LayerLogin(LayerManager.getClient()));
	}
	
	public static void showLayer(String name){
		LayerDemo layer = (LayerDemo) layers.get(name);
		if (layer != null){
			layer.setVisible(true);
		} else {
			addLayer(name, new LayerMain(LayerManager.getClient()));
		}
		
	}
	
	public static void hideLayer(String name){
		LayerDemo layer = (LayerDemo) layers.get(name);
		layer.setVisible(false);
	}
	
	public static  void addLayer(String name, LayerDemo panel){
		System.out.println("dfds" + LayerManager.client);
		layers.put(name, panel);
		panel.setClient(LayerManager.getClient());
	}
	
	public static LayerDemo getLayer(String name){
		LayerDemo layer = (LayerDemo) layers.get(name);
		return layer;
	}
	

	public static TCPClient getClient() {
		return client;
	}
	public static void setClient(TCPClient client) {
		LayerManager.client = client;
	}
	
	public static void pushData(String data) {
		getClient().pushData(data);
	}
}
