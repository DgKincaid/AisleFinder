package com.example.aislefinder;

import java.util.Map;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.R.string;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class FireBase extends FragmentActivity
{
	public Item getData(final Context context, final String name)
	{
		// Create a reference to a Firebase location
		String url = "https://mfreddata.firebaseio.com/ItemFinder/Grocery_Store1/";
		Firebase ref = new Firebase("https://mfreddata.firebaseio.com/ItemFinder/Grocery_Store1/" + name.toLowerCase());
		
		final Item temp = new Item();
		
		// Read data and react to changes
		ref.addValueEventListener(new ValueEventListener() 
		{
		    @Override
		    public void onDataChange(DataSnapshot snap) 
		    {
		    	Object value = snap.getValue();
		    	
		    	if (value == null) 
		    	{
		    		//InvalidOption temp = new InvalidOption();
		    		//temp.show(getSupportFragmentManager(), "Invalid");
		            Toast.makeText(context, "value is null", Toast.LENGTH_SHORT).show();
		            //Go to popup telling user to reenter item
		    	}
		    	else
		    	{
		    		//String location = (String)((Map)value).get("Item Aisle");
		    		Long loc = (Long) ((Map)value).get("Item Aisle");
		    		String description = (String)((Map)value).get("Item Description");
		    		
		    		String location = loc.toString();
		    		temp.setLocation(location);
		    		temp.setName(name);
		    		temp.setDescription(description);
		    		
		    		Toast.makeText(context, "Location " + description, Toast.LENGTH_LONG).show();
		    	}
		    }

			@Override
			public void onCancelled(FirebaseError arg0) 
			{
				// TODO Auto-generated method stub
			}
		});
		return temp;
	}
}
