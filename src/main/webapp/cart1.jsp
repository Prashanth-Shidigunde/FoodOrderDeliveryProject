<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.CartItem, java.util.Map, com.tap.model.Cart, com.tap.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<!-- ✅ You can extract this into cart.css -->
<style>
body {
    font-family: 'Segoe UI', sans-serif;
    background-color: #f7f7f7;
    margin: 0;
    padding: 20px;
}

.cart-item {
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    padding: 20px;
    margin-bottom: 20px;
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
}

.cart-item-details h3 {
    margin: 0 0 10px;
    font-size: 18px;
}

.cart-item-details p {
    margin: 5px 0;
    color: #555;
}

.quantity-controls {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
}

.quantity-btn {
    padding: 6px 12px;
    background-color: #ddd;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-weight: bold;
}

.quantity-btn:disabled {
    background-color: #ccc;
    cursor: not-allowed;
}

.remove-btn {
    background: none;
    border: none;
    color: red;
    font-size: 14px;
    cursor: pointer;
    margin-top: 10px;
}

.total {
    text-align: right;
    font-size: 18px;
    font-weight: bold;
    margin-top: 20px;
    color: #333;
}

.odd-more-items {
    text-align: center;
    margin-top: 20px;
}

.odd-more-items a, .add-more-items a {
    background-color: #fc8019;
    color: white;
    text-decoration: none;
    padding: 10px 20px;
    border-radius: 6px;
    display: inline-block;
    font-weight: bold;
    transition: 0.3s ease;
}

.odd-more-items a:hover, .add-more-items a:hover {
    background-color: #e26700;
}

.proceed-to-checkout-btn {
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

.proceed-to-checkout-btn:hover {
    background-color: #218838;
}

.add-more-items {
    text-align: center;
    margin-top: 20px;
}
</style>
</head>

<body>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restId = (Integer) session.getAttribute("restId");

    if (cart != null && !cart.getItems().isEmpty()) {
        for (CartItem item : cart.getItems().values()) {
%>
    <div class="cart-item">
        <div class="cart-item-details">
            <h3><%= item.getName() %></h3>
            <p>Price: ₹<%= item.getPrice() %></p>
            <p>Total: ₹<%= item.getTotalPrice() %></p>
            <div class="quantity-controls">
                <form action="cart" method="post" style="display: inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                    <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>">
                    <button class="quantity-btn">+</button>
                </form>
                <p><%= item.getQuantity() %></p>
                <form action="cart" method="post" style="display: inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                    <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>">
                    <button class="quantity-btn" <% if (item.getQuantity() == 1) { %>disabled<% } %>>-</button>
                </form>
            </div>
        </div>

        <form action="cart" method="post">
            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="restId" value="<%= session.getAttribute("restId") %>"/>
            <button class="remove-btn">Remove</button>
        </form>
    </div>
<%
        }
%>
    <div class="total">
        Grand Total: ₹<%= cart.getTotalPrice() %>
    </div>
    <div class="odd-more-items">
        <a href="menu?restaurantId=<%= session.getAttribute("restId") %>">Add More Items</a>
    </div>
<%
    } else {
%>

	
    <p style="text-align: center; color: #757575;">Your cart is empty.</p>
    <div class="add-more-items">
        <a href="menu?restaurantId=<%= session.getAttribute("restId") %>">Add Items</a>
    </div>
<%
    }
%>

<% if (cart != null && !cart.getItems().isEmpty()) { %>
    <form action="checkout.jsp" method="post">
        <input type="submit" value="Proceed to Checkout" class="proceed-to-checkout-btn">
    </form>
<% } %>

</body>
</html>
