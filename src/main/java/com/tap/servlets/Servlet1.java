package com.tap.servlets;

import java.io.*;
import java.io.PrintWriter;

import com.tap.daoimpl.UserDAOimpl;
import com.tap.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class Servlet1 extends HttpServlet{
	
	protected void service(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException {
		String name= req.getParameter("name");
		String userName = req.getParameter("username");
		String passowrd = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		User user = new User(name, userName, passowrd, email, phone, address, role);
		UserDAOimpl ui =new UserDAOimpl();
		
		User user2 = ui.getUser(userName);
		
		PrintWriter writer = res.getWriter();
		
		if(user2!=null && userName.equalsIgnoreCase(user2.getUsername())) {
			writer.print("This data already exist please change email");
		}
		else {
			ui.adduser(user);
			writer.println("Succefully completed your work : "+ name);
			
		}
//		if(ui.emailExists(email)) {
//			writer.print("This data already exist please change email");
//		}
//		else {
//			ui.adduser(user);
//			writer.println("Succefully completed your work : "+ name);
//		}
		
		
		
		
		
	}
	

}
