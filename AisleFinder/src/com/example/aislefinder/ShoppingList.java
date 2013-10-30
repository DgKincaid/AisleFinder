package com.example.aislefinder;

import java.util.Vector;
import android.R.string;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

//this will store the user shopping list
public class ShoppingList 
{
	private Vector<String> shoppingList = new Vector<String>();
	
	@SuppressLint("NewApi")
	public void addElement(String element, Context context)
	{
		if(element.isEmpty())
		{
			Toast.makeText(context, "Input invalid: Add Elementt", Toast.LENGTH_SHORT);
		}
		shoppingList.add(element);
	}
	
	public Vector<String> getShoppingList()
	{
		return shoppingList;
	}
}
