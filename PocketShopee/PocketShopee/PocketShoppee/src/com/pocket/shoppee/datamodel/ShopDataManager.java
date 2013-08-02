package com.pocket.shoppee.datamodel;

import java.util.ArrayList;

public class ShopDataManager {
	
	private static ShopDataManager sharedInstance = null;
	private ArrayList<ShopModel> shopArray;
	
	public static ShopDataManager getSharedInstance(){
		if(sharedInstance == null){
			
			sharedInstance = new ShopDataManager();
		}
		return sharedInstance;
	}
	
	private ShopDataManager(){
		shopArray = new ArrayList<ShopModel>();
	}

	public ArrayList<ShopModel> getShopArray(){
		return shopArray;
	}
	
	public void setShopArray(ArrayList<ShopModel> shopArray){
		this.shopArray = shopArray;
	}

}
