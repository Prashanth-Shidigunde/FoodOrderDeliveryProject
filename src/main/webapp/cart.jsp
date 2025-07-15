<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.CartItem, java.util.Map, com.tap.model.Cart, com.tap.model.Restaurant"%>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    Restaurant restaurant = (Restaurant) session.getAttribute("SelectedRestaurant");
    Map<Integer, CartItem> items = (cart != null) ? cart.getItems() : new java.util.HashMap<>();
    double totalPrice = 0;
    for (CartItem ci : items.values()) {
        totalPrice += ci.getPrice() * ci.getQuantity();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .cart-container {
            max-width: 700px;
            background: white;
            margin: 40px auto;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 25px;
        }
        .restaurant-info {
            display: flex;
            align-items: center;
            margin-bottom: 25px;
        }
        .restaurant-info img {
            width: 60px;
            height: 60px;
            border-radius: 8px;
            margin-right: 15px;
        }
        .restaurant-info h2 {
            margin: 0;
            font-size: 22px;
        }
        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
        }
        .item-name {
            font-weight: bold;
            flex: 1;
        }
        .qty-form {
            display: flex;
            align-items: center;
            gap: 8px;
        }
        .qty-form button {
            border: none;
            background: #eee;
            padding: 6px 12px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .qty-form button:disabled {
            cursor: not-allowed;
            background: #ccc;
        }
        .item-price {
            font-weight: bold;
            width: 60px;
            text-align: right;
        }
        .remove-form {
            text-align: right;
        }
        .remove-form button {
            background: none;
            border: none;
            color: red;
            font-size: 13px;
            cursor: pointer;
        }
        .total {
            text-align: right;
            font-size: 18px;
            font-weight: bold;
            margin-top: 25px;
            color: #333;
        }
        .add-more-items {
            text-align: center;
            margin-top: 25px;
        }
        .add-more-items a {
            background-color: #fc8019;
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 6px;
            font-weight: bold;
        }
        .add-more-items a:hover {
            background-color: #e26700;
        }
        .checkout-btn {
            display: block;
            width: 100%;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            padding: 12px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 30px;
        }
        .checkout-btn:hover {
            background-color: #218838;
        }
        .empty-msg {
            text-align: center;
            color: gray;
            margin: 40px 0;
        }
    </style>
</head>
<body>
<div class="cart-container">

    <!-- ✅ Restaurant Info -->
    <div class="restaurant-info">
        <img src="<%= restaurant != null ? restaurant.getImagePath() : "images/placeholder.png" %>" />
        <div>
            <h2><%= restaurant != null ? restaurant.getName() : "Unknown Restaurant" %></h2>
            <p style="color: gray; font-size: 14px;"><%= restaurant != null ? restaurant.getAddress() : "No address available" %></p>
        </div>
    </div>

    <!-- ✅ Cart Items -->
    <% if (items.isEmpty()) { %>
        <p class="empty-msg">Your cart is empty. Add some delicious food!</p>
        <div class="add-more-items">
            <a href="menu?restaurantId=<%= session.getAttribute("restId") %>">Add Items</a>
        </div>
    <% } else {
        for (CartItem ci : items.values()) {
    %>
    <div class="restaurant-info">
        <img src="<%= restaurant != null ? restaurant.getImagePath() : "images/placeholder.png" %>" />
        <div>
            <h2><%= restaurant != null ? restaurant.getName() : "Unknown Restaurant" %></h2>
            <p style="color: gray; font-size: 14px;"><%= restaurant != null ? restaurant.getAddress() : "No address available" %></p>
        </div>
    </div>
    <div class="cart-item">
        <div class="item-name"><%= ci.getName() %></div>
        <div class="qty-form">
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="itemId" value="<%= ci.getItemId() %>"/>
                <input type="hidden" name="quantity" value="<%= ci.getQuantity() - 1 %>"/>
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>"/>
                <button <%= (ci.getQuantity() == 1) ? "disabled" : "" %>>−</button>
            </form>
            <span><%= ci.getQuantity() %></span>
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="itemId" value="<%= ci.getItemId() %>"/>
                <input type="hidden" name="quantity" value="<%= ci.getQuantity() + 1 %>"/>
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>"/>
                <button>+</button>
            </form>
        </div>
        <div class="item-price">₹<%= ci.getPrice() * ci.getQuantity() %></div>
    </div>
    <div class="remove-form">
        <form action="cart" method="post">
            <input type="hidden" name="itemId" value="<%= ci.getItemId() %>"/>
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>"/>
            <button>Remove</button>
        </form>
    </div>
    <% } %>

    <div class="total">Total: ₹<%= totalPrice %></div>

    <div class="add-more-items">
        <a href="menu?restaurantId=<%= session.getAttribute("restId") %>">Add More Items</a>
    </div>

    <form action="checkout.jsp" method="post">
        <input type="submit" value="Proceed to Checkout" class="checkout-btn">
    </form>
    <% } %>

</div>
</body>
</html>
