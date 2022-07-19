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
 * Servlet implementation class AdminUserEditServlet
 */
@WebServlet("/admin/user_edit")
public class AdminUserEditServlet extends HttpServlet {
	private UserService uService = new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		try {
			BeanUtils.copyProperties(u,request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uService.updateUserAddress(u);
		request.getRequestDispatcher("/admin/user_list").forward(request, response);
	}

}
