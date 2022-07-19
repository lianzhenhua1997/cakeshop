package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.Page;
import com.lzh.service.GoodsService;


@WebServlet("/goodsRecommend_list")
public class GoodsRecommendServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		Page p = gService.getGoodsRecommendPage(type, pageNo);
		request.setAttribute("p", p);
		request.setAttribute("t", type);
		request.getRequestDispatcher("/goodsRecommend_list.jsp").forward(request, response);
	}

	

}
