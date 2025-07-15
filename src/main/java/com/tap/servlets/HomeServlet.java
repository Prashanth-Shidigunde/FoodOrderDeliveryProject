package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurant")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("Welcome to restaurant");
		try {
			RestaurantDAOImpl rest = new RestaurantDAOImpl();
			List<Restaurant> allRest = rest.getAllRestaurants();
			for(Restaurant r : allRest) {
				System.out.println(r);
			}
			
			req.setAttribute("allRest", allRest);
			
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
