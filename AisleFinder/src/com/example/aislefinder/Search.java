package com.example.aislefinder;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Search extends Activity 
{

	private Button backButton;
	private Button addButton;
	private Vector<Item> myList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		//myList = ShoppingList.getShoppingList();
		
		backButton = (Button) findViewById(R.id.backSButton);
		addButton = (Button) findViewById(R.id.addSButton);
		
		//Toast.makeText(getApplicationContext(), "Item1	" + myList.indexOf(1), Toast.LENGTH_SHORT).show();
		
		addButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Add Button Clicked", Toast.LENGTH_SHORT).show();
			}
		});
		
		backButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
