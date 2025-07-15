
package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    // Add item to cart
    public void addItem(CartItem ci) {
        int itemId = ci.getItemId();
        if (items.containsKey(itemId)) {
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + ci.getQuantity());
        } else {
            items.put(itemId, ci);
        }
    }

    // Update quantity of item in cart
    public void updateItem(int itemId, int quantity) {
        //int itemId = itemId2.getItemId();
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                CartItem existingItem = items.get(itemId);
                existingItem.setQuantity(quantity);
            }
        }
    }

    // Remove item from cart
    public void removeItem(int itemId) {
     
        items.remove(itemId);
    }

    // Optional: get all items
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Optional: clear entire cart
    public void clearCart() {
        items.clear();
    }

    // Optional: calculate total cost
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
