package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import com.lzh.model.Goods;
import com.lzh.service.GoodsService;

/**
 * Servlet implementation class AdminGoodsEditServlet
 */
@WebServlet("/admin/goods_editshow")
public class AdminGoodsEditShowServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Goods g = gService.getById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("/admin/goods_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
