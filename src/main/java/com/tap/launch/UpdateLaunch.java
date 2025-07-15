package com.tap.launch;

import java.util.Scanner;

import com.tap.daoimpl.UserDAOimpl;
import com.tap.model.User;


public class UpdateLaunch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = scanner.nextInt();
		
		UserDAOimpl ui =new UserDAOimpl();
		
		User u = ui.getUser(id);
		System.out.println(u);
		
		System.out.println("Enter Name");
		String name = scanner.nextLine();
		System.out.println("Enter User Name");
		String uname = scanner.nextLine();
		System.out.println("Enter Password");
		String pwd = scanner.nextLine();
		System.out.println("Enter email");
		String email = scanner.nextLine();
		System.out.println("Enter phone number");
		String phone = scanner.nextLine();
		System.out.println("Enter Address");
		String address = scanner.nextLine();
		System.out.println("Enter Role");
		String role = scanner.nextLine();
		
		u.setPassword(pwd);
		u.setAddress(address);
		u.setPhone(phone);
		
		ui.updateUser(u);
		
		
		
//		User us=new User(name,uname,pwd,email,phone,address,role);
		
		scanner.close();
	}

}
