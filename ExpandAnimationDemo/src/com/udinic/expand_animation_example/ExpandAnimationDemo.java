package com.udinic.expand_animation_example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by IntelliJ IDEA. User: udic Date: 30/08/11 Time: 00:05 To change
 * this template use File | Settings | File Templates.
 */
public class ExpandAnimationDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // To change body of overridden
											// methods use File | Settings |
											// File Templates.
		setContentView(R.layout.main);

		ListView list = (ListView) findViewById(R.id.udiniList);

		// Creating the list adapter and populating the list
		ArrayAdapter<String> listAdapter = new CustomListAdapter(this,
				R.layout.list_item);
		for (int i = 0; i < 20; i++)
			listAdapter.add("udini" + i);
		list.setAdapter(listAdapter);

		// Creating an item click listener, to open/close our toolbar for each
		// item
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {

				View toolbar = view.findViewById(R.id.toolbar);

				// Creating the expand animation for the item
				ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);

				// Start the animation on the toolbar
				toolbar.startAnimation(expandAni);
			}
		});
	}

	/**
	 * A simple implementation of list adapter.
	 */
	class CustomListAdapter extends ArrayAdapter<String> {

		public CustomListAdapter(Context context, int textViewResourceId) {
			super(context, textViewResourceId);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = getLayoutInflater().inflate(R.layout.list_item,
						null);
			}

			((TextView) convertView.findViewById(R.id.title))
					.setText(getItem(position));

			// Resets the toolbar to be closed
			View toolbar = convertView.findViewById(R.id.toolbar);

			((LinearLayout.LayoutParams) toolbar.getLayoutParams()).bottomMargin = 0 - toolbar
					.getLayoutParams().height;
			toolbar.setVisibility(View.GONE);

			View bt1 = convertView.findViewById(R.id.doSomething1);
			View bt2 = convertView.findViewById(R.id.doSomething2);
			View bt3 = convertView.findViewById(R.id.doSomething3);
			View bt4 = convertView.findViewById(R.id.doSomething4);

			bt1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(ExpandAnimationDemo.this, "aaaaa",
							Toast.LENGTH_SHORT).show();
				}
			});
			bt2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(ExpandAnimationDemo.this, "bbbbb",
							Toast.LENGTH_SHORT).show();
				}
			});
			bt3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(ExpandAnimationDemo.this, "ccccc",
							Toast.LENGTH_SHORT).show();
				}
			});
			bt4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(ExpandAnimationDemo.this, "ddddd",
							Toast.LENGTH_SHORT).show();
				}
			});
			return convertView;
		}
	}
}
