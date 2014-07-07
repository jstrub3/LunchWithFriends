package com.main.LunchWithFriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DinerActivity extends LWFActivity {

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
            DinerNameView.setText( GetCurrentDiner().getName() );

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String MoneyString = formatter.format(GetCurrentBalance());
            CurrentBalanceButton.setText( MoneyString );
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