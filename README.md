# 🍕 Food Order Delivery System - Java Web App

A complete **Food Ordering and Delivery System** built using **JSP**, **Servlets**, **JDBC**, and **MySQL**, structured for deployment via **Apache Tomcat**. This project allows customers to browse restaurants and menus, manage their cart, and place orders. Admins can manage food items and orders.

---

## 📁 Project Structure (Based on Eclipse)


MyProject/
├── src/
│ └── main/
│ ├── java/
│ │ └── com.tap.*
│ └── webapp/
│ ├── images/ # Static food/restaurant images
│ ├── items/ # Food item HTML or JSP pages
│ ├── META-INF/
│ ├── WEB-INF/
│ │ └── web.xml # Servlet configuration
│ ├── cart.jsp
│ ├── cart1.jsp
│ ├── home.jsp
│ ├── login.html
│ ├── menu.css
│ ├── menu.jsp
│ ├── register.html
│ ├── rest.css
│ └── restaurants.html
├── mysql-connector-j-9.3.0.jar # JDBC driver
└── build/


---

## 🚀 Features

### 👨‍🍳 Customers
- Register / Login (HTML form)
- Browse food items and restaurants
- Add items to cart
- View and edit cart
- Place orders

### 🔐 Admin (in future or extendable)
- Manage food items (CRUD)
- View order history

---

## 🔧 Technologies Used

- **Frontend**: HTML, JSP, CSS
- **Backend**: Java Servlets, JDBC
- **Database**: MySQL
- **Server**: Apache Tomcat
- **IDE**: Eclipse IDE for Enterprise Java

---

## 🛠️ How to Run

### 1. Clone this Repository
```bash
git clone https://github.com/yourusername/Food-Order-System.git


2. Set Up MySQL

    Create a database:

CREATE DATABASE food_order;
3. Configure DB Connection

In your com.tap.dd.DBConnection class (or similar), set:

String url = "jdbc:mysql://localhost:3306/food_order";
String username = "root";
String password = "your_password";


4. Run in Eclipse

    Import project as Dynamic Web Project

    Add mysql-connector-j-9.3.0.jar to:

        Project Build Path

        WEB-INF/lib folder

    Add the project to Apache Tomcat Server

    Start server
http://localhost:8080/MyProject/login.html


📧 Email: shidigundeprashanth@gmail.com
🔗 GitHub:https://github.com/Prashanth-Shidigunde

