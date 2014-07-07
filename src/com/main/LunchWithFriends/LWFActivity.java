package com.main.LunchWithFriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Joseph on 4/29/14.
 */
public class LWFActivity extends Activity
{
    public float GetCurrentBalance()
    {
        if ( null != GetCurrentDiner() )
        {
            return GetCurrentDiner().getCurrentBalance();
        }
        else
        {
            return Float.MAX_VALUE; //Erroneous return value
        }
    }

    public Diner GetCurrentDiner()
    {
        LunchWithFriendsApp app = LunchWithFriendsApp.GetInstance();

        if ( null != app.getCurrentDiner() )
        {
            return app.getCurrentDiner();
        }
        else
        {
            return null;
        }
    }
}
