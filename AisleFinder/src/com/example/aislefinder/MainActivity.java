package com.example.aislefinder;

import java.util.Vector;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	public ShoppingList myList = ShoppingList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Item item1 = new Item("1", "1", "1");
		Item item2 = new Item("2", "2", "2");
		Item item3 = new Item("3", "3", "3");
		Item item4 = new Item("4", "4", "4");
		Item item5 = new Item("5", "5", "5");
		Item item6 = new Item("6", "6", "6");
		Item item7 = new Item("7", "7", "7");
		
		myList.addElement(item1, getApplicationContext());
		myList.addElement(item2, getApplicationContext());
		
		//Buttons that are in the main activity
		Button searchButton = (Button)findViewById(R.id.searchButton);
		Button addButton = (Button)findViewById(R.id.addButton);
		Button clearButton = (Button)findViewById(R.id.clearButton);
		Button showButton = (Button)findViewById(R.id.showButton);
		
		searchButton.setOnClickListener(new View.OnClickListener() 
		{	
			//Listens for the search button. Search function is implemented in here
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(getApplicationContext(), Search.class);
				startActivity(i);
				
				Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
			}
		});
		
		addButton.setOnClickListener(new View.OnClickListener() 
		{	
			//This listener is for the add button
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Add Button", Toast.LENGTH_SHORT).show();
				//myList.addElement(eText.getText().toString(), getApplicationContext());
			}
		});
		
		clearButton.setOnClickListener(new View.OnClickListener() 
		{
			//This listens for the clear button and this button will delete everything in the list
			@Override
			public void onClick(View v) 
			{
				//myList.clearItems();
			}
		});
		
		showButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(getApplicationContext(), Show.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
