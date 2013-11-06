package com.example.aislefinder;

import android.widget.Toast;

public class Item 
{
	private String itemName;
	private String itemDescription;
	private String itemLocation;
	
	public Item(String name, String description, String location)
	{
		itemName = name;
		itemDescription = description;
		itemLocation = location;
	}
	
	public String[] showItem()
	{
		String[] list = {itemName, itemDescription, itemLocation};
		return list;
	}
	
	public boolean isEmpty()
	{
		if(itemName.isEmpty() || itemDescription.isEmpty() || itemLocation.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public String getName()
	{
		return itemName;
	}
}
