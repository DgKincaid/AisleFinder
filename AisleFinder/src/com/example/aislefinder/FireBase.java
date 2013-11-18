package com.example.aislefinder;

import java.util.Map;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.R.string;
import android.content.Context;
import android.widget.Toast;

public class FireBase 
{
	public static Item getData(final Context context, final String name)
	{
		// Create a reference to a Firebase location
			Firebase ref = new Firebase("https://mfreddata.firebaseio.com/ItemFinder/Grocery_Store1/Aisle_1/");
			
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
			            Toast.makeText(context, "value is null", Toast.LENGTH_SHORT).show();
			    	}
			    	else
			    	{
			    		String location = (String)((Map)value).get("Item Aisle");
			    		String description = (String)((Map)value).get("Item Description");
			    		
			    		temp.setLocation(location);
			    		temp.setName(name);
			    		temp.setDescription(description);
			    		
			    		Toast.makeText(context, "Location" + location, Toast.LENGTH_LONG).show();
			    	}
			    }

				@Override
				public void onCancelled(FirebaseError arg0) 
				{
					// TODO Auto-generated method stub
				}
			});
			
			Item item = new Item(name, "loc", "des");
			return item;
	}
}
