package com.lzh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import com.lzh.model.Goods;
import com.lzh.model.Page;
import com.lzh.model.Type;
import com.lzh.service.GoodsService;
import com.lzh.service.TypeService;


@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
	private GoodsService gS = new GoodsService();
	private TypeService tS = new TypeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		int pageNo =1;
		if(request.getParameter("pageNo")!=null) {  //pageNo 是来自网页上..？后面传递的参数
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
//		List<Goods> list = gS.selectGoods(id, pageNo, 8);
//		request.setAttribute("list", list);
		Page p = gS.getGoodsPage(id, pageNo);
		request.setAttribute("p", p);
		request.setAttribute("id", id);
		Type t = null;
		if(id!=0) {
			t=tS.select(id);
		}
		request.setAttribute("t", t);
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}

	

}
