package com.example.aislefinder;

import java.util.Vector;
import android.R.string;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

//this will store the user shopping list
public class ShoppingList 
{
	private static ShoppingList myList;
	
	private static Vector<Item> shoppingList = new Vector<Item>();
	private static Item temp = new Item();
	
	private ShoppingList(){}
	
	public static ShoppingList getInstance()
	{
		if(myList == null)
		{
			myList = new ShoppingList();
		}
		
		return myList;
	}
	
	@SuppressLint("NewApi")
	public void addElement(Item element, Context context)
	{
		shoppingList.add(element);
	}
	
	public Vector<Item> getShoppingList()
	{
		return shoppingList;
	}
	
	public Item getItem()
	{
		return temp;
	}
	public void addItem(Item item)
	{
		temp = item;
	}
	
	public void clearItems()
	{
		shoppingList.clear();
	}
	
	public void delItem(int position)
	{
		shoppingList.remove(position);
	}
}
