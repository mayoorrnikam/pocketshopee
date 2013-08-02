package com.pocket.shoppee.datamodel;

import java.util.ArrayList;

public class CategoryProductsDataManager {
	
	private static CategoryProductsDataManager sharedInstance = null;
	private ArrayList<CategoryProductsModel> categoryProductsArray;
	
	public static CategoryProductsDataManager getSharedInstance(){
		if(sharedInstance == null){
			
			sharedInstance = new CategoryProductsDataManager();
		}
		return sharedInstance;
	}
	
	private CategoryProductsDataManager(){
		categoryProductsArray = new ArrayList<CategoryProductsModel>();
	}

	public ArrayList<CategoryProductsModel> getCategoryProductsArray(){
		return categoryProductsArray;
	}
	
	public void setCategoryProductsArray(ArrayList<CategoryProductsModel> categoryProductsArray){
		this.categoryProductsArray = categoryProductsArray;
	}

}