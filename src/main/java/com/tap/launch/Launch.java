package com.tap.launch;

import java.util.Scanner;

import com.tap.daoimpl.UserDAOimpl;
import com.tap.model.User;


public class Launch {
	
	public static void main(String[] args) {
		
		UserDAOimpl ui =new UserDAOimpl();
		User us=null;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Do you want add user (yes/no)");
		String decide = scanner.nextLine();
		if(decide.equalsIgnoreCase("yes")) {
		System.out.println("Enter Name");
		String name = scanner.next();
		System.out.println("Enter User Name");
		String uname = scanner.next();
		System.out.println("Enter Password");
		String pwd = scanner.next();
		System.out.println("Enter email");
		String email = scanner.next();
		System.out.println("Enter phone number");
		String phone = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Address");
		String address = scanner.nextLine();
		System.out.println("Enter Role");
		String role = scanner.nextLine();
		
		User u=new User(name, uname, pwd, email, phone, address, role);
		
		ui.adduser(u);
		}
		
		
		System.out.println("Do you want delete user by id (yes/no");
		String decideDel = scanner.nextLine();
		if(decideDel.equalsIgnoreCase("yes")) {
			System.err.println("Enter id");
			int id=scanner.nextInt();
			ui.deleterUser(id);
		}
		System.out.println("Do you want to get User By Name (yes/no)");
		decide= scanner.nextLine();
		if(decide.equalsIgnoreCase("yes")) {
			System.out.println("Enter username");
			String user = scanner.nextLine();
			us = ui.getUser(user);
			System.out.println(us.toString());
			System.out.print(us.getAddress());
		}
		scanner.close();
	}

}
