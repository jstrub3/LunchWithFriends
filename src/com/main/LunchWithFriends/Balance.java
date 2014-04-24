package com.main.LunchWithFriends;

import java.util.Date;

public class Balance {
    private int DinerIdFrom;
    private int DinerIdTo;
    private int MealId;
    private float Amount;
    private Date BalanceUpdateDate;

    public int getDinerIdFrom() {
        return DinerIdFrom;
    }

    public void setDinerIdFrom(int dinerIdFrom) {
        DinerIdFrom = dinerIdFrom;
    }

    public int getDinerIdTo() {
        return DinerIdTo;
    }

    public void setDinerIdTo(int dinerIdTo) {
        DinerIdTo = dinerIdTo;
    }

    public int getMealId() {
        return MealId;
    }

    public void setMealId(int mealId) {
        MealId = mealId;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public Date getBalanceUpdateDate() {
        return BalanceUpdateDate;
    }

    public void setTransactionDate(Date balanceUpdateDate) {
        BalanceUpdateDate = balanceUpdateDate;
    }
}
