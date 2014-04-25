package com.main.LunchWithFriends;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Meal {
    private int                        Id;
    private int                        RestaurantId;
    private Date                       MealDate;
    private float                      CheckAmount; //less tip
    private ArrayList<Integer>         DinerIds;
    private HashMap<Integer, Float>    AmountsOwed; //< DinerId, Amount>

    //Constructor
    public Meal() {
        this(0, 0, new Date(), 0, new ArrayList<Integer>(), new HashMap<Integer, Float>());

    }
    public Meal(int id) {
        this(id, 0, new Date(), 0, new ArrayList<Integer>(), new HashMap<Integer, Float>());
    }

    public Meal(int id, int restaurantId) {
        this(id, restaurantId, new Date(), 0, new ArrayList<Integer>(), new HashMap<Integer, Float>());
    }

    public Meal(int id, int restaurantId, Date mealDate ) {
        this(id, restaurantId, mealDate, 0, new ArrayList<Integer>(), new HashMap<Integer, Float>());
    }

    public Meal(int id, int restaurantId, Date mealDate, float checkAmount ) {
        this(id, restaurantId, mealDate, checkAmount, new ArrayList<Integer>(), new HashMap<Integer, Float>());
    }

    public Meal(int id, int restaurantId, Date mealDate, float checkAmount, ArrayList<Integer> dinerIds ) {
        this(id, restaurantId, mealDate, checkAmount, dinerIds, new HashMap<Integer, Float>());
    }

    public Meal(int id, int restaurantId, Date mealDate, float checkAmount, ArrayList<Integer> dinerIds, HashMap<Integer, Float> amountsOwed) {
        Id = id;
        RestaurantId = restaurantId;
        MealDate = mealDate;
        CheckAmount = checkAmount;
        DinerIds = dinerIds;
        AmountsOwed = amountsOwed;
    }

    //Functions
    public void ParseCheck()
    {

    }

    public float GetAmountOwed( Diner d )
    {
        return AmountsOwed.get( d.getId() );
    }

    public float GetAmountOwed( int i )
    {
        return AmountsOwed.get( i );
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
       LunchWithFriendsApp.GetInstance().GetRestaurantById( getRestaurantId() ).RemoveMeal(getId());

       RestaurantId = restaurantId;
       LunchWithFriendsApp.GetInstance().GetRestaurantById( restaurantId ).AddMeal( getId() );
    }
}
