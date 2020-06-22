package com.restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persistence.DBHandler;
import com.persistence.DBQuery;
import com.persistence.ExecuteQuery;

public class TableAdapter {
    private int restaurantId;

    public TableAdapter(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Table> getTables() {
        List<Table> tableList = new ArrayList<>();

        String strRestaurantId = Integer.toString(restaurantId);
        String sql = DBQuery.GET_RESTAURANT_TABLE+strRestaurantId;
        System.out.println(sql);
        
        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                    Table table = new Table(resultSet.getInt(1)
                    ,resultSet.getInt(2)
                    ,resultSet.getInt(3)
                    ,resultSet.getInt(4));
                    tableList.add(table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        return tableList;
    }
}
