package com.persistence;
import java.sql.ResultSet;

public interface ExecuteQuery {
    void processFromResultSet(ResultSet resultSet);
}
