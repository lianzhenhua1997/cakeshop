package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.service.UserService;

/**
 * Servlet implementation class AdminUserDeleteServlet
 */
@WebServlet("/admin/user_delete")
public class AdminUserDeleteServlet extends HttpServlet {
	private UserService uService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean isSuccess = uService.delete(id);
		if(isSuccess) {
			request.setAttribute("msg", "客户删除成功！");
		}else {
			request.setAttribute("filMsg", "客户删除失败！客户下有订单，请先删除订单，再删除客户！");
		}
		request.getRequestDispatcher("/admin/user_list").forward(request, response);
	}


}
