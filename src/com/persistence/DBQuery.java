package com.persistence;

public class DBQuery {

    public final static String ConnectionUrl = "jdbc:sqlite:C:\\dev\\java_workspace\\JustEat\\JE_DB.db";

    // 수정 필요
//    public final static String AJOU_UNIVERSITY = "아주대";
    //public final static String RESTAURANT_ID = "1";

    public final static String GET_RESTAURANT_INFO_ALL = "SELECT * FROM Restaurant_Info WHERE Restaurant_Info.location like "; 
    public final static String GET_RESTAURANT_ITEM = "SELECT * FROM Item WHERE Item.restaurant_id = ";
    public final static String GET_RESTAURANT_TABLE = "SELECT * FROM Restaurant_Table WHERE Restaurant_Table.restaurant_id = ";
    public final static String GET_RESTAURANT_INFO = "SELECT * FROM Restaurant_Info WHERE Restaurant_Info.restaurant_id = ";
    public final static String GET_ITEM = "SELECT * FROM Item WHERE Item.item_id = ";
    public final static String GET_TABLE = "SELECT * FROM Restaurant_Table WHERE Restaurant_Table.table_id = ";
}
