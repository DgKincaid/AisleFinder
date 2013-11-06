package com.example.aislefinder;

import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Show extends Activity {

	Button backButton;
	Button showButton;
	Button delButton;
	
	ShoppingList myList = ShoppingList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		backButton = (Button) findViewById(R.id.button1);
		showButton = (Button) findViewById(R.id.button2);
		delButton = (Button) findViewById(R.id.button3);
		
		final Vector<Item> list = myList.getShoppingList();
		
		backButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "BackButton", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		
		showButton.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Show Button", Toast.LENGTH_SHORT).show();
				
				Toast.makeText(getApplicationContext(), "Item1:	" + list.elementAt(0).getName(), Toast.LENGTH_SHORT).show();
			}
		});
		
		delButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Delete Button", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

}
