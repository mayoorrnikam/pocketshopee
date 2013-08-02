package com.pocket.shoppee.fragments;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.pocket.shoppee.R;
import com.pocket.shoppee.datamodel.ShopModel;
import com.pocket.shoppee.utility.AnimateFirstDisplayListener;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopFragment extends Fragment {

	private ShopModel model;
    static DisplayImageOptions options;
	static ImageLoader imageLoader;
	static ImageLoadingListener animateFirstListener;
	
    public static ShopFragment newInstance(ShopModel model)
    {
    	ShopFragment fragment = new ShopFragment();

    	fragment.model = model;
        
    	imageLoader = ImageLoader.getInstance();//from library
		
    	//for caching images
        options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(20)).build();
		
		animateFirstListener = new AnimateFirstDisplayListener();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       
    	View mainView = inflater.inflate(R.layout.shop_category, null);
    	TextView txtView = (TextView)mainView.findViewById(R.id.icon_text);
    	txtView.setText(model.getName());
    	
    	TextView txtViewDescription = (TextView)mainView.findViewById(R.id.icon_description);
    	txtViewDescription.setText(model.getDescription());
    	
    	ImageView imageView = (ImageView)mainView.findViewById(R.id.icon_image);
    	
    	//String url="http://softwareshub.net/wp-content/uploads/2013/04/customize-google-background-700x260.jpg";
		String url= "http://www.google.com/logos/2013/estonia_independence_day_2013-1057005.3-hp.jpg";
		//String url = "http://www.google.com/logos/2013/park_su-geuns_birthday-1055005-hp.jpg";
		
		
		if(model.getImageUrl().isEmpty())
    	{
    		Log.i("Info", "URL is Empty !!!");
    		imageLoader.displayImage(url,imageView, options, animateFirstListener);
    	}
    	else
    	{
    		imageLoader.displayImage(model.getImageUrl(),imageView, options, animateFirstListener);
    	}
    	
    	    	
    	return mainView;
    } 
}
