package com.restaurant;

import java.util.List;

public class Order {
    private List<MenuSelection> menuSelectionList;
    private List<TableSelection> tableSelectionList;

    public Order(List<MenuSelection> menuSelectionList, List<TableSelection> tableSelectionList) {
    	this.menuSelectionList = menuSelectionList;
    	this.tableSelectionList = tableSelectionList;
    }
    public int getTotal() {
        return menuSelectionList.stream().mapToInt(MenuSelection::getSubTotal).sum();
    }
}
