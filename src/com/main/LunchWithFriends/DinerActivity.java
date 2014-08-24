package com.main.LunchWithFriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DinerActivity extends LWFActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diner);

        TextView DinerNameView = (TextView) findViewById(R.id.DinerName);
        TextView BalanceView = (TextView) findViewById(R.id.CurrBalance);
        ListView MealList = (ListView) findViewById(R.id.MealList);

        if ( DinerNameView != null )
        {
            DinerNameView.setText( GetCurrentDiner().getName() );
        }

        if ( BalanceView != null)
        {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String MoneyString = formatter.format(GetCurrentBalance());
            BalanceView.setText(MoneyString);
        }

        if ( MealList != null )
        {
            ArrayList<Meal> Meals = LunchWithFriendsApp.GetInstance().getMealsFromDiner(GetCurrentDiner());
            ArrayAdapter<Meal> sAdapter = new ArrayAdapter<Meal>(this,
                    android.R.layout.simple_list_item_1,
                    Meals);

            MealList.setAdapter(sAdapter);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void PushActivity(View view )
    {
        Intent intent = null;
        switch ( view.getId() )
        {
            default:
                break;
        }

        if ( null != intent)
        {
            startActivity(intent);
        }
    }
}