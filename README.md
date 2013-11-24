RatioImageView
==============

An Android ImageView that increases the height of the image view automatically so that the image loaded in it retains it's aspect ratio

### Use case

You want to load images into a list or grid and want the images to fill up the available space.

You use ScaleType only to find that when you images are scaled their ratio is wrong because `android:scaleType="fitXY"` will only the Y dimension will the height of the original image has been reached.
Or conversely it will keep scaling your image in the Y-Axis till it's height is reached even though you don't have the available space in the X-axis to preserve the aspect ratio.

The `RatioImageView` calculate the aspect ratio of your images and sets the height and width of the ImageView depending on the configured aspect ratio of your images.
This allows you to scale up or scale down your images properly.

### Original image too small to fill up space
![Original images too small](https://raw.github.com/atgheb/RatioImageView/master/screenshot01.png)

### Set ScaleType="fitXY" causes images to sretch and lose ratio
![Images stretched because of gitXY](https://raw.github.com/atgheb/RatioImageView/master/screenshot02.png)

### With RationImageView images scaled and aspect ration preserved
![Images stretched because of gitXY](https://raw.github.com/atgheb/RatioImageView/master/screenshot03.png)