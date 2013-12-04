package com.example.aislefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Activity 
{

	private Button backButton;
	private Button addButton;
	private Button searchButton;
	private ShoppingList list = ShoppingList.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		Bundle extras = getIntent().getExtras();
		String value = "";
		
		if (extras != null)
		{
		    value = extras.getString("name");
		}
		
		FireBase base= new FireBase();
		final Item item = base.getData(getApplicationContext(), value);
		
		final TextView name = (TextView) findViewById(R.id.textView1);
		final TextView loc = (TextView) findViewById(R.id.textView2);
		
		backButton = (Button) findViewById(R.id.backSButton);
		addButton = (Button) findViewById(R.id.addSButton);
		searchButton = (Button) findViewById(R.id.button1);
		
		searchButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				name.setText(item.getName());
				loc.setText(item.getLocation());
			}
		});
		addButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "Add Button Clicked", Toast.LENGTH_SHORT).show();
				list.addElement(item, getApplicationContext());
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
