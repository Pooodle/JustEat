package com.restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persistence.DBHandler;
import com.persistence.DBQuery;
import com.persistence.ExecuteQuery;

public class ItemAdapter {
    private int restaurantId=1;
    private int itemId=0;

    public ItemAdapter() {
    }
    
    public ItemAdapter(int restaurantId) {
        this.restaurantId = restaurantId;
    }

        public List<Item> getRestaurantItems() {
        List<Item> itemList = new ArrayList<>();

        System.out.println("어댑터 레스토랑 아이디"+restaurantId);
        String strRestaurantId = Integer.toString(restaurantId);
        String sql = DBQuery.GET_RESTAURANT_ITEM+strRestaurantId;
        System.out.println(sql);
        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                    Item item = new Item(resultSet.getInt("item_id")
                            , resultSet.getString("item_name")
                            , resultSet.getString("cooking_time")
                            , resultSet.getInt("cost")
                            , resultSet.getInt("onSale")
                            , resultSet.getInt("restaurant_id"));
                    itemList.add(item);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        System.out.println(itemList);
        return itemList;
    }
        
    public Item getItem() {
    	
    	System.out.println("아이템어뎁터 아이템아이디"+itemId);
    	
        List<Item> itemList = new ArrayList<>();

        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        
        String strItenId = Integer.toString(itemId);
        String sql = DBQuery.GET_ITEM + strItenId;
        
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
        return itemList.get(0);
    }

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

}
