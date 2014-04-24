package com.main.LunchWithFriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void PushActivity(View view )
    {
        Intent intent = null;
        switch ( view.getId() )
        {
            case R.id.Activity_Diner:
                intent = new Intent(this, DinerActivity.class);
                break;
            case R.id.Activity_RecentMeals:
                intent = new Intent(this, DinerActivity.class);
                break;
        }

        if ( null != intent)
        {
            startActivity(intent);
        }
    }
}
