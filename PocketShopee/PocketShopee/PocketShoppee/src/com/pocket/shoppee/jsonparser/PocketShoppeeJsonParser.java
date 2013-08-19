package com.pocket.shoppee.jsonparser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.pocket.shoppee.datamodel.CategoryProductsDataManager;
import com.pocket.shoppee.datamodel.CategoryProductsModel;
import com.pocket.shoppee.datamodel.DataManager;
import com.pocket.shoppee.datamodel.FeaturedProductsModel;
import com.pocket.shoppee.datamodel.ProductDetailsDataManager;
import com.pocket.shoppee.datamodel.ProductDetailsModel;
import com.pocket.shoppee.datamodel.ShopDataManager;
import com.pocket.shoppee.datamodel.ShopModel;
import com.pocket.shoppee.utility.Constants;

public class PocketShoppeeJsonParser {
/* "featuredProductsList": [
            {
                "entity_id": "11967",
        	"type_id": "simple",
        	"sku": "jam1",
        	"name": "T-Shirt Indigo Service",
        	"color": "12",
        	"size": "18",
        	"description": "The ribbed polo neck enhances the attractiveness of the United Colors of Benetton T-Shirt. Be sure to be in the limelight as this regular fit T-shirt comes with a logo embroidery on the chest and has slits on the sides.",
        	"regular_price_with_tax": 154,
        	"regular_price_without_tax": 154,
        	"final_price_with_tax": 154,
        	"final_price_without_tax": 154,
        	"is_saleable": "1",
        	"image_url": "http:\/\/ec2-23-23-50-155.compute-1.amazonaws.com\/awsmage\/media\/catalog\/product\/cache\/0\/image\/9df78eab33525d08d6e5fb8d27136e95\/b\/k\/bk1_2.jpeg",
        	"category_name": [
            		"T-shirt"
        	]
            }*/
	
/*
 {
    "products": {
        "list": [
            {
                "id": "11967",
                "name": "T-Shirt Indigo Service",
                "type": "simple",
                "sku": "jam1",
                "image": "http://ec2-23-23-50-155.compute-1.amazonaws.com/awsmage/media/catalog/product/cache/0/image/9df78eab33525d08d6e5fb8d27136e95/b/k/bk1_2.jpeg",
                "description": "The ribbed polo neck enhances the attractiveness of the United Colors of Benetton T-Shirt. Be sure to be in the limelight as this regular fit T-shirt comes with a logo embroidery on the chest and has slits on the sides.",
                "category": [
                    "T-shirt"
                ],
                "price": 154,
                "color": 12,
                "size": 18
            }*/	
	

	
		
