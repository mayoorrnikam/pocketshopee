package com.pocket.shoppee.utility;

public class Constants {

	public static final String BASE_URL = "http://118.139.163.225/";
	
	public static final String FEATURED_PRODUCTS_URL = "pocketmobi/json/featuredProducts.json";
	public static final String SHOP_CATEGORY_URL = "pocketmobi/json/category.json";
	public static final String CATEGORY_PRODUCTS_URL = "pocketmobi/json/products.json";
	
	//featured products constants
	public static final String FeaturedProductInfoKey  = "featuredProductInfo";
	public static final String FeaturedProductsListKey = "featuredProductsList";
	public static final String EntityIdKey = "entity_id";
	public static final String TypeIdKey = "type_id";
	public static final String SkuKey = "sku";
	public static final String NameKey = "name";
	public static final String ColorKey = "color";
	public static final String SizeKey = "size";
	public static final String DescriptionKey = "description";
	public static final String RegularPriceWithTaxKey = "regular_price_with_tax";
	public static final String RegularPriceWithoutTaxKey = "regular_price_without_tax";
	public static final String FinalPriceWithTaxKey = "final_price_with_tax";
	public static final String FinalPriceWithoutTaxKey = "final_price_without_tax";
	public static final String IsSaleableKey = "is_saleable";
	public static final String ImageUrlKey = "image_url";
	public static final String CategoryNameKey = "category_name";
	
	
	//shopCategory products constants
	public static final String ShopCategoryInfoKey  = "categoryInfo";
	public static final String ShopCategoryListKey = "categoryList";
	public static final String ShopCategoryIdKey = "id";
	public static final String ShopCategoryNameKey = "name";
	public static final String ShopCategoryDescriptionKey = "description";
	public static final String ShopCategoryImageUrlKey = "image";

	//Category_Products constants
	//Currently Using the same BASE URL for Category product types and Product Details
	public static final String Category_Products_InfoKey  = "products";
	public static final String CategoryProductsListKey = "list";
	public static final String CategoryProductsIdKey = "id";
	public static final String CategoryProductsNameKey = "name";
	public static final String CategoryProductsTypeKey = "type";
	public static final String CategoryProductsSkuKey = "sku";
	public static final String CategoryProductsPriceKey = "price";
	public static final String CategoryProductsColorKey = "color";
	public static final String CategoryProductsSizeKey = "size";
	public static final String Category_Key = "category";
	public static final String CategoryProductsDescriptionKey = "description";
	public static final String CategoryProductsImageUrlKey = "image";

		
}
