package com.main.LunchWithFriends;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class CheckParser
{
    private class MealItem
    {
        private float   cost;
        private int     dinerId;
        private String  name;


        //Getters/setters
        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }

        public int getDinerId() {
            return dinerId;
        }

        public void setDinerId(int dinerId) {
            this.dinerId = dinerId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private ArrayList<MealItem> MealItems;
}
