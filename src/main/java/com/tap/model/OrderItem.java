package com.tap.model;

public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int menuId;
    private int quantity;
    private double itemTotal;

    // Constructor without ID (for insertion)
    public OrderItem(int orderId, int menuId, int quantity, double itemTotal) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    // Full constructor
    public OrderItem(int orderItemId, int orderId, int menuId, int quantity, double itemTotal) {
        this(orderId, menuId, quantity, itemTotal);
        this.orderItemId = orderItemId;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Override
    public String toString() {
        return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId +
                ", quantity=" + quantity + ", itemTotal=" + itemTotal + "]";
    }
}
