package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.Goods;
import com.lzh.service.GoodsService;


@WebServlet("/goodsDetail_list")
public class GoodsDetailServlet extends HttpServlet {
	GoodsService gS = new GoodsService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Goods g = gS.getById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
	}
}
