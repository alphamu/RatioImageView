package com.alimuzaffar.ratioimageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * An image view which retains the aspect ratio of the image (makes width match
 * height)
 */
final class RatioImageView extends ImageView {

	static int cachedWidth = 0;
	static int cachedHeight = 0;

	public RatioImageView(Context context) {
		super(context);
	}

	public RatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if (cachedWidth == 0 && cachedHeight == 0) {
			Drawable d = getDrawable();
			if (d != null) {
				float ratio = (float) getMeasuredWidth()
						/ (float) d.getIntrinsicWidth();
				// Log.d(SquaredImageView.class.getSimpleName(),
				// "View Width --> " + getMeasuredWidth());
				// Log.d(SquaredImageView.class.getSimpleName(),
				// "Image Width --> " + d.getIntrinsicWidth());
				int imgHeight = (int) (d.getIntrinsicHeight() * ratio);
				// Log.d(SquaredImageView.class.getSimpleName(),
				// "Ratio --> "+ratio);
				cachedWidth = getMeasuredWidth();
				cachedHeight = imgHeight;
				setMeasuredDimension(cachedWidth, cachedHeight);
			} else {
				// Log.d(SquaredImageView.class.getSimpleName(), "No Drawable");
				setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
			}
		} else {
			setMeasuredDimension(cachedWidth, cachedHeight);
		}
	}
}