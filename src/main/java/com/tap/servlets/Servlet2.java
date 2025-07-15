package com.tap.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import com.tap.daoimpl.UserDAOimpl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		UserDAOimpl ui=new UserDAOimpl();
		User user=ui.getUser(name);
		if(user!=null && name.equals(user.getUsername()) && password.equals(user.getPassword())) {
			writer.println("Hi, "+name+" welcome to homepage");
		}
		else if(count>0) {
			writer.println("you have "+(count--)+ " Attempts");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else {
			writer.println("please Contact admin");
		}
	}

}
