package com.tap.model;

public class Order {
    private int orderId;
    private int userId;
    private int restaurantId;
    private String orderDate;
    private double totalAmount;
    private String status;
    private String paymentMethod;

    // Constructor without ID (for insertion)
    public Order(int userId, int restaurantId, String orderDate, double totalAmount, String status, String paymentMethod) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    // Full constructor
    public Order(int orderId, int userId, int restaurantId, String orderDate, double totalAmount, String status, String paymentMethod) {
        this(userId, restaurantId, orderDate, totalAmount, status, paymentMethod);
        this.orderId = orderId;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId +
                ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status +
                ", paymentMethod=" + paymentMethod + "]";
    }
}
