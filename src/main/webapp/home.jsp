<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "com.tap.model.Restaurant, java.util.* " %>   
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>FoodMate - Explore Restaurants</title>
  <link rel="stylesheet" href="rest.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav>
    <div class="nav-left">
      <div class="logo"><span>🍴</span> FoodMate</div>
    </div>
    <div class="nav-center">
      <input type="text" placeholder="Search restaurants, dishes...">
    </div>
    <div class="nav-right">
      <a href="#">Home</a>
      <a href="#">Explore</a>
      <a href="#">Offers</a>
      <a href="#">Contact</a>
      <button class="login-btn">Login</button>
    </div>
  </nav>

  <!-- Restaurant Cards -->
  <div class="container">
    
    <%
    		List<Restaurant> rest=(List<Restaurant>)request.getAttribute("allRest");
    
    		for(Restaurant r:rest){
    			
    			%>
    			<a href="menu?restaurantId=<%= r.getRestId() %>" style="text-decoration: none">
    			<div class="card">
    		      <img src=<%= r.getImagePath() %> alt="Restaurant 1">
    		      <div class="card-content">
    		        <h3><%= r.getName() %></h3>
    		        <p><%= r.getCuisineType() %></p>
    		        <div class="info">
    		          <span class="rating"><%= r.getRating() %>★</span>
    		          <span><%= r.getDeliveryTime() %></span>
    		        </div>
    		      </div>
    		    </div>
    		    </a>
    		    <%} %>
    		 
    			
    		
  
    

    <!-- Duplicate for up to 20 restaurants -->
  </div>

</body>
</html>
    