package com.lzh.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lzh.model.User;
import com.lzh.service.UserService;

/**
 * Servlet implementation class AdminUserResetServlet
 */
@WebServlet("/admin/user_reset")
public class AdminUserResetServlet extends HttpServlet {
	private UserService uService = new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.copyProperties(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uService.updateUserPassword(user);
		request.getRequestDispatcher("/admin/user_list").forward(request, response);
	}

}
