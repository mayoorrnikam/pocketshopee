package com.pocket.shoppee.activities;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pocket.shoppee.R;
import com.pocket.shoppee.adapters.ShopFragmentAdapter;
import com.pocket.shoppee.datamodel.DataManager;
import com.pocket.shoppee.datamodel.ShopDataManager;
import com.pocket.shoppee.datamodel.ShopModel;
import com.pocket.shoppee.jsonparser.PocketShoppeeJsonParser;
import com.pocket.shoppee.networkmanager.NetworkManager;
import com.pocket.shoppee.utility.DownloadImageTask;
import com.viewpagerindicator.PageIndicator;

public class ShopActivity extends FragmentActivity {

	ProgressDialog progressDialog;

	ShopFragmentAdapter mShopAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;
	private ArrayList<String> textTitleField;
	private ArrayList<String> textDescriptionField;
    private ArrayList<String> imagefield;
    GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		
		setOrientation();
		
		
		gridView=(GridView)findViewById(R.id.GridView01);
		
		/*//library to download image asynchronously. It should be initialized only once in the application.  
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
		ImageLoader.getInstance().init(config);*/
		
		Void params = null;
		new ShopCategoryDownloadTask().execute(params);
		
		Button favorite, shop, featured, notification, settings;
		
		favorite =(Button)findViewById(R.id.favorite_button);
		
		favorite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ShopActivity.this);
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
								Intent featuredIntent = new Intent(ShopActivity.this,FeaturedProductsActivity.class);
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
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ShopActivity.this);
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
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ShopActivity.this);
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
				AlertDialog.Builder alertbox = new AlertDialog.Builder(ShopActivity.this);
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


	class ShopCategoryDownloadTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			progressDialog = ProgressDialog.show(ShopActivity.this,
					"Loading data", "Please wait...");
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
				super.onPostExecute(result);
				PocketShoppeeJsonParser parser = new PocketShoppeeJsonParser();
				parser.parseShopResponse(result);
	
				// update in UI
				ShopDataManager shopDataManager = ShopDataManager.getSharedInstance();
		        
		        textTitleField=new ArrayList<String>();
		        textDescriptionField=new ArrayList<String>();	        
		        imagefield = new ArrayList<String>();
		        
		        int length = shopDataManager.getShopArray().size();
		        mShopAdapter = new ShopFragmentAdapter(ShopActivity.this, textTitleField, textDescriptionField, imagefield);
		    	mShopAdapter.setCount(ShopDataManager.getSharedInstance().getShopArray().size());
		        
		        for(int i = 0; i < length; i++){
		        	Log.i("pocketshoppee", shopDataManager.getShopArray().get(i).getName());
		        	 
		             textTitleField.add(shopDataManager.getShopArray().get(i).getName());
		             textDescriptionField.add(shopDataManager.getShopArray().get(i).getDescription());
		              
		             	String url2="http://softwareshub.net/wp-content/uploads/2013/04/customize-google-background-700x260.jpg";
						String url1 = "http://www.google.com/logos/2013/park_su-geuns_birthday-1055005-hp.jpg";
						String url3 = "http://dummyimage.com/250/ffffff/000000";
						String url4= "http://dummyimage.com/300x300/000/fff.jpg";
						String url5 ="http://ec2-23-23-50-155.compute-1.amazonaws.com/awsmage/media/catalog/product/cache/0/image/9df78eab33525d08d6e5fb8d27136e95/b/k/bk1_2.jpeg";
						String url6 ="http://ec2-23-23-50-155.compute-1.amazonaws.com/awsmage/media/catalog/product/cache/0/image/9df78eab33525d08d6e5fb8d27136e95/b/l/bl1_2.jpeg";
						//String URL3 = "http://www.google.com/logos/2013/anne_cath_vestlys_93rd_birthday-1035005-hp.jpg";

						
						if(i%2 == 0)
							imagefield.add(url5);
						else
							imagefield.add(url6);
		             gridView.setAdapter(mShopAdapter);
		             gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

							Object listItem = gridView.getItemAtPosition(position);
							
							Toast.makeText(ShopActivity.this, "Clicked"+position, Toast.LENGTH_LONG).show();
							Intent catProdIntent = new Intent(ShopActivity.this,CategoryProductsActivity.class);
							startActivity(catProdIntent);
						}
		            	 
					});
		             
		        }
		        
		        progressDialog.dismiss();
	        
			}

		@Override
		protected String doInBackground(Void... params) {
			NetworkManager networkManager = new NetworkManager();
			String jsonString = networkManager.getShopCategory();
			return jsonString;
		}
	}
	
	
	void setOrientation(){
		
		// check if current device is tablet or not.
		boolean isTablet = getResources().getBoolean(R.bool.isTablet);

		Resources res = getResources();

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


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   if (keyCode == KeyEvent.KEYCODE_BACK) {
		        moveTaskToBack(true);
		        Toast.makeText(this, "Current device is Phone ", Toast.LENGTH_SHORT).show();
		        return true;
		    }
		return super.onKeyDown(keyCode, event);
	}
	
}
