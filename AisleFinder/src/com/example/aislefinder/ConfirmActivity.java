package com.example.aislefinder;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.view.Menu;

@SuppressLint("NewApi")
public class ConfirmActivity extends DialogFragment  
{
	public ShoppingList myList = ShoppingList.getInstance();
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        builder.setMessage(R.string.dialog_delete)
               .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() 
               {
                   public void onClick(DialogInterface dialog, int id) 
                   {
                       myList.clearItems();
                   }
               })
               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
               {
                   public void onClick(DialogInterface dialog, int id) 
                   {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
