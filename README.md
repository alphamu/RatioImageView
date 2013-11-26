RatioImageView
==============

An Android `ImageView` that increases the height of the image view automatically so that the image loaded in it retains it's aspect ratio.
The aspect ratio is calculated depending on the width of the `ImageView` so only the height is adjusted to retain the aspect ratio.

[RatioImageView Demo App is on Google Play Store](http://bit.ly/RatioImageView)

### Use case

You want to load images into a list or grid and want the images to fill up the available space.

You use `ScaleType` only to find that when you images are scaled their ratio is wrong because `android:scaleType="fitXY"` will only the Y dimension will the height of the original image has been reached.
Or conversely it will keep scaling your image in the Y-Axis till it's height is reached even though you don't have the available space in the X-axis to preserve the aspect ratio.

The `RatioImageView` calculate the aspect ratio of your images and sets the height and width of the ImageView depending on the configured aspect ratio of your images.
This allows you to scale up or scale down your images properly.

**Original image too small to fill up space**
![Original images too small](https://raw.github.com/atgheb/RatioImageView/master/screenshot01.png)
<br/><br/><br/>
**Set ScaleType="fitXY" causes images to sretch and lose ratio**
![Images stretched because of gitXY](https://raw.github.com/atgheb/RatioImageView/master/screenshot02.png)
<br/><br/><br/>
**With RationImageView images scaled and aspect ration preserved**
![Images stretched because of gitXY](https://raw.github.com/atgheb/RatioImageView/master/screenshot03.png)

When images are too large or all the images in a List or Grid have different sizes similar issues can come up.

### Usage

**Option 1**
Add `rationimageview-lib` as a library project to your android project 

**Option 2**
Copy `RatioImageView.java` and `attr.xml` to your project.

**Using RatioImageView**

	<?xml version="1.0" encoding="utf-8"?>
	<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:riv="http://schemas.android.com/apk/res/com.alimuzaffar.ratioimageview.demo"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:background="#FFFFFF"
		android:padding="8dp" >

		<com.alimuzaffar.ratioimageview.RatioImageView
			android:id="@+id/image"
			riv:groupId="Optional: because I want all the images in this list to be the same dimensions"
			riv:adjustWidth="true|false"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:layout_gravity="center" />

	</FrameLayout>

`groupId` is used to specify that all the RationImageViews with the same `groupId` should have the same dimension.
The `groupId` can be any string. If you leave out `groupId` then each `RatioImageView` will have its aspect ratio calculated each time.
This can be inefficient especially if used in a `ListView` or `GridView`.

`adjustWidth` if set to true, RatioImageView will attempt to change the width to maintain aspect ratio instead of the height.

All the ratios are calculated and cached so they will not be recalculated even if the images are changed. 
In the future there will be an attribute added that will allow the ImageView to recalculate it's size when the drawable is changed.

