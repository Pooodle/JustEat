package com.restaurant;

public class Table {
    public int tableId;
    public int tableStatus;
    public int capacity;
    public int restaurantId;

    public Table(int tableId, int tableStatus, int capacity, int restaurantId) {
        this.tableId = tableId;
        this.tableStatus = tableStatus;
        this.capacity = capacity;
        this.restaurantId = restaurantId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", tableStatus=" + tableStatus +
                ", capacity=" + capacity +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
