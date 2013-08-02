package com.pocket.shoppee.datamodel;

import java.util.ArrayList;

public class DataManager {
	
	private static DataManager sharedInstance = null;
	private ArrayList<FeaturedProductsModel> featuredProductsArray;
	
	public static DataManager getSharedInstance(){
		if(sharedInstance == null){
			
			sharedInstance = new DataManager();
		}
		return sharedInstance;
	}
	
	private DataManager(){
		featuredProductsArray = new ArrayList<FeaturedProductsModel>();
	}

	public ArrayList<FeaturedProductsModel> getFeaturedProductsArray(){
		return featuredProductsArray;
	}
	
	public void setFeaturedProductsArray(ArrayList<FeaturedProductsModel> featuredProductsArray){
		this.featuredProductsArray = featuredProductsArray;
	}
}
