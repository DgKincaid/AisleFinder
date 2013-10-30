package com.example.aislefinder;

import android.widget.Toast;

public class Item 
{
	private String itemName;
	private String itemDescription;
	private String itemLocation;
	
	public Item(String name, String itemDescription, String location)
	{
		itemName = name;
		itemLocation = location;
	}
	
	public String[] showItem()
	{
		String[] list = {itemName, itemDescription, itemLocation};
		return list;
	}
}
