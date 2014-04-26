package com.main.LunchWithFriends;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant {
    private int Id;
    private Date DateLastDined;
    private Date DateAdded;
    private int MealCount;
    private ArrayList<Integer> MealIds;
    private ArrayList<Integer> DinerIds;

    //Construction
    public Restaurant()
    {
        Id = 0;
        DateLastDined = new Date();
        DateAdded = new Date();
        MealCount = 0;
        MealIds = new ArrayList<Integer>();
        DinerIds = new ArrayList<Integer>();
    }

    public Restaurant(int id)
    {
        Id = id;
        DateLastDined = new Date();
        DateAdded = new Date();
        MealCount = 0;
        MealIds = new ArrayList<Integer>();
        DinerIds = new ArrayList<Integer>();
    }

    //Functions
    public void AddMeal( Meal m )
    {
        if ( !MealIds.contains( m.getId() ) )
        {
            MealIds.add( (Integer)m.getId() );
        }
    }

    public void AddMeal( int i )
    {
        if ( !MealIds.contains( (Integer)i ) )
        {
            MealIds.add( (Integer)i );
        }
    }

    public void RemoveMeal( Meal m )
    {
        MealIds.remove( (Integer)m.getId() );
    }

    public void RemoveMeal( int i )
    {
        MealIds.remove( (Integer)i );
    }

    //Getters/Setters
    public ArrayList<Integer> getDinerIds() {
        return DinerIds;
    }

    public void setDinerIds(ArrayList<Integer> dinerIds) {
        DinerIds = dinerIds;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getDateLastDined() {
        return DateLastDined;
    }

    public void setDateLastDined(Date dateLastDined) {
        DateLastDined = dateLastDined;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        DateAdded = dateAdded;
    }

    public int getMealCount() {
        return MealCount;
    }

    public void setMealCount(int mealCount) {
        MealCount = mealCount;
    }

    public ArrayList<Integer> getMealIds() {
        return MealIds;
    }

    public void setMealIds(ArrayList<Integer> mealIds) {
        MealIds = mealIds;
    }
}
