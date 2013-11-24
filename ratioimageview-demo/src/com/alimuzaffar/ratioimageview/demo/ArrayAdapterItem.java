package com.alimuzaffar.ratioimageview;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

// here's our beautiful adapter
public class ArrayAdapterItem extends ArrayAdapter<String> {

    Context mContext;
    int layoutResourceId;
    String data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, String[] data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        String resaddr = data[position];

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        
        Drawable d;
		try {
			d = Drawable.createFromStream(mContext.getAssets().open(resaddr), null);
			imageView.setImageDrawable(d);
		} catch (IOException e) {
			Log.e("Adapter", e.getMessage(), e);
		}
        

        return convertView;

    }

}