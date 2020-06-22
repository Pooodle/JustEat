package com.restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.persistence.DBHandler;
import com.persistence.DBQuery;
import com.persistence.ExecuteQuery;

public class TableSelection {
    public Table table;

    public TableSelection(int tableId) {
    	System.out.println("테이블셀렉션"+tableId);
        List<Table> tableList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(DBQuery.ConnectionUrl);
        
        String strTableid = Integer.toString(tableId);
        String sql = DBQuery.GET_TABLE + strTableid;
        
        dbHandler.databaseProcess(sql, new String[]{}, new ExecuteQuery() {
            @Override
            public void processFromResultSet(ResultSet resultSet) {
                try {
                	tableList.add(new Table(resultSet.getInt("table_id")
                            , resultSet.getInt("status")
                            , resultSet.getInt("capacity")
                            , resultSet.getInt("restaurant_id")));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        System.out.println("테이블리스트get0"+tableList.get(0));
        this.table = tableList.get(0);
    }

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
