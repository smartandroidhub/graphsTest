package com.akhil.graphbyakhil;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class DynamicGraphActivity extends Activity {
	LinearLayout dataLayout;
	LinearLayout.LayoutParams topLayoutParams, bottomLayoutParams;
	ArrayList<Integer> valueList, sortedList;
	int max;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph);
		dataLayout = (LinearLayout) findViewById(R.id.data_layout);
		valueList = new ArrayList<Integer>();
		sortedList = new ArrayList<Integer>();
		valueList.add(46);
		valueList.add(127);
		valueList.add(109);
		valueList.add(79);
		valueList.add(63);
		valueList.add(47);
		valueList.add(89);
		valueList.add(100);
		valueList.add(109);
		valueList.add(58);
		valueList.add(85);
		valueList.add(30);

		sortedList = (ArrayList<Integer>) valueList.clone();

		Collections.sort(sortedList);
		System.out.println(sortedList.toString());
		max = sortedList.get(sortedList.size() - 1);
		System.out.println("Max is--->" + max);
		LayoutInflater inflater = getLayoutInflater();
		for (int i = 0; i < valueList.size(); i++) {
			View graphBarView = inflater.inflate(R.layout.graph_item, null);
			float bottomPercentage  = (float) (((float) valueList.get(i) / (float) max) * 100);
			float topPercentage = 100 - bottomPercentage;
			System.out.println("VALUE IS---->" + valueList.get(i));

			Log.e("Top Percentage is---->" + topPercentage,
					"BottomPercentage is---->" + bottomPercentage);
			topLayoutParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.FILL_PARENT, topPercentage);
			bottomLayoutParams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT,
					LinearLayout.LayoutParams.FILL_PARENT, bottomPercentage);
			LinearLayout topLayout = (LinearLayout) graphBarView
					.findViewById(R.id.topLayout);
			LinearLayout bottoLayout = (LinearLayout) graphBarView
					.findViewById(R.id.bottomLayout);
			topLayout.setLayoutParams(bottomLayoutParams);
			bottoLayout.setLayoutParams(topLayoutParams);
			bottoLayout.setBackgroundColor(Color.RED);
			graphBarView.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.FILL_PARENT, 1f));
			dataLayout.addView(graphBarView);
		}
	}
}
