package com.restaurant;

public class Item {
    public int itemId;
    public String itemName;
    public String cookingTime;
    public int cost;
    public int onSale;
    public int restaurantId;

    public Item(int itemId, String itemName, String cookingTime, int cost, int onSale, int restaurantId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cookingTime = cookingTime;
        this.cost = cost;
        this.onSale = onSale;
        this.restaurantId = restaurantId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOnSale() {
        return onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", cookingTime='" + cookingTime + '\'' +
                ", cost=" + cost +
                ", onSale=" + onSale +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
