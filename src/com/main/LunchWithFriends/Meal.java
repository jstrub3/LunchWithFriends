package com.main.LunchWithFriends;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Meal {
    private int                                     Id;
    private int                                     RestaurantId;
    private Date                                    MealDate;
    private float                                   CheckAmount; //less tip defaulted to 20%
    private ArrayList<Integer>                      DinerIds;
    private HashMap<Integer, Float>                 OwedMap; //< DinerId, Amount>
    private HashMap<Integer, ArrayList<Integer>>    CoverMap; //< DinerId(paid), ArrayList<DinerId>(paid for)>

    //Constructor
    public Meal()
    {
        Id = 0;
        RestaurantId = 0;
        MealDate = new Date();
        CheckAmount = 0;
        DinerIds = new ArrayList<Integer>();
        OwedMap = new HashMap<Integer, Float>();
    }
    public Meal(int id)
    {
        Id = id;
        RestaurantId = 0;
        MealDate = new Date();
        CheckAmount = 0;
        DinerIds = new ArrayList<Integer>();
        OwedMap = new HashMap<Integer, Float>();
    }


    //Functions
    public void ParseCheck()
    {

    }

    public float GetAmountOwed( Diner d )
    {
        return OwedMap.get( d.getId() );
    }

    public float GetAmountOwed( int i )
    {
        return OwedMap.get( i );
    }

    public ArrayList<Integer> GetDinersCoveredBy( int i )
    {
        return CoverMap.get( i );
    }

    public Integer GetDinerCovering( int i )
    {
        for ( int idx = 0; i < CoverMap.size(); ++idx )
        {
            if ( CoverMap.get( idx ).contains(i) )
            {
                return idx;
            }
        }

        return null;
    }

    public boolean IsCovered( int i )
    {
        return GetDinerCovering( i ) != null;
    }

    public boolean HasDinerId( int i )
    {
        return DinerIds.contains(i);
    }

    public void AddDiner( Diner d )
    {
        if ( !DinerIds.contains(  d.getId() ) )
        {
            DinerIds.add( d.getId() );
            d.AddMealId( getId() );
        }
    }

    public void AddDiner( int i )
    {
        if ( !DinerIds.contains( i ) )
        {
            DinerIds.add( i );
            LunchWithFriendsApp.GetInstance().GetDinerById( i ).AddMealId( getId() );
        }
    }

    public void RemoveDiner( Diner d )
    {
        DinerIds.remove( (Integer)d.getId() );
        d.RemoveMealId( getId() );
    }

    public void RemoveDiner( int i )
    {
       DinerIds.remove( (Integer)i );
        LunchWithFriendsApp.GetInstance().GetDinerById( i ).RemoveMealId(getId());
    }

    //getters/setters
    public ArrayList<Integer> getDinerIds() {
        return DinerIds;
    }

    public void setDinerIds(ArrayList<Integer> dinerIds) {
        DinerIds = dinerIds;
    }

    public Date getMealDate() {
        return MealDate;
    }

    public void setMealDate(Date mealDate) {
        MealDate = mealDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) 
   {
       //remove from current restaurantId's list of meals, add to new restaurantId's list
       Restaurant restaurant = LunchWithFriendsApp.GetInstance().GetRestaurantById( RestaurantId);

       if ( null != restaurant )
       {
           restaurant.RemoveMeal(getId());
       }

       restaurant = LunchWithFriendsApp.GetInstance().GetRestaurantById(restaurantId);

       if ( null != restaurant )
       {
           restaurant.AddMeal( Id );
       }

       RestaurantId = restaurantId;
    }
}
