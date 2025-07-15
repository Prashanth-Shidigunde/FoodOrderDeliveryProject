package com.tap.model;

public class Menu {
    private int menuId;
    private int restId;
    private String itemName;
    private String description;
    private double price;
    private String isAvailable;
    private double ratings;
    private String imagePath;

    // Constructor without menuId (for insertion)
    public Menu(int restId, String itemName, String description, double price, String isAvailable, double ratings, String imagePath) {
        this.restId = restId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.ratings = ratings;
        this.imagePath = imagePath;
    }

    // Full constructor
    public Menu(int menuId, int restId, String itemName, String description, double price, String isAvailable, double ratings, String imagePath) {
        this(restId, itemName, description, price, isAvailable, ratings, imagePath);
        this.menuId = menuId;
    }

    // Getters and Setters
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menuId + ", restId=" + restId + ", itemName=" + itemName + ", description=" + description +
                ", price=" + price + ", isAvailable=" + isAvailable + ", ratings=" + ratings + ", imagePath=" + imagePath + "]";
    }
}
