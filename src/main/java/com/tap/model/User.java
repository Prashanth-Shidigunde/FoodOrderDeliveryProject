package com.tap.model;

import java.sql.Timestamp;

public class User {
	private int id;
	private String name;
	private String Username;
	private String password;
	private String Email;
	private String phone;
	private String Address;
	private String role;
	private Timestamp createDate;
	private Timestamp Lastlogindate;
	
	public User(String name, String username, String password, String email, String phone, String address,
			String role) {
		super();
		this.name = name;
		this.Username = username;
		this.password = password;
		this.Email = email;
		this.phone = phone;
		this.Address = address;
		this.role = role;
	}


	public User(int id, String name, String username, String password, String email, String phone,
			String address, String role, Timestamp createDate, Timestamp lastLogindate) {
		super();
		this.id = id;
		this.name = name;
		this.Username = username;
		this.password = password;
		this.Email = email;
		this.phone = phone;
		this.Address = address;
		this.role = role;
		this.createDate = createDate;
		this.Lastlogindate = lastLogindate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastlogindate() {
		return Lastlogindate;
	}

	public void setLastlogindate(Timestamp lastlogindate) {
		Lastlogindate = lastlogindate;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", Username=" + Username + ", password=" + password + ", Email="
				+ Email + ", phone=" + phone + ", Address=" + Address + ", role=" + role
				+ ", createDate=" + createDate + ", Lastlogindate=" + Lastlogindate + "]";
	}
	
	

}
