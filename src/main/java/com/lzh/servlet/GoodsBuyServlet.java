package com.lzh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzh.model.Goods;
import com.lzh.model.Order;
import com.lzh.service.GoodsService;


@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	private GoodsService gS = new GoodsService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o =null;
		if(request.getSession().getAttribute("order")!=null) {
			o = (Order) request.getSession().getAttribute("order");
		}else {
			o = new Order();
			request.getSession().setAttribute("order", o);
		}
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		Goods goods =gS.getById(goodsid);
		if(goods.getStock()>0) {
			o.addGoods(goods);
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("fail");
		}
	}

}
