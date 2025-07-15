package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderItemDAO;
import com.tap.dd.DBconnect;
import com.tap.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT = "INSERT INTO orderitem (orderid, menuid, quantity, itemtotal) VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM orderitem WHERE orderitemid=?";
    private static final String UPDATE = "UPDATE orderitem SET orderid=?, menuid=?, quantity=?, itemtotal=? WHERE orderitemid=?";
    private static final String DELETE = "DELETE FROM orderitem WHERE orderitemid=?";
    private static final String SELECT_BY_ORDERID = "SELECT * FROM orderitem WHERE orderid=?";
    private static final String SELECT_ALL = "SELECT * FROM orderitem";

    @Override
    public void addOrderItem(OrderItem item) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getItemTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int id) {
        OrderItem item = null;
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = extractOrderItem(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void updateOrderItem(OrderItem item) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getItemTotal());
            ps.setInt(5, item.getOrderItemId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int id) {
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ORDERID)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractOrderItem(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> list = new ArrayList<>();
        try (Connection con = DBconnect.dbCon();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extractOrderItem(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private OrderItem extractOrderItem(ResultSet rs) throws SQLException {
        return new OrderItem(
                rs.getInt("orderitemid"),
                rs.getInt("orderid"),
                rs.getInt("menuid"),
                rs.getInt("quantity"),
                rs.getDouble("itemtotal")
        );
    }
}
