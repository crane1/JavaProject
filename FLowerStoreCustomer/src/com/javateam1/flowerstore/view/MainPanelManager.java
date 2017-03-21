package com.javateam1.flowerstore.view;

import java.util.HashMap;
import java.util.Map;

public class MainPanelManager {
	private LayerDemo layer;
	private Map<String, PanelDemo> panelMap = new HashMap<String, PanelDemo>();
	private String lastShowName = "";
	
	public MainPanelManager(LayerDemo layer){
		this.layer = layer;
	}
	
	public void addPanel(String name, String[] data){
		hidePanel();
		if (panelMap.get(name) != null){
			showPanel(name);
		} else {
			System.out.println("addpanel_____________");
			PanelDemo panel = new PanelDemo(name, data);
			layer.getCon().add("Center",panel);
			panelMap.put(name, panel);
			showPanel(name);
		}
		lastShowName = name;
		
	}
	
	public void showPanel(String name){
		if (name != null && !name.equals("")){
			System.out.println("showpanel________________");
			panelMap.get(name).setVisible(true);
		}
	}
	
	public void hidePanel(){
		if (lastShowName != null && !lastShowName.equals("")){
			panelMap.get(lastShowName).setVisible(false);
		}
		
	}
	
	
}
