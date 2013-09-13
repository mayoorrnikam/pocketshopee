package com.pocket.shoppee.activities;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pocket.shoppee.R;
import com.pocket.shoppee.adapters.ProductDetailsAdapter;
import com.pocket.shoppee.adapters.ShopFragmentAdapter;
import com.pocket.shoppee.datamodel.CategoryProductsDataManager;
import com.pocket.shoppee.datamodel.ProductDetailsDataManager;
import com.pocket.shoppee.jsonparser.PocketShoppeeJsonParser;
import com.pocket.shoppee.networkmanager.NetworkManager;
import com.pocket.shoppee.utility.DownloadImageTask;
import com.viewpagerindicator.PageIndicator;

public class ProductDetailsActivity extends FragmentActivity {

	ProgressDialog progressDialog;

	ProductDetailsAdapter mShopAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;
	private ArrayList<String> textTitleField;
	private ArrayList<String> textDescriptionField;
    private ArrayList<String> imagefield;
    private String colorValue;
    private String sizeValue;
    private String priceValue;
    private String discountPriceValue;
    RelativeLayout relativeLaout;
    //GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_details);
		
		setOrientation();
		
		
		//gridView=(GridView)findViewById(R.id.GridView01);
		
		/*//library to download image asynchronously. It should be initialized only once in the application.  
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
		ImageLoader.getInstance().init(config);*/
		
