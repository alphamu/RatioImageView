package com.alimuzaffar.ratioimageview;

import java.util.HashMap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * An image view which retains the aspect ratio of the image (makes width match
 * height)
 */
final class RatioImageView extends ImageView {

	private static HashMap<String, DimenPair> mDimenCache = new HashMap<String, DimenPair>();
	
	private String groupId = null;
	private boolean adjustWidth = false;
	
	int cachedWidth = 0;
	int cachedHeight = 0;

	public RatioImageView(Context context) {
		super(context);
	}

	public RatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a = context.obtainStyledAttributes(attrs,
			    R.styleable.RatioImageView);
			 
			final int N = a.getIndexCount();
			for (int i = 0; i < N; ++i)
			{
			    int attr = a.getIndex(i);
			    switch (attr)
			    {
			        case R.styleable.RatioImageView_groupId:
			            groupId = a.getString(attr);
			            break;
			        case R.styleable.RatioImageView_adjustWidth:
			        	adjustWidth = a.getBoolean(attr, adjustWidth);
			        	break;
			    }
			}
			a.recycle();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		if (cachedWidth == 0 && cachedHeight == 0 && groupId != null) {
			if(mDimenCache.containsKey(groupId)) {
				Log.d("RatioImageView", "Using Group Cache. Group Id="+groupId);
				DimenPair pair = mDimenCache.get(groupId);
				cachedWidth = pair.width;
				cachedHeight = pair.height;
				setMeasuredDimension(cachedWidth, cachedHeight);
				return;
			}
		} 
		
		if (cachedWidth > 0 && cachedHeight > 0) {
			Log.d("RatioImageView", "Using Cache. Group Id="+groupId);
			setMeasuredDimension(cachedWidth, cachedHeight);
			return;
		}
		
		Drawable d = getDrawable();
		if (d != null) {
			Log.d("RatioImageView", "Setting size. Group Id="+groupId);
			float ratio = (float) getMeasuredWidth() / (float) d.getIntrinsicWidth();
			int imgHeight = (int) (d.getIntrinsicHeight() * ratio);
			int imgWidth = (int) (d.getIntrinsicWidth() * ratio);
			if(adjustWidth) {
				cachedWidth = imgWidth;
				cachedHeight = getMeasuredHeight();
			} else {
				cachedWidth = getMeasuredWidth();
				cachedHeight = imgHeight;
			}
			setMeasuredDimension(cachedWidth, cachedHeight);
				
			if(groupId != null) {
				addToCache();
			}
		} else {
			setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
		}
	}
	
	private void addToCache() {
		mDimenCache.put(groupId, new DimenPair(cachedWidth, cachedHeight));
	}
	
	/***
	 * Change the groupId for this image view. This will trigger recalculation of dimensions.
	 * 
	 * @param groupId String any string or null.
	 */
	public void setGroupId(String groupId) {
		if(groupId != null) {
			mDimenCache.remove(groupId);
		}
		this.groupId = groupId;
		cachedWidth = 0;
		cachedHeight = 0;
	}
	
	/***
	 * Default: false. If set to true, we will adjust the width to maintain aspect ration instead of the height.
	 * 
	 * @param adjustWidth
	 */
	public void setAdjustWidth(boolean adjustWidth) {
		this.adjustWidth = adjustWidth;
		cachedWidth = 0;
		cachedHeight = 0;
		if(groupId != null) {
			mDimenCache.remove(groupId);
		}
	}
	
	private class DimenPair {
		public DimenPair(int w, int h) {
			this.width = w;
			this.height = h;
		}
		int width;
		int height;
	}
}