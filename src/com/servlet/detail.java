package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.Item;
import com.restaurant.ItemAdapter;
import com.restaurant.RestaurantInfo;
import com.restaurant.RestaurantInfoAdapter;
import com.restaurant.Table;
import com.restaurant.TableAdapter;
import com.persistence.*;

/**
 * Servlet implementation class detial
 */
@WebServlet("/detail")
public class detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String restaurantId = request.getParameter("restaurantId");
		System.out.println(restaurantId);
		
		//레스토랑 이름
		
		int intRestaurantid = Integer.parseInt(restaurantId);
		
		ItemAdapter itemAdapter = new ItemAdapter(intRestaurantid);
	    System.out.println(itemAdapter.getRestaurantId());
	    TableAdapter tableAdapter = new TableAdapter(intRestaurantid);
	    RestaurantInfoAdapter restaurantInfoAdapter = new RestaurantInfoAdapter();
	    
	    List<Item> itemList = itemAdapter.getRestaurantItems();
	    List<Table> tableList = tableAdapter.getTables();
	    restaurantInfoAdapter.setRestaurantId(intRestaurantid);
	    RestaurantInfo info = restaurantInfoAdapter.getRestaurantInfo();
	    System.out.println(info);
	    
	      for (Item item : itemList) {
	      System.out.println(item.getItemName());
	      }
	    
		javax.servlet.RequestDispatcher testdata = request.getRequestDispatcher("detail.jsp");
		request.setAttribute("restaurantId", restaurantId);
		request.setAttribute("itemList", itemList);
		request.setAttribute("tableList", tableList);
		request.setAttribute("info", info);
		testdata.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