	public void parseFeaturedProductsResponse(String jsonString){
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject jsonObject2 = jsonObject.getJSONObject(Constants.FeaturedProductInfoKey);
		      JSONArray jsonArray = jsonObject2.getJSONArray(Constants.FeaturedProductsListKey);
		      Log.i(PocketShoppeeJsonParser.class.getName(),
		          "Number of entries " + jsonArray.length());
		      ArrayList<FeaturedProductsModel> arrayList = new ArrayList<FeaturedProductsModel>();
		      FeaturedProductsModel model = null;
		      for (int i = 0; i < jsonArray.length(); i++) {
		    	  model = new FeaturedProductsModel();
		    	  JSONObject jsonDataObject = jsonArray.getJSONObject(i);
		    	  model.setColor(jsonDataObject.getString(Constants.ColorKey));
		    	  model.setEntityId(jsonDataObject.getString(Constants.EntityIdKey));
		    	  model.setTypeId(jsonDataObject.getString(Constants.TypeIdKey));
		    	  model.setSku(jsonDataObject.getString(Constants.SkuKey));
		    	  model.setName(jsonDataObject.getString(Constants.NameKey));
		    	  model.setSize(jsonDataObject.getString(Constants.SizeKey));
		    	  model.setDescription(jsonDataObject.getString(Constants.DescriptionKey));
		    	  model.setRegularPriceWithTax(jsonDataObject.getString(Constants.RegularPriceWithTaxKey));
		    	  model.setRegularPriceWithoutTax(jsonDataObject.getString(Constants.RegularPriceWithoutTaxKey));
		    	  model.setFinalPriceWithTax(jsonDataObject.getString(Constants.FinalPriceWithTaxKey));
		    	  model.setFinalPriceWithoutTax(jsonDataObject.getString(Constants.FinalPriceWithoutTaxKey));
		    	  model.setImageUrl(jsonDataObject.getString(Constants.ImageUrlKey));
		    	  if(jsonDataObject.getInt(Constants.IsSaleableKey) == 1)
		    		  model.setSaleable(true);
		    	  else
		    		  model.setSaleable(false);
		    	  JSONArray jsonCategories = jsonDataObject.getJSONArray(Constants.CategoryNameKey);
		    	  ArrayList<String> categoriesArray = new ArrayList<String>();
		    	  for(int j = 0; j < jsonCategories.length() ; j++){
		    		  categoriesArray.add(jsonCategories.getString(j));
		    	  }
		    	  model.setCategoryName(categoriesArray);
		    	  arrayList.add(model);
		    	  arrayList.add(model);
		    	  arrayList.add(model);
		    	  
		    	  Log.i(PocketShoppeeJsonParser.class.getName(), jsonDataObject.getString("entity_id"));
		      }
		      DataManager dataManager = DataManager.getSharedInstance();
		      dataManager.setFeaturedProductsArray(arrayList);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	
	public void parseShopResponse(String jsonString){
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject jsonObject2 = jsonObject.getJSONObject(Constants.ShopCategoryInfoKey);
		      JSONArray jsonArray = jsonObject2.getJSONArray(Constants.ShopCategoryListKey);
		      Log.i(PocketShoppeeJsonParser.class.getName(),
		          "Number of entries " + jsonArray.length());
		      ArrayList<ShopModel> arrayList = new ArrayList<ShopModel>();
		      ShopModel model = null;
		      for (int i = 0; i < jsonArray.length(); i++) {
		    	  model = new ShopModel();
		    	  JSONObject jsonDataObject = jsonArray.getJSONObject(i);
		    	  model.setEntityId(jsonDataObject.getString(Constants.ShopCategoryIdKey));
		    	  model.setName(jsonDataObject.getString(Constants.ShopCategoryNameKey));
		    	  model.setDescription(jsonDataObject.getString(Constants.ShopCategoryDescriptionKey));
		    	  model.setImageUrl(jsonDataObject.getString(Constants.ShopCategoryImageUrlKey));

		    	  arrayList.add(model);
		    	  arrayList.add(model);
		    	  arrayList.add(model);
		    	  
		    	  Log.i(PocketShoppeeJsonParser.class.getName(), jsonDataObject.getString("id"));
		    	  Log.i(PocketShoppeeJsonParser.class.getName(), jsonDataObject.getString("name"));
		      }
		      ShopDataManager dataManager =ShopDataManager.getSharedInstance();
		      dataManager.setShopArray(arrayList);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

	

	public void parseCategoryProductsResponse (String jsonString){
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject jsonObject2 = jsonObject.getJSONObject(Constants.Category_Products_InfoKey);
		      JSONArray jsonArray = jsonObject2.getJSONArray(Constants.CategoryProductsListKey);
		      Log.i(PocketShoppeeJsonParser.class.getName(),
		          "Number of entries " + jsonArray.length());
		      ArrayList<CategoryProductsModel> arrayList = new ArrayList<CategoryProductsModel>();
		      CategoryProductsModel model = null;
		      for (int i = 0; i < jsonArray.length(); i++) {
		    	  model = new CategoryProductsModel();
		    	  JSONObject jsonDataObject = jsonArray.getJSONObject(i);
		    	  model.setColor(jsonDataObject.getString(Constants.CategoryProductsColorKey));
		    	  model.setEntityId(jsonDataObject.getString(Constants.CategoryProductsIdKey));
		    	  model.setType(jsonDataObject.getString(Constants.CategoryProductsTypeKey));
		    	  model.setSku(jsonDataObject.getString(Constants.CategoryProductsSkuKey));
		    	  model.setName(jsonDataObject.getString(Constants.CategoryProductsNameKey));
		    	  model.setSize(jsonDataObject.getString(Constants.CategoryProductsSizeKey));
		    	  model.setDescription(jsonDataObject.getString(Constants.CategoryProductsDescriptionKey));
		    	  model.setPrice(jsonDataObject.getString(Constants.CategoryProductsPriceKey));
		    	  model.setImageUrl(jsonDataObject.getString(Constants.CategoryProductsImageUrlKey));

		    	  JSONArray jsonCategories = jsonDataObject.getJSONArray(Constants.Category_Key);
		    	  ArrayList<String> categoriesArray = new ArrayList<String>();
		    	  for(int j = 0; j < jsonCategories.length() ; j++){
		    		  categoriesArray.add(jsonCategories.getString(j));
		    	  }
		    	  model.setCategoryName(categoriesArray);
		    	  arrayList.add(model);
		    	  
		    	  //Log.i(PocketShoppeeJsonParser.class.getName(), jsonDataObject.getString("CategoryProductsIdKey"));
		      }
		      CategoryProductsDataManager categoryProductsDataManager = CategoryProductsDataManager.getSharedInstance();
		      categoryProductsDataManager.setCategoryProductsArray(arrayList);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
	
	public void parseProductDetailsResponse (String jsonString){
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject jsonObject2 = jsonObject.getJSONObject(Constants.Category_Products_InfoKey);
		      JSONArray jsonArray = jsonObject2.getJSONArray(Constants.CategoryProductsListKey);
		      Log.i(PocketShoppeeJsonParser.class.getName(),
		          "Number of entries " + jsonArray.length());
		      ArrayList<ProductDetailsModel> arrayList = new ArrayList<ProductDetailsModel>();
		      ProductDetailsModel model = null;
		      for (int i = 0; i < jsonArray.length(); i++) {
		    	  model = new ProductDetailsModel();
		    	  JSONObject jsonDataObject = jsonArray.getJSONObject(i);
		    	  model.setColor(jsonDataObject.getString(Constants.CategoryProductsColorKey));
		    	  model.setEntityId(jsonDataObject.getString(Constants.CategoryProductsIdKey));
		    	  model.setType(jsonDataObject.getString(Constants.CategoryProductsTypeKey));
		    	  model.setSku(jsonDataObject.getString(Constants.CategoryProductsSkuKey));
		    	  model.setName(jsonDataObject.getString(Constants.CategoryProductsNameKey));
		    	  model.setSize(jsonDataObject.getString(Constants.CategoryProductsSizeKey));
		    	  model.setDescription(jsonDataObject.getString(Constants.CategoryProductsDescriptionKey));
		    	  model.setPrice(jsonDataObject.getString(Constants.CategoryProductsPriceKey));
		    	  model.setImageUrl(jsonDataObject.getString(Constants.CategoryProductsImageUrlKey));

		    	  JSONArray jsonCategories = jsonDataObject.getJSONArray(Constants.Category_Key);
		    	  ArrayList<String> categoriesArray = new ArrayList<String>();
		    	  for(int j = 0; j < jsonCategories.length() ; j++){
		    		  categoriesArray.add(jsonCategories.getString(j));
		    	  }
		    	  model.setCategoryName(categoriesArray);
		    	  arrayList.add(model);
		    	  
		    	  //Log.i(PocketShoppeeJsonParser.class.getName(), jsonDataObject.getString("CategoryProductsIdKey"));
		      }
		      ProductDetailsDataManager productDetailsDataManager = ProductDetailsDataManager.getSharedInstance();
		      productDetailsDataManager.setProductDetailsArray(arrayList);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
	
}
