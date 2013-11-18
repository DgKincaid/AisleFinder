package com.example.aislefinder;

import java.util.ArrayList;

import android.widget.AdapterView;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

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
		
		final Vector<Item> list = myList.getShoppingList();
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		ItemAdapter itemAdapter;
		
		List<Item> arrayList = new ArrayList<Item>(list);
		itemAdapter = new ItemAdapter(Show.this, R.layout.listitem, arrayList);
		listview.setAdapter(itemAdapter);
		
		listview.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				Toast.makeText(getApplicationContext(), "Position:	" + arg2, Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(getApplicationContext(), ItemZoom.class);
				intent.putExtra("position", arg2);
				startActivity(intent);
			}
		});
		backButton.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(getApplicationContext(), "BackButton", Toast.LENGTH_SHORT).show();
				finish();
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
