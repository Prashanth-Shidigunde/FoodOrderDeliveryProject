package com.tap.servlets;

import java.io.IOException;

import com.tap.dao.MenuDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		Cart cart = (Cart) ses.getAttribute("cart");

		String restIdStr = req.getParameter("restId"); // ✅ null check needed
		if (restIdStr == null || restIdStr.isEmpty()) {
			res.sendRedirect("menu.jsp?error=restId_missing");
			return;
		}

		int restIdParam = Integer.parseInt(restIdStr); // ✅ Only parsed after check
		Integer currentRest = (Integer) ses.getAttribute("restId");

		if (cart == null || currentRest == null || restIdParam != currentRest) {
			cart = new Cart();
			ses.setAttribute("cart", cart);
			ses.setAttribute("restId", restIdParam);
		}

		String action = req.getParameter("action");

		try {
			if (action != null && action.equalsIgnoreCase("add")) {
				addItemToCart(req, cart);
			} else if (action != null && action.equalsIgnoreCase("update")) {
				updateCart(req, cart);
			} else if (action != null && action.equalsIgnoreCase("delete")) {
				delete(req, cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		res.sendRedirect("cart1.jsp");
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		try {
			String itemIdStr = req.getParameter("itemId");
			String quantityStr = req.getParameter("quantity");

			// ✅ Safely check for null before parsing
			if (itemIdStr == null || quantityStr == null) return;

			int itemId = Integer.parseInt(itemIdStr);
			int quantity = Integer.parseInt(quantityStr);

			MenuDAO menuDAO = new MenuDAOImpl();
			Menu menuItem = menuDAO.getMenu(itemId);

			System.out.println("the menu in Cart servltet" + menuItem);

			if (menuItem != null) {
				CartItem item = new CartItem(
					menuItem.getMenuId(),
					menuItem.getRestId(),
					menuItem.getItemName(),
					quantity,
					menuItem.getPrice() // You can change to menuItem.getPrice() if needed
				);
				cart.addItem(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateCart(HttpServletRequest req, Cart cart) {
		try {
			int itemId = Integer.parseInt(req.getParameter("itemId"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			cart.updateItem(itemId, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest req, Cart cart) {
		try {
			int itemId = Integer.parseInt(req.getParameter("itemId"));
			cart.removeItem(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
