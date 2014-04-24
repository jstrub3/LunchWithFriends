package com.main.LunchWithFriends;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LunchWithFriendsApp extends Application
{
    private static LunchWithFriendsApp Instance;
    private ArrayList<Meal>             Meals = new ArrayList<Meal>();
    private ArrayList<Balance>          Balances = new ArrayList<Balance>();
    private ArrayList<Diner>            Diners = new ArrayList<Diner>();
    private ArrayList<Restaurant>       Restaurants = new ArrayList<Restaurant>();

    private Diner currentDiner;

    @Override
    public void onCreate()
    {
        super.onCreate();

        Instance = this;

        //Debug diners
        Date today = new Date();

        Diner Me = new Diner(0);
        Me.setName("Joe");
        Me.setIsMe(true);
        Me.setDateJoined(today);

        Diner Tom = new Diner(1);
        Tom.setName("Tom");
        Tom.setDateJoined(today);

        Diner Jane = new Diner(2);
        Jane.setName("Jane");
        Jane.setDateJoined(today);

        Diners.add(Me);
        Diners.add(Tom);
        Diners.add(Jane);

        //Debug restaurants
        Restaurant Place1 = new Restaurant(0);
        Restaurant Place2 = new Restaurant(1);
        Restaurant Place3 = new Restaurant(2);

        Restaurants.add(Place1);
        Restaurants.add(Place2);
        Restaurants.add(Place3);

        //Debug meals
        Meal Breakfast = new Meal(0);
        Breakfast.AddDiner(0);
        Breakfast.AddDiner(1);
        Breakfast.setRestaurantId(0);

        Meal Lunch = new Meal(1);
        Lunch.AddDiner(0);
        Lunch.AddDiner(2);
        Lunch.setRestaurantId(1);

        Meal Dinner = new Meal(2);
        Dinner.AddDiner(0);
        Dinner.AddDiner(1);
        Dinner.AddDiner(2);
        Dinner.setRestaurantId(2);

        Meals.add(Breakfast);
        Meals.add(Lunch);
        Meals.add(Dinner);
    }

    public static LunchWithFriendsApp GetInstance()
    {
        return Instance;
    }

    public Diner GetDinerById(int id)
    {
        for ( Diner d : Diners )
        {
            if ( d.getId() == id )
            {
                return d;
            }
        }

        return null;
    }

    public Restaurant GetRestaurantById( int id )
    {
        for ( Restaurant r : Restaurants )
        {
            if ( r.getId() == id )
            {
                return r;
            }
        }

        return null;
    }

    public Meal GetMealById( int id )
    {
        for ( Meal m : Meals )
        {
            if ( m.getId() == id )
            {
                return m;
            }
        }

        return null;
    }

    public void UpdateCurrentDiner()
    {
        for ( Diner d : getDiners() )
        {
            if ( d.isMe() )
            {
                setCurrentDiner(d);
            }
        }
    }

    //Getters/Setters
    public ArrayList<Meal> getMeals() {
        return Meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        Meals = meals;
    }

    public ArrayList<Balance> getBalances() {
        return Balances;
    }

    public void setBalances(ArrayList<Balance> balances) {
        Balances = balances;
    }

    public ArrayList<Diner> getDiners() { return Diners; }

    public void setDiners(ArrayList<Diner> diners) {
        Diners = diners;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return Restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        Restaurants = restaurants;
    }

    public Diner getCurrentDiner() { return currentDiner; }

    public void setCurrentDiner(Diner diner) { currentDiner = diner; }
}
