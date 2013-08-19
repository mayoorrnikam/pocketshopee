package com.pocket.shoppee.datamodel;

import java.util.ArrayList;

public class ProductDetailsDataManager {
	
	private static ProductDetailsDataManager sharedInstance = null;
	private ArrayList<ProductDetailsModel> productDetailsArray;
	
	public static ProductDetailsDataManager getSharedInstance(){
		if(sharedInstance == null){
			
			sharedInstance = new ProductDetailsDataManager();
		}
		return sharedInstance;
	}
	
	private ProductDetailsDataManager(){
		productDetailsArray = new ArrayList<ProductDetailsModel>();
	}

	public ArrayList<ProductDetailsModel> getProductDetailsArray(){
		return productDetailsArray;
	}
	
	public void setProductDetailsArray(ArrayList<ProductDetailsModel> productDetailsArray){
		this.productDetailsArray = productDetailsArray;
	}

}