package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.RestaurantInfo;
import com.restaurant.RestaurantInfoAdapter;

/**
 * Servlet implementation class map
 */
@WebServlet("/map")
public class map extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public map() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		System.out.println(search);
		
		RestaurantInfoAdapter restaurantInfoAdapter = new RestaurantInfoAdapter();
		restaurantInfoAdapter.setKeyword(search);
		List<RestaurantInfo> restaurantList = restaurantInfoAdapter.getRestaurantInfoall();
		System.out.println(restaurantList);
		int count = restaurantList.size();
		
		double latitude = 37.276256;
		double longitude = 127.044353; 
		String restaurantName ="키와마루아지";
		int restaurantId = 1;
		String photo ="https://s3-ap-northeast-1.amazonaws.com/dcreviewsresized/20200526105413_photo1_497e1d9676a3.jpg";
		String phoneNum = "031-214-9015";
		String address= "수원시 팔달구 우만동 89-11";
				
		javax.servlet.RequestDispatcher testdata = request.getRequestDispatcher("map.jsp");
		request.setAttribute("search", search);
		request.setAttribute("restaurantList", restaurantList);
		request.setAttribute("count", count);

		request.setAttribute("latitude", latitude);
		request.setAttribute("longitude", longitude);
		request.setAttribute("restaurantName", restaurantName);
		request.setAttribute("restaurantId", restaurantId);
		request.setAttribute("photo", photo);
		request.setAttribute("phoneNum", phoneNum);
		request.setAttribute("address", address);
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
