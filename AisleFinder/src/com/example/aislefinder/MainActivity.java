package com.example.aislefinder;

import java.util.Vector;

import android.support.v4.app.FragmentActivity;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity 
{

	public ShoppingList myList = ShoppingList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Buttons that are in the main activity
		Button searchButton = (Button)findViewById(R.id.searchButton);
		Button addButton = (Button)findViewById(R.id.addButton);
		Button clearButton = (Button)findViewById(R.id.clearButton);
		Button showButton = (Button)findViewById(R.id.showButton);
		final FireBase base = new FireBase();
		
		final EditText eText = (EditText) findViewById(R.id.editText1);
		
		searchButton.setOnClickListener(new View.OnClickListener() 
		{	
			//Listens for the search button. Search function is implemented in here
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(getApplicationContext(), Search.class);
				FireBase base= new FireBase();
				final Item item = base.getData(getApplicationContext(),  eText.getText().toString());
				myList.addItem(item);
				
				startActivity(i);
				
				Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
				
				eText.setText("");
			}
		});
		
		addButton.setOnClickListener(new View.OnClickListener() 
		{	
			//This listener is for the add button
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Add Button", Toast.LENGTH_SHORT).show();
				
				Item temp = base.getData(getApplicationContext(),eText.getText().toString());
				
				myList.addElement(temp, getApplicationContext());
			}
		});
		
		clearButton.setOnClickListener(new View.OnClickListener() 
		{
			//This listens for the clear button and this button will delete everything in the list
			@Override
			public void onClick(View v) 
			{
				ConfirmActivity temp = new ConfirmActivity();
				
				temp.show(getSupportFragmentManager(), "This is a test");
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
