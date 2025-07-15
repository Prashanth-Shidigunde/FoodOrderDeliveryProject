package com.tap.model;

public class CartItem {
	private int itemId;
	private int rest_id;
	private String name;
	private int quantity;
	private double price;
	public CartItem(int itemId, int rest_id, String name, int quantity, double price) {
		this.itemId = itemId;
		this.rest_id = rest_id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRest_id() {
		return rest_id;
	}
	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
	    return this.price * this.quantity;
	}

	
	public String toString() {
        return "CartItem [ItemId=" + itemId + ", RestaurantId=" + rest_id + ", Name=" + name +
                ", quantity=" + quantity + ", price=" + price + "]";
    }

}
