package com.tap.dao;

import java.util.List;
import com.tap.model.Restaurant;

public interface RestaurantDAO {
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(int id);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id);
    List<Restaurant> getAllRestaurants();
}
