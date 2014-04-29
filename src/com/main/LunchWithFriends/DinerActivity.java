package com.main.LunchWithFriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button CurrentBalanceButton = (Button) findViewById(R.id.Activity_CurrentBalance);

        if ( DinerNameView != null )
        {
            DinerNameView.setText( GetCurrentDinerName() );
            CurrentBalanceButton.setText( GetCurrentBalance() );
        }
    }

    public void PushActivity(View view )
    {
        Intent intent = null;
        switch ( view.getId() )
        {
            case R.id.Activity_CurrentBalance:
                intent = new Intent(this, BalanceActivity.class);
                break;
        }

        if ( null != intent)
        {
            startActivity(intent);
        }
    }
}