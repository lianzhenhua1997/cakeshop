package com.lzh.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.service.GoodsService;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//横幅
		Map<String, Object> scrollGoods = gService.getScrollGoods();
		request.setAttribute("scroll", scrollGoods);
		//热销
		List<Map<String, Object>> hotList = gService.getGoods();
		request.setAttribute("hotList", hotList);
		//新品
		List<Map<String, Object>> newList = gService.getNewGoods();
		request.setAttribute("newList", newList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	

}
