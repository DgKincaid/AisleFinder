package com.example.aislefinder;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemZoom extends Activity 
{
	TextView itemName;
	TextView itemLocation;
	Button backButton;
	Button delButton;
	
	ShoppingList myList = ShoppingList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_zoom);
		
		Vector<Item> list = myList.getShoppingList();
		
		itemName = (TextView) findViewById(R.id.textView1);
		itemLocation = (TextView) findViewById(R.id.textView2);
		
		Bundle extras = getIntent().getExtras();
		int value = -1;
		
		if (extras != null)
		{
		    value = extras.getInt("position");
		}
		
		final int delete = value;
		
		itemName.setText(list.elementAt(value).getName());
		itemLocation.setText(list.elementAt(value).getLocation());
		
		backButton = (Button) findViewById(R.id.button1);
		delButton = (Button) findViewById(R.id.button2);
		
		backButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
		
		delButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				myList.delItem(delete);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_zoom, menu);
		return true;
	}

}
