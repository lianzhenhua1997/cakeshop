package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderSubmitServlet
 */
@WebServlet("/order_submit")
public class OrderSubmitServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null) {
			request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
		}else {
			request.setAttribute("filMsg","提交失败，请先登录再提交！！！");
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}
	}
}
