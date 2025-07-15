package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.RestaurantDAO;
import com.tap.dd.DBconnect;
import com.tap.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

    private static final String INSERT = "INSERT INTO restaurant (name, address, phone, cuisinetype, deliverytime, adminuserid, rating, isactive, imagepath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM restaurant WHERE rest_id=?";
    private static final String UPDATE = "UPDATE restaurant SET name=?, address=?, phone=?, cuisinetype=?, deliverytime=?, adminuserid=?, rating=?, isactive=?, imagepath=? WHERE rest_id=?";
    private static final String DELETE = "DELETE FROM restaurant WHERE rest_id=?";
    private static final String SELECT_ALL = "SELECT * FROM restaurant";

    @Override
    public void addRestaurant(Restaurant r) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getPhone());
            ps.setString(4, r.getCuisineType());
            ps.setString(5, r.getDeliveryTime());
            ps.setInt(6, r.getAdminUserId());
            ps.setDouble(7, r.getRating());
            ps.setString(8, r.getIsActive());
            ps.setString(9, r.getImagePath());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int id) {
        Restaurant r = null;
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = extractRestaurant(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public void updateRestaurant(Restaurant r) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setString(3, r.getPhone());
            ps.setString(4, r.getCuisineType());
            ps.setString(5, r.getDeliveryTime());
            ps.setInt(6, r.getAdminUserId());
            ps.setDouble(7, r.getRating());
            ps.setString(8, r.getIsActive());
            ps.setString(9, r.getImagePath());
            ps.setInt(10, r.getRestId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int id) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractRestaurant(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Restaurant extractRestaurant(ResultSet rs) throws SQLException {
        return new Restaurant(
                rs.getInt("rest_id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("cuisinetype"),
                rs.getString("deliverytime"),
                rs.getInt("adminuserid"),
                rs.getDouble("rating"),
                rs.getString("isactive"),
                rs.getString("imagepath")
        );
    }
}
