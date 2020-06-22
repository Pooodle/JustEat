package com.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    private String connectionUrl;

    public DBHandler(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public void databaseProcess(String sqlQuery, String[] arg, ExecuteQuery executeQuery) {
    	try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.connectionUrl);
            Statement statement;
            if (arg.length == 0) {
                statement = connection.createStatement();
            } else {
                statement = connection.prepareStatement(sqlQuery);
            }
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet resultSet = getResultSetFromSqlQuery(statement, arg, sqlQuery);
            if (resultSet != null) {
                while (resultSet.next()) {
                    executeQuery.processFromResultSet(resultSet);
                }
            } else
                executeQuery.processFromResultSet(null);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private ResultSet getResultSetFromSqlQuery(Statement statement, String[] arg, String sqlQuery) {
        ResultSet resultSet = null;
        if (arg.length == 0) {
            try {
                resultSet = statement.executeQuery(sqlQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                int i;
                PreparedStatement preState = (PreparedStatement)statement;
                for (i = 1; i <= arg.length; i++) {
                    preState.setString(i, arg[i - 1]);
                }
                preState.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }
}
