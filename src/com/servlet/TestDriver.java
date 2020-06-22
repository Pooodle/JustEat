package com.servlet;

import java.util.List;

import com.restaurant.Item;
import com.restaurant.ItemAdapter;
import com.restaurant.RestaurantInfoAdapter;
import com.restaurant.Table;
import com.restaurant.TableAdapter;

public class TestDriver {
    public static void main(String[] args) {
        ItemAdapter itemAdapter = new ItemAdapter(1);
        System.out.println(itemAdapter.getRestaurantId());
        TableAdapter tableAdapter = new TableAdapter(1);
        RestaurantInfoAdapter restaurantInfoAdapter = new RestaurantInfoAdapter();
        List<Item> itemList = itemAdapter.getRestaurantItems();
        List<Table> tableList = tableAdapter.getTables();

//        for (Item item : itemList) {
//            System.out.println(item);
//        }
//
//        System.out.println(restaurantInfoAdapter.getRestaurantInfo());

        for (Table table : tableList) {
            System.out.println(table);
        }
    }
}
