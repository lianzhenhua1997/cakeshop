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
 * Servlet implementation class AdminPasswordResetServlet
 */
@WebServlet("/admin/password_reset")
public class AdminPasswordResetServlet extends HttpServlet {
	private UserService uS = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String Newpassword = request.getParameter("Newpassword");
		User user = (User) request.getSession().getAttribute("user");
		if(password.equals(user.getPassword())) {
			user.setPassword(Newpassword);
			uS.updateUserPassword(user);
			request.getSession().removeAttribute("user");
//			response.sendRedirect(request.getContextPath()+"/user_login.jsp"); //request.getContextPath() : /web05_cakeshop
			request.setAttribute("msg", "密码修改成功！请重新登录");
			request.getRequestDispatcher("/admin/password_reset.jsp").forward(request, response);
		}else {
			request.setAttribute("filMsg", "密码错误！请再想想。");
			request.getRequestDispatcher("/admin/password_reset.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
