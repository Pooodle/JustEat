package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.persistence.DBHandler;
import com.restaurant.Table;
import com.restaurant.TableAdapter;
import com.restaurant.TableSelection;
import com.restaurant.Item;
import com.restaurant.ItemAdapter;
import com.restaurant.MenuSelection;
import com.restaurant.Order;
import com.restaurant.RestaurantInfoAdapter;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] itemIdlist = request.getParameterValues("itemId");
		System.out.println("선택된 품목 아이디"+itemIdlist[0]);
//		for(int i=1; i < itemId.length; i++) {
//			System.out.println(itemId[i]);
//		}
		String[] howmanyItem = request.getParameterValues("howmanyItem");
//		for(int i=1; i < howmanyItem.length; i++) {
//		System.out.println(howmanyItem[i]);
//	}
//		String[] checkedTableidlist = request.getParameterValues("checkedTableid");
//		
		String[] checkedTableidarr = request.getParameterValues("checkedTableid");
		System.out.println("쳌트 테이블"+checkedTableidarr[0]);
		
		ArrayList<MenuSelection> choosedItemlsit = new ArrayList<>();
		for(int i = 0; i<itemIdlist.length; i++) {
			//System.out.println(id);
			int itemId = Integer.parseInt(itemIdlist[i]);
			int howmany = Integer.parseInt(howmanyItem[i]);
			System.out.println("choosed:"+ howmany);
			if(howmany > 0) {
				choosedItemlsit.add(new MenuSelection(itemId,howmany));
			}
		}
		
		ArrayList<TableSelection> choosedTablelist = new ArrayList<>();
		for(int i = 0; i<checkedTableidarr.length; i++) {
			//System.out.println(id);
			int tableId = Integer.parseInt(checkedTableidarr[i]);
			System.out.println("choosed 테이블:"+ tableId);
			choosedTablelist.add(new TableSelection(tableId));
		}
		
		Order order = new Order(choosedItemlsit,choosedTablelist);
		int total = order.getTotal();
		System.out.println("서블릿 토탈"+total);
		
//		for (MenuSelection selectedMenu : choosedItemlsit) {
//			System.out.println(selectedMenu.item);
//			System.out.println(selectedMenu.quantity);
//		}
		
		for (TableSelection selectedTable : choosedTablelist) {
		System.out.println(selectedTable.table);
	}
		 
		javax.servlet.RequestDispatcher testdata = request.getRequestDispatcher("cart.jsp");
		request.setAttribute("choosedItemlsit", choosedItemlsit);
		request.setAttribute("choosedTablelist", choosedTablelist);
		request.setAttribute("total", total);
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
