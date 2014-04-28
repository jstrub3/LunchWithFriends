package com.main.LunchWithFriends;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DinerActivity extends Activity {

    public String GetCurrentDinerName()
    {
        LunchWithFriendsApp app = LunchWithFriendsApp.GetInstance();

        if ( null != app.getCurrentDiner() )
        {
            return app.getCurrentDiner().getName();
        }
        else
        {
            return "No Diner Selected!";
        }
    }

    public String GetCurrentBalance()
    {
        LunchWithFriendsApp app = LunchWithFriendsApp.GetInstance();

        if ( null != app.getCurrentDiner() )
        {
            return String.valueOf(app.getCurrentDiner().getCurrentBalance());
        }
        else
        {
            return "No balance available";
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diner);
    }

    @Override
    public void onStart() {
        super.onStart();

        TextView DinerNameView = (TextView) findViewById(R.id.DinerName);
        TextView CurrentBalanceView = (TextView) findViewById(R.id.CurrentBalance);

        if ( DinerNameView != null )
        {
            DinerNameView.setText( GetCurrentDinerName() );
            CurrentBalanceView.setText( GetCurrentBalance() );
        }
    }
}