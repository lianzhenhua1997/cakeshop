package com.lzh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.Order;
import com.lzh.model.User;
import com.lzh.service.OrderService;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
	private OrderService oService = new OrderService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("user");
		List<Order> list = oService.selectAll(u.getId());
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}
}
