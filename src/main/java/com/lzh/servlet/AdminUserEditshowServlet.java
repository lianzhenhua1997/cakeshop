package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.User;
import com.lzh.service.UserService;

/**
 * Servlet implementation class AdminUserEditshowServlet
 */
@WebServlet("/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
	private UserService uService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));//id:来自于 ？id${u.id} 也就是地址后面的？-参数
		User user = uService.selectById(id);
		request.setAttribute("u", user);
		request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
	}

}
