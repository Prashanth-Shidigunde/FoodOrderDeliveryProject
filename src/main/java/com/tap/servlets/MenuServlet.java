package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("Hi this is menuServlet");
		
		int ri = Integer.parseInt(req.getParameter("restaurantId"));
		
		try {
			MenuDAOImpl menu = new MenuDAOImpl();
			List<Menu> allmenu = menu.getMenusByRestaurant(ri);
			RestaurantDAOImpl restDao = new RestaurantDAOImpl();
			Restaurant rest = restDao.getRestaurant(ri);
			 // ✅ Save the restaurant in session so that CartServlet and cart.jsp can use it
            req.getSession().setAttribute("SelectedRestaurant", rest);
            
            String name = rest.getName();
            System.out.println(name);
			for(Menu am : allmenu) {
				System.out.println(am);
			}
			req.setAttribute("restName",name );
			req.setAttribute("allmenu", allmenu);
			
			RequestDispatcher dp = req.getRequestDispatcher("menu.jsp");
			dp.forward(req, res);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
