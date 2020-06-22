package com.restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persistence.DBHandler;
import com.persistence.DBQuery;
import com.persistence.ExecuteQuery;

public class MenuSelection {
    public Item item;
    public int quantity;

    public MenuSelection(int itemId, int quantity) {
        List<Item> itemList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        
        String strItemid = Integer.toString(itemId);
        String sql = DBQuery.GET_ITEM + strItemid;
        
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                    itemList.add(new Item(resultSet.getInt("item_id")
                            , resultSet.getString("item_name")
                            , resultSet.getString("cooking_time")
                            , resultSet.getInt("cost")
                            , resultSet.getInt("onSale")
                            , resultSet.getInt("restaurant_id")));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        this.item = itemList.get(0);
        this.quantity = quantity;
    }

    public MenuSelection(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubTotal() {
        return item.getCost() * quantity;
    }
}
