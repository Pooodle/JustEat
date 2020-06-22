package com.restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persistence.DBHandler;
import com.persistence.DBQuery;
import com.persistence.ExecuteQuery;

public class RestaurantInfoAdapter {
    private String keyword = "아주대";
    private int restaurantId = 0;

    public RestaurantInfoAdapter() {
    }

    public List<RestaurantInfo> getRestaurantInfoall() {
        List<RestaurantInfo> restaurantInfoList = new ArrayList<>();
        RestaurantInfo restaurantInfo = null;

        String sql = DBQuery.GET_RESTAURANT_INFO_ALL +"\""+ keyword +"\"";
        System.out.println(sql);
        
        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                    restaurantInfoList.add(new RestaurantInfo(resultSet.getInt(1)
                            , resultSet.getString(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5)
                            , resultSet.getString(6)
                            , resultSet.getDouble(7)
                            , resultSet.getDouble(8)
                            , resultSet.getString(9)));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        return restaurantInfoList;
    }

    
    public RestaurantInfo getRestaurantInfo() {
        List<RestaurantInfo> restaurantInfoList = new ArrayList<>();

        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        
        String strRestaurantId = Integer.toString(restaurantId);
        String sql = DBQuery.GET_RESTAURANT_INFO +strRestaurantId;
        System.out.println("레스토랑객체 하나"+sql);
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                    restaurantInfoList.add(new RestaurantInfo(resultSet.getInt(1)
                            , resultSet.getString(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5)
                            , resultSet.getString(6)
                            , resultSet.getDouble(7)
                            , resultSet.getDouble(8)
                            , resultSet.getString(9)));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        return restaurantInfoList.get(0);
    }
    
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
    
	
    
}
