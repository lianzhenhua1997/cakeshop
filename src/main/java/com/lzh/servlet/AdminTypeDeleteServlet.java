package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.service.TypeService;

/**
 * Servlet implementation class AdminTypeDeleteServlet
 */
@WebServlet("/admin/type_delete")
public class AdminTypeDeleteServlet extends HttpServlet {
	private TypeService tS = new TypeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean isSuccess =  tS.delete(id);
		if(isSuccess) {
			request.setAttribute("msg", "删除成功！");
		}else {
			request.setAttribute("filMsg", "删除失败，其下有订单！！！");
		}
		request.getRequestDispatcher("/admin/type_list").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
