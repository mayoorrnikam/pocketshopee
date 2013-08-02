package com.pocket.shoppee.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pocket.shoppee.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
Button favorite, shop, featured, notification, settings;
		
		favorite = (Button)findViewById(R.id.favorite_button);
		//shop = (Button)findViewById(R.id.shop_button);
		//featured = (Button)findViewById(R.id.featured_button);
		notification = (Button)findViewById(R.id.notification_button);
		settings = (Button)findViewById(R.id.settings_button);

		
		featured =(Button)findViewById(R.id.featured_button);
		
		featured.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent featuredIntent = new Intent(MainActivity.this,FeaturedProductsActivity.class);
				//featuredIntent.putExtra(EXTRA_MESSAGE, message);
				startActivity(featuredIntent);
				
			}
		});
		
		shop =(Button)findViewById(R.id.shop_button);
		
		shop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	
					Intent shopIntent = new Intent(MainActivity.this, ShopActivity.class);
					//featuredIntent.putExtra(EXTRA_MESSAGE, message);
					startActivity(shopIntent);

			}
		});

		
		
		
		notification =(Button)findViewById(R.id.notification_button);
		
		notification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
				alertbox.setCancelable(true);
				alertbox.setMessage("Are you sure you want to delete ?");
				System.out.println("Inside 2 OnClickListener()  !!!!");
				
				alertbox.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {

								//Intent shopIntent = new Intent(ShopActivity.this,ShopActivity.class);
								//featuredIntent.putExtra(EXTRA_MESSAGE, message);
								//startActivity(shopIntent);
								System.out.println("Inside Click !!!!");
								Toast.makeText(getApplicationContext(),"Record Deleted...",	Toast.LENGTH_SHORT).show();

							}

						});
				alertbox.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {

							}
						});
				alertbox.show();
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