		Button backButton =(Button)findViewById(R.id.backbutton);
		
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(ProductDetailsActivity.this, "Back Clicked", Toast.LENGTH_LONG).show();
				finish();
			}
		});
		
		Void params = null;
		new ProductDetailsDownloadTask().execute(params);
		
		//Bottom buttons
		Button favorite, shop, featured, notification, settings;
		
		favorite =(Button)findViewById(R.id.favorite_button);
		
		favorite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ProductDetailsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {

							}

						});
				alertbox.show();

			}
		});

		
		featured =(Button)findViewById(R.id.featured_button);
		
		featured.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/*AlertDialog.Builder alertbox = new AlertDialog.Builder(ShopActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("Are you sure you want to navigate to other page ?");
				
				alertbox.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {
				 */
				
								Intent featuredIntent = new Intent(ProductDetailsActivity.this,FeaturedProductsActivity.class);
								startActivity(featuredIntent);


				/*			}

						});
				alertbox.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {

							}
						});

				alertbox.show();
				 */
			}
		});
		
		shop =(Button)findViewById(R.id.shop_button);
		
		shop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ProductDetailsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("Currently you are on same \"Shop\" Shop page...");
				alertbox.setPositiveButton("OK",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {
							}
						});
				alertbox.show();
			}
		});
		
		
		
		notification =(Button)findViewById(R.id.notification_button);
		
		notification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ProductDetailsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {
					

							}

						});
				alertbox.show();


			}
		});

		settings =(Button)findViewById(R.id.settings_button);
		
		settings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ProductDetailsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {

							}

						});
				alertbox.show();


			}
		});

		
	}


	class ProductDetailsDownloadTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			progressDialog = ProgressDialog.show(ProductDetailsActivity.this,"Loading data", "Please wait...");
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
				super.onPostExecute(result);
				PocketShoppeeJsonParser parser = new PocketShoppeeJsonParser();
				parser.parseProductDetailsResponse(result);
	
				// update in UI
				//ShopDataManager shopDataManager = ShopDataManager.getSharedInstance();
				//CategoryProductsDataManager categoryProductsDataManager = CategoryProductsDataManager.getSharedInstance();
				ProductDetailsDataManager productDetailsDataManager = ProductDetailsDataManager.getSharedInstance();
		        
		        textTitleField=new ArrayList<String>();
		        textDescriptionField=new ArrayList<String>();	        
		        imagefield = new ArrayList<String>();
		        
		        int length = productDetailsDataManager.getProductDetailsArray().size();
		        System.out.println("Length:"+ length );
		        
		        mShopAdapter = new ProductDetailsAdapter(ProductDetailsActivity.this, textTitleField, textDescriptionField, imagefield);
		    	mShopAdapter.setCount(CategoryProductsDataManager.getSharedInstance().getCategoryProductsArray().size());
		        
		    	System.out.println("mShopAdapter count:"+ mShopAdapter.getCount());
		    	
		       // for(int i = 0; i < length; i++){
		        	Log.i("pocketshoppee", productDetailsDataManager.getProductDetailsArray().get(0).getName());
		        	 
		             textTitleField.add(productDetailsDataManager.getProductDetailsArray().get(0).getName());
		             textDescriptionField.add(productDetailsDataManager.getProductDetailsArray().get(0).getDescription());
		              
		             colorValue = productDetailsDataManager.getProductDetailsArray().get(0).getColor();
		             sizeValue = productDetailsDataManager.getProductDetailsArray().get(0).getSize();

		             priceValue = productDetailsDataManager.getProductDetailsArray().get(0).getPrice();
		             discountPriceValue = productDetailsDataManager.getProductDetailsArray().get(0).getPrice();
		             
		             	String ur2="http://softwareshub.net/wp-content/uploads/2013/04/customize-google-background-700x260.jpg";
						String ur5 = "http://www.google.com/logos/2013/park_su-geuns_birthday-1055005-hp.jpg";
						
						String url1 ="http://ec2-23-23-50-155.compute-1.amazonaws.com/awsmage/media/catalog/product/cache/0/image/9df78eab33525d08d6e5fb8d27136e95/b/k/bk1_2.jpeg";
						//String URL3 = "http://www.google.com/logos/2013/anne_cath_vestlys_93rd_birthday-1035005-hp.jpg";

						
						
							imagefield.add(url1);
						
							ImageView iv = (ImageView)findViewById(R.id.thumbsmall1);
							iv.setTag(imagefield.get(0));
							new DownloadImageTask().execute(iv);
							
							ImageView thumb1 = (ImageView)findViewById(R.id.thumbsmall2);
							thumb1.setTag(imagefield.get(0));
							new DownloadImageTask().execute(thumb1);
							
							
							ImageView thumb2 = (ImageView)findViewById(R.id.thumbsmall3);
							thumb2.setTag(imagefield.get(0));
							new DownloadImageTask().execute(thumb2);
							
							
							ImageView thumb3 = (ImageView)findViewById(R.id.product_big_box);
							thumb3.setTag(imagefield.get(0));
							new DownloadImageTask().execute(thumb3);
							
							TextView tv = (TextView)findViewById(R.id.icon_text);
							tv.setText(textTitleField.get(0));
							
							TextView tvdescription = (TextView)findViewById(R.id.icon_description);
							String descriptionMsg = textDescriptionField.get(0) +"\n";
							
							tvdescription.setText(descriptionMsg);
							//tvdescription.setEllipsize(TruncateAt.END);
							//tvdescription.setLines(3);
							
							TextView tvColor = (TextView)findViewById(R.id.icon_color);
							tvColor.setText(colorValue);
							
							TextView tvSize = (TextView)findViewById(R.id.icon_size);
							tvSize.setText(sizeValue);
							
							TextView tvPrice = (TextView)findViewById(R.id.icon_price1);
							tvPrice.setText(priceValue);
							
							TextView tvDiscountPrice = (TextView)findViewById(R.id.icon_price2);
							tvDiscountPrice.setText(discountPriceValue);
							
		             
		        //}
		        
		        progressDialog.dismiss();
	        
			}
		

		@Override
		protected String doInBackground(Void... params) {
			NetworkManager networkManager = new NetworkManager();
			String jsonString = networkManager.getCategoryProducts();
			return jsonString;
		}
	}
	
	
	void setOrientation(){
		
		// check if current device is tablet or not.
		boolean isTablet = getResources().getBoolean(R.bool.isTablet);

		Resources res = getResources();

		int ot = getResources().getConfiguration().orientation;
		if(Configuration.ORIENTATION_PORTRAIT == ot)
		{
			isTablet = false;
		}
		
		// get the default font size of the device.
		float fontSize = res.getDimension(R.dimen.font_size);

		if (isTablet) {

			Toast.makeText(this, "Current device is Tablet " + fontSize,
					Toast.LENGTH_SHORT).show();
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		} else {

			Toast.makeText(this, "Current device is Phone " + fontSize,
					Toast.LENGTH_SHORT).show();
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		}
	}
	
}

