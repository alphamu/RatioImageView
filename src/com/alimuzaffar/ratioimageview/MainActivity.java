package com.alimuzaffar.ratioimageview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RadioGroup radios = (RadioGroup) findViewById(R.id.options);
		radios.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.ratio:
					setupGrid(R.layout.grid_item_ratio);
					break;
				case R.id.scale:
					setupGrid(R.layout.grid_item_scale);		
					break;
				default:
					setupGrid(R.layout.grid_item);	
					break;
				}
			}
		});

		setupGrid(R.layout.grid_item);

	}

	private void setupGrid(int layoutResId) {
		ArrayAdapterItem adapter = new ArrayAdapterItem(this,
				layoutResId, new String[] { "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg", "property_1.jpg",
						"property_2.jpg", "property_3.jpg", "property_4.jpg" });

		GridView grid = (GridView) findViewById(R.id.gridview);
		grid.setAdapter(adapter);
		adapter.notifyDataSetChanged();

	}
}
