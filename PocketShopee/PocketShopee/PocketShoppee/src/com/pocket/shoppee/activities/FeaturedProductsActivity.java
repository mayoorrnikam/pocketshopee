package com.pocket.shoppee.activities;

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
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pocket.shoppee.R;
import com.pocket.shoppee.adapters.FeaturedFragmentAdapter;
import com.pocket.shoppee.datamodel.DataManager;
import com.pocket.shoppee.jsonparser.PocketShoppeeJsonParser;
import com.pocket.shoppee.networkmanager.NetworkManager;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class FeaturedProductsActivity extends FragmentActivity {

	ProgressDialog progressDialog;

	FeaturedFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_featured);
		
		setOrientation();
		
		//library to download image asynchronously. It should be initialized only once in the application.  
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
		ImageLoader.getInstance().init(config);
		
		Void params = null;
		new FeaturedProductDownloadTask().execute(params);
		
		Button favorite, shop, featured, notification, settings;
		
		favorite =(Button)findViewById(R.id.favorite_button);
		
		favorite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(FeaturedProductsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("OK",new DialogInterface.OnClickListener() {

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
				
				AlertDialog.Builder alertbox = new AlertDialog.Builder(FeaturedProductsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("Currently you are on same \"Featured\" page....");
				alertbox.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
							}
						});
				alertbox.show();
			}
		});
		
		shop =(Button)findViewById(R.id.shop_button);
		
		shop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/*AlertDialog.Builder alertbox = new AlertDialog.Builder(FeaturedProductsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("Are you sure you want to navigate to other page ?");
				
				alertbox.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {

				 	*/
								Intent shopIntent = new Intent(FeaturedProductsActivity.this,ShopActivity.class);
								startActivity(shopIntent);

					/*		}

						});
				alertbox.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {

							}
						});

				alertbox.show();
				*/
			}
		});
		
		
		
		notification =(Button)findViewById(R.id.notification_button);
		
		notification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					/*Intent shopIntent = new Intent(ShopActivity.this,MainActivity.class);
					startActivity(shopIntent);*/
				AlertDialog.Builder alertbox = new AlertDialog.Builder(FeaturedProductsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("OK",new DialogInterface.OnClickListener() {

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
				AlertDialog.Builder alertbox = new AlertDialog.Builder(FeaturedProductsActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("This feature is Coming Soon...");
				
				alertbox.setPositiveButton("ok",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {

							}

						});
				alertbox.show();


			}
		});

	}

	class FeaturedProductDownloadTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			progressDialog = ProgressDialog.show(FeaturedProductsActivity.this,
					"Loading data", "Please wait...");
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			PocketShoppeeJsonParser parser = new PocketShoppeeJsonParser();
			parser.parseFeaturedProductsResponse(result);

			// update in UI
			//adapter for pageview
			mAdapter = new FeaturedFragmentAdapter(getSupportFragmentManager());
			
			mAdapter.setCount(DataManager.getSharedInstance().getFeaturedProductsArray().size());
			mPager = (ViewPager) findViewById(R.id.pager);
			mPager.setAdapter(mAdapter);

			mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
			mIndicator.setViewPager(mPager);

			progressDialog.dismiss();

		}

		@Override
		protected String doInBackground(Void... params) {
			NetworkManager networkManager = new NetworkManager();
			String jsonString = networkManager.getFeaturedProducts();
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
