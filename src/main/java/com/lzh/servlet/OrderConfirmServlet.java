package com.lzh.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lzh.model.Order;
import com.lzh.model.User;
import com.lzh.service.OrderService;


@WebServlet("/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
	private OrderService oService = new OrderService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Order o = (Order) request.getSession().getAttribute("order");
		try {
			BeanUtils.copyProperties(o,request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.setDatetime(new Date());
		o.setStatus(2);
		o.setUser((User) request.getSession().getAttribute("user"));
		oService.addOrder(o);
		request.getSession().removeAttribute("order");
		request.setAttribute("msg","订单支付成功!");
		request.getRequestDispatcher("/order_success.jsp").forward(request, response);
	}

}