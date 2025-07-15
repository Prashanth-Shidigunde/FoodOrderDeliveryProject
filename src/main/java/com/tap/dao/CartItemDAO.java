package com.tap.dao;

import com.tap.model.CartItem;
import java.util.List;

public interface CartItemDAO {
    void addCartItem(CartItem ci);
    void updateCartItem(CartItem ci, int quantity);
    void removeCartItem(CartItem ci);
    List<CartItem> getAllCartItems(); // Optional, if you want to list cart items
}
