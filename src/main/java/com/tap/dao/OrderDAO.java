package com.tap.dao;

import java.util.List;
import com.tap.model.Order;

public interface OrderDAO {
    void addOrder(Order order);
    Order getOrder(int id);
    void updateOrder(Order order);
    void deleteOrder(int id);
    List<Order> getAllOrders();
}
