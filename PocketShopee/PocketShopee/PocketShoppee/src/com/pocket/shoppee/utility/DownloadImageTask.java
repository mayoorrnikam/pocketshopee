package com.pocket.shoppee.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DownloadImageTask extends AsyncTask<ImageView, Void, Bitmap> {

    ImageView imageView = null;

    @Override
    protected Bitmap doInBackground(ImageView... imageViews) {
        this.imageView = imageViews[0];
        Bitmap bmp = download_Image((String)imageView.getTag()); 
        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }

    private Bitmap download_Image(String url) {

    	//System.out.println("Inside the download_image !!!");
        Bitmap bmp =null;
        try{
            URL ulrn = new URL(url);
            HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
            InputStream is = con.getInputStream();
            bmp = BitmapFactory.decodeStream(is);
            if (null != bmp)
            {
            	//System.out.println("Image is not null !!!");
            	// saveBitmap(bmp);
            	return bmp;
            }
          
            }catch(Exception e){
            	e.printStackTrace();
            }
        return bmp;
    }
    
  
    
    public void saveBitmap(Bitmap bmp)
    {
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NewFolder";
        
        System.out.println("Filepath : "+ file_path);
            File dir = new File(file_path);
            if(!dir.exists())
               dir.mkdirs();
            File file = new File(dir, "myImage.png");
		try {

			FileOutputStream fOut = new FileOutputStream(file);

			bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
			fOut.flush();
			fOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}