package com.tap.model;

public class Register {
	
	private String name;
	private String email;
	private String address;
	private String password;
	public Register(String name, String email, String address, String password) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		
		return "Name: "+name+" email: "+email+" Address: "+address+" password: "+password;
	}


}
