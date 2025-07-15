package com.tap.dao;

import java.util.List;
import com.tap.model.OrderItem;

public interface OrderItemDAO {
    void addOrderItem(OrderItem item);
    OrderItem getOrderItem(int id);
    void updateOrderItem(OrderItem item);
    void deleteOrderItem(int id);
    List<OrderItem> getOrderItemsByOrderId(int orderId);
    List<OrderItem> getAllOrderItems();
}
