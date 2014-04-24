package com.main.LunchWithFriends;

import java.util.ArrayList;
import java.util.Date;

public class Diner {
    private String Name;
    private int Id;
    private float CurrentBalance;
    private Date DateJoined;
    private Date DateLastDined;
    private boolean IsMe;

    private ArrayList<Integer> MealIds;
    private ArrayList<Balance> OpenBalances;

    //Constructor
    public Diner(int id) {
        Id = id;
    }

    //Functions
    public ArrayList<Diner> GetWhoOwesMe()
    {
        ArrayList<Diner> WhoOwesMe = new ArrayList<Diner>();

        for ( Balance b : OpenBalances )
        {
            if ( b.getAmount() > 0.0f && b.getDinerIdTo() == Id )
            {
                WhoOwesMe.add( LunchWithFriendsApp.GetInstance().GetDinerById( Id ) );
            }
        }

        return WhoOwesMe;
    }

    public ArrayList<Diner> GetWhoIOwe()
    {
        ArrayList<Diner> WhoIOwe = new ArrayList<Diner>();

        for ( Balance b : OpenBalances )
        {
            if ( b.getAmount() > 0.0f && b.getDinerIdFrom() == Id )
            {
                WhoIOwe.add( LunchWithFriendsApp.GetInstance().GetDinerById( Id ) );
            }
        }

        return WhoIOwe;
    }

    public void AddMealId( int inMealId )
    {
        if ( !MealIds.contains( inMealId ) )
        {
            MealIds.add( inMealId );
        }

        if ( !LunchWithFriendsApp.GetInstance().GetMealById( inMealId ).HasDinerId( getId() ) )
        {
            LunchWithFriendsApp.GetInstance().GetMealById( inMealId ).AddDiner( this );
        }
    }

    public void RemoveMealId( int inMealId )
    {
        MealIds.remove( inMealId );

        if ( LunchWithFriendsApp.GetInstance().GetMealById( inMealId ).HasDinerId( getId() ) )
        {
            LunchWithFriendsApp.GetInstance().GetMealById( inMealId ).RemoveDiner( this );
        }
    }

    public boolean isMe()
    {
        return IsMe;
    }

    //Getters/Setters

    public void setIsMe(boolean isMe) {
        IsMe = isMe;
    }

    public ArrayList<Integer> getMealIds() {
        return MealIds;
    }

    public void setMealIds(ArrayList<Integer> mealIds) { MealIds = mealIds; }

    public ArrayList<Balance> getOpenBalances() {
        return OpenBalances;
    }

    public void setOpenBalances(ArrayList<Balance> openBalances) {
        this.OpenBalances = openBalances;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getCurrentBalance() {
        return CurrentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        CurrentBalance = currentBalance;
    }

    public Date getDateJoined() {
        return DateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        DateJoined = dateJoined;
    }

    public Date getDateLastDined() {
        return DateLastDined;
    }

    public void setDateLastDined(Date dateLastDined) {
        DateLastDined = dateLastDined;
    }
}
