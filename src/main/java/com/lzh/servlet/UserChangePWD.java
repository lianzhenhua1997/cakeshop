package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.User;
import com.lzh.service.UserService;


@WebServlet("/user_changepwd")
public class UserChangePWD extends HttpServlet {
	private UserService uS = new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String Newpassword = request.getParameter("Newpassword");
		User user = (User) request.getSession().getAttribute("user");
		if(password.equals(user.getPassword())) {
			user.setPassword(Newpassword);
			uS.updateUserPassword(user);
			request.setAttribute("msg", "密码修改成功！");
			request.getRequestDispatcher("/user_center.jsp").forward(request, response);
		}else {
			request.setAttribute("filmsg", "密码错误！请再想想。");
			request.getRequestDispatcher("/user_center.jsp").forward(request, response);
		}
	}

}
