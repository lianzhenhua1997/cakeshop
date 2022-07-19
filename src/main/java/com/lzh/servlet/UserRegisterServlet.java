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


@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
	private UserService us = new UserService();
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
			request.setAttribute("msg", "恭喜！注册成功,请登录！");
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "注册失败！用户名或邮箱重复！");
			request.getRequestDispatcher("user_register.jsp").forward(request, response);
		}
	}

}
