package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderDAO;
import com.tap.dd.DBconnect;
import com.tap.model.Order;

public class OrderDAOImpl implements OrderDAO {

    private static final String INSERT = "INSERT INTO orders (userid, restaurentid, orderdate, totalamount, status, paymentmethod) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM orders WHERE orderId=?";
    private static final String UPDATE = "UPDATE orders SET userid=?, restaurentid=?, orderdate=?, totalamount=?, status=?, paymentmethod=? WHERE orderId=?";
    private static final String DELETE = "DELETE FROM orders WHERE orderId=?";
    private static final String SELECT_ALL = "SELECT * FROM orders";

    @Override
    public void addOrder(Order o) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getRestaurantId());
            ps.setString(3, o.getOrderDate());
            ps.setDouble(4, o.getTotalAmount());
            ps.setString(5, o.getStatus());
            ps.setString(6, o.getPaymentMethod());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder(int id) {
        Order o = null;
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                o = extractOrder(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void updateOrder(Order o) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getRestaurantId());
            ps.setString(3, o.getOrderDate());
            ps.setDouble(4, o.getTotalAmount());
            ps.setString(5, o.getStatus());
            ps.setString(6, o.getPaymentMethod());
            ps.setInt(7, o.getOrderId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractOrder(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Order extractOrder(ResultSet rs) throws SQLException {
        return new Order(
                rs.getInt("orderId"),
                rs.getInt("userid"),
                rs.getInt("restaurentid"),
                rs.getString("orderdate"),
                rs.getDouble("totalamount"),
                rs.getString("status"),
                rs.getString("paymentmethod")
        );
    }
}
