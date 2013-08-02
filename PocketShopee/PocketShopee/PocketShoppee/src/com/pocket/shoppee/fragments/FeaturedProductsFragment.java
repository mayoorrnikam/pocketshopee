package com.pocket.shoppee.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.pocket.shoppee.R;
import com.pocket.shoppee.datamodel.FeaturedProductsModel;
import com.pocket.shoppee.utility.AnimateFirstDisplayListener;

public class FeaturedProductsFragment extends Fragment {

	private FeaturedProductsModel model;
    static DisplayImageOptions options;
	static ImageLoader imageLoader;
	static ImageLoadingListener animateFirstListener;
	
    public static FeaturedProductsFragment newInstance(FeaturedProductsModel model)
    {
    	FeaturedProductsFragment fragment = new FeaturedProductsFragment();

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
       
    	View mainView = inflater.inflate(R.layout.icon, null);
    	TextView txtView = (TextView)mainView.findViewById(R.id.icon_text);
    	txtView.setText(model.getName());
    	
    	TextView txtViewDescription = (TextView)mainView.findViewById(R.id.icon_description);
    	txtViewDescription.setText(model.getDescription());
    	
    	ImageView imageView = (ImageView)mainView.findViewById(R.id.icon_image);
    	imageLoader.displayImage(model.getImageUrl(),imageView, options, animateFirstListener);
    	    	
    	return mainView;
    }   
}
