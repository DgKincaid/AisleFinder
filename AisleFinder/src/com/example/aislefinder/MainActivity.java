package com.example.aislefinder;

import java.util.Vector;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{

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
		
		final Item newItem = new Item("h","h", "h");
		
		final EditText eText = (EditText)findViewById(R.id.editText1);
		
		final ShoppingList myList = new ShoppingList();
		
		searchButton.setOnClickListener(new View.OnClickListener() 
		{	
			//Listens for the search button. Search function is implemented in here
			@Override
			public void onClick(View v) 
			{
				String[] list = newItem.showItem();
				Toast.makeText(getApplicationContext(), "Search Button", Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(), "itemName:" + list[0], Toast.LENGTH_SHORT).show();
			}
		});
		
		addButton.setOnClickListener(new View.OnClickListener() 
		{	
			//This listener is for the add button
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Add Button", Toast.LENGTH_SHORT).show();
				myList.addElement(eText.getText().toString(), getApplicationContext());
			}
		});
		
		clearButton.setOnClickListener(new View.OnClickListener() 
		{
			//This listens for the clear button and this button will delete everything in the list
			@Override
			public void onClick(View v) 
			{
				
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