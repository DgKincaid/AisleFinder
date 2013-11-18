package com.example.aislefinder;

import android.widget.Toast;

public class Item 
{
	private String itemName;
	private String itemDescription;
	private String itemLocation;
	
	public Item()
	{
		itemName = null;
		itemDescription = null;
		itemLocation= null;
	}
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
	
	public String getLocation()
	{
		return itemLocation;
	}
	
	public void setName(String name)
	{
		itemName = name;
	}
	
	public void setLocation(String loc)
	{
		itemLocation = loc;
	}
	
	public void setDescription(String des)
	{
		itemDescription = des;
	}
}
