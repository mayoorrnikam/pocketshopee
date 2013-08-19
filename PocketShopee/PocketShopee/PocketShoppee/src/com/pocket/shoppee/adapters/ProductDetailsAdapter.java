package com.pocket.shoppee.adapters;

import java.util.ArrayList;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.pocket.shoppee.R;
import com.pocket.shoppee.activities.ProductDetailsActivity;
import com.pocket.shoppee.utility.DownloadImageTask;

public class ProductDetailsAdapter extends BaseAdapter  {

	private int mCount = 0;
	Context mContext;
	private ArrayList<String> textTitleField;
	private ArrayList<String> textDescriptionField;
    private ArrayList<String> imagefield;
    
	public static final int ACTIVITY_CREATE = 10;
	
	public ProductDetailsAdapter(Context c, ArrayList<String> textTitleField, ArrayList<String> textDescriptionField, 
    ArrayList<String> imagefield){
		mContext = c;
		this.textTitleField= textTitleField;
		this.textDescriptionField = textDescriptionField;
	    this.imagefield = imagefield;
	    	
	}
	@Override
	public int getCount() {
		//return textTitleField.size();
		return mCount;
	}

	public void setCount(int count) {
		mCount = count;
		notifyDataSetChanged();
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v;
		if(convertView==null){
			LayoutInflater li = LayoutInflater.from(mContext);
			v = li.inflate(R.layout.activity_product_details, null);
			
			ImageView iv = (ImageView)v.findViewById(R.id.product_big_box);
			iv.setTag(imagefield.get(position));
			new DownloadImageTask().execute(iv);
			
			System.out.println("Inside the Product Details Adapter !!!");
			
			TextView tv = (TextView)v.findViewById(R.id.icon_text);
			tv.setText(textTitleField.get(position));
			
			TextView tvdescription = (TextView)v.findViewById(R.id.icon_description);
			String descriptionMsg = textDescriptionField.get(position) +"\n";
			
			//tvdescription.setText(textDescriptionField.get(position));
			tvdescription.setText(descriptionMsg);
			//tvdescription.setEllipsize(TruncateAt.END);
			//tvdescription.setLines(3);
			
		}
		else
		{
			v = convertView;
		}
		return v;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
