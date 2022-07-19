package com.lzh.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lzh.model.User;
import com.lzh.service.UserService;


@WebServlet("/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
	private UserService uS = new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		try {
			request.setCharacterEncoding("utf-8");  //解决下面Map获得地址是的乱码问题
			BeanUtils.copyProperties(user,request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uS.updateUserAddress(user);
		request.setAttribute("msg", "收件信息更新成功！");
		request.getRequestDispatcher("/user_center.jsp").forward(request, response);
	}

}
