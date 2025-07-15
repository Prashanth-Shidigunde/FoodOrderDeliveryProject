package com.tap.model;

public class Restaurant {
    private int restId;
    private String name;
    private String address;
    private String phone;
    private String cuisineType;
    private String deliveryTime;
    private int adminUserId;
    private double rating;
    private String isActive;
    private String imagePath;

    // Constructor without ID (for insertion)
    public Restaurant(String name, String address, String phone, String cuisineType, String deliveryTime,
                      int adminUserId, double rating, String isActive, String imagePath) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cuisineType = cuisineType;
        this.deliveryTime = deliveryTime;
        this.adminUserId = adminUserId;
        this.rating = rating;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }

    // Full constructor
    public Restaurant(int restId, String name, String address, String phone, String cuisineType, String deliveryTime,
                      int adminUserId, double rating, String isActive, String imagePath) {
        this(name, address, phone, cuisineType, deliveryTime, adminUserId, rating, isActive, imagePath);
        this.restId = restId;
    }

    // Getters and Setters
    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(int adminUserId) {
        this.adminUserId = adminUserId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Restaurant [restId=" + restId + ", name=" + name + ", address=" + address + ", phone=" + phone +
                ", cuisineType=" + cuisineType + ", deliveryTime=" + deliveryTime + ", adminUserId=" + adminUserId +
                ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
    }
}
