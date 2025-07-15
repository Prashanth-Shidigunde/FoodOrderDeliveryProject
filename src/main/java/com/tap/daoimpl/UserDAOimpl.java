package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.UserDAO;
import com.tap.dd.DBconnect;
import com.tap.model.User;

public class UserDAOimpl implements UserDAO {
	private static String INSERT="INSERT INTO user (`name`, `username`, `password`, `email`, `phone`, `address`, `role`,`createDate`,`last_login_date`)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?,?,?);";
	private static String getUser = "select * from user where `id`=?";
	private static String update = "update `user` set `name` = ? ,`username`=? ,`password`=? ,`email`=?, `phone` = ?, `address`=? ,`role` = ? where `name`=?" ;
	private static String deleteUser = "delete from `user` where `id`=?";
	private static String get_all = "select * from `user`";
	private static String getUserByName = "select * from user where `username`=?";

	@Override
	public void adduser(User user) {
		Connection con=DBconnect.dbCon();	
		try(PreparedStatement pstmt = con.prepareStatement(INSERT)) {

			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhone());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User getUser(int userId) {

		User user = null;
		Connection con=DBconnect.dbCon();
		
		try(PreparedStatement pstmt = con.prepareStatement(getUser)) {

			pstmt.setInt(1,userId);
			ResultSet res = pstmt.executeQuery();
			
				user = extractUser(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public User getUser(String name) {

		User user = null;
		Connection con=DBconnect.dbCon();
		
		try(PreparedStatement pstmt = con.prepareStatement(getUserByName)) {

			pstmt.setString(1,name);
			ResultSet res = pstmt.executeQuery();
			
				user = extractUser(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
			Connection con=DBconnect.dbCon();
			try(PreparedStatement pstmt = con.prepareStatement(update)) {

				pstmt.setString(1, user.getName());
				pstmt.setString(2,user.getUsername());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getAddress());
				pstmt.setString(7, user.getRole());
				pstmt.setString(8, user.getName());
				int i = pstmt.executeUpdate();
				System.out.println(i);
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

	@Override
	public void deleterUser(int userId) {
		Connection con=DBconnect.dbCon();
		try(PreparedStatement pstmt = con.prepareStatement(deleteUser)) {

			pstmt.setInt(1, userId);
			int i = pstmt.executeUpdate();
			System.out.println(userId+" delete successfully");
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			Connection con = DBconnect.dbCon();
			PreparedStatement stmt = con.prepareStatement(get_all);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				User user = extractUser(res);
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	User extractUser(ResultSet res) throws SQLException{
		User user=null;
		if(res.next()) {
		int userId = res.getInt(1);
		String name = res.getString(2);
		String userName = res.getString(3);
		String password = res.getString(4);
		String email = res.getString(5);
		String phone =res.getString(6);
		String address = res.getString(7);
		String role = res.getString(8);
		Timestamp created = res.getTimestamp(9);
		Timestamp lastlogin = res.getTimestamp(10);
		
		user = new User(userId, name, userName, password, email, phone, address, role, created, lastlogin);
		}
		return user;
		
	}
	 public boolean emailExists(String email) {
	        boolean exists = false;
	        Connection dbCon = DBconnect.dbCon();
	        try {
	            String query = "SELECT * FROM user WHERE email = ?";
	            PreparedStatement stmt = dbCon.prepareStatement(query);
	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();
	            exists = rs.next(); // true if email exists
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return exists;
	    }

}
