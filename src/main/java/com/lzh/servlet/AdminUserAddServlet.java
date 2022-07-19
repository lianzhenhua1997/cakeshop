package com.lzh.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lzh.dao.UserDao;
import com.lzh.model.User;
import com.lzh.service.UserService;

/**
 * Servlet implementation class AdminUserAddServlet
 */
@WebServlet("/admin/user_add")
public class AdminUserAddServlet extends HttpServlet {
	private UserService us = new UserService();
	private UserDao uDao = new UserDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.copyProperties(user,request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(us.register(user)) {
			request.setAttribute("msg", "客户添加成功！");
			request.getRequestDispatcher("/admin/user_list").forward(request, response);
		}else {
			request.setAttribute("filMsg", "注册失败！用户名或邮箱重复！");
			request.setAttribute("u", user);
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);
		}
	}

}
