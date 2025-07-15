package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.MenuDAO;
import com.tap.dd.DBconnect;
import com.tap.model.Menu;

public class MenuDAOImpl implements MenuDAO {

    private static final String INSERT = "INSERT INTO menu (rest_id, itemname, description, price, isavailable, ratings, imagepath) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM menu WHERE menuId=?";
    private static final String UPDATE = "UPDATE menu SET rest_id=?, itemname=?, description=?, price=?, isavailable=?, ratings=?, imagepath=? WHERE menuId=?";
    private static final String DELETE = "DELETE FROM menu WHERE menuId=?";
    private static final String SELECT_ALL = "SELECT * FROM menu";
    private static final String SELECT_BY_RESTAURANT = "SELECT * FROM menu WHERE rest_id=?";

    @Override
    public void addMenu(Menu menu) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, menu.getRestId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getIsAvailable());
            ps.setDouble(6, menu.getRatings());
            ps.setString(7, menu.getImagePath());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {
        Menu menu = null;
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT)) {
            ps.setInt(1, menuId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menu = extractMenu(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateMenu(Menu menu) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, menu.getRestId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getIsAvailable());
            ps.setDouble(6, menu.getRatings());
            ps.setString(7, menu.getImagePath());
            ps.setInt(8, menu.getMenuId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(DELETE)) {
            ps.setInt(1, menuId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractMenu(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Menu> getMenusByRestaurant(int restId) {
        List<Menu> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_RESTAURANT)) {
            ps.setInt(1, restId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractMenu(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Menu extractMenu(ResultSet rs) throws SQLException {
        return new Menu(
                rs.getInt("menuId"),
                rs.getInt("rest_id"),
                rs.getString("itemname"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getString("isavailable"),
                rs.getDouble("ratings"),
                rs.getString("imagepath")
        );
    }
}
