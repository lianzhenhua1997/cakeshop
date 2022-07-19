package com.lzh.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzh.dao.OrderDao;
import com.lzh.model.Goods;
import com.lzh.model.Order;
import com.lzh.model.OrderItem;
import com.lzh.model.Page;
import com.lzh.util.DBUtil;

public class OrderService {
	private OrderDao oDao = new OrderDao();
	public void addOrder(Order order){
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			oDao.insertOrder(con, order);
			int id = oDao.getLastInsertId(con);
			order.setId(id);
			for(OrderItem item : order.getItemMap().values()) {
				oDao.insertOrderItem(con, item);
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	public List<Order> selectAll(int userid){	
	List<Order> list = null;
	try {
		list = oDao.selectAll(userid);
		for(Order o : list) {
			List<OrderItem> li = oDao.selectAllItem(o.getId());
			o.setItemList(li);	
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	public Page getOrderPage(int status, int pageNo) {
		int pageSize = 10;
		Page p =new Page();
		p.setPageNumber(pageNo);
		int totalCount = 0;
		try {
			totalCount = oDao.getOrderCount(status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize,totalCount);
		List list = null;
		try {
			list = oDao.selectOrder(status, pageNo, pageSize);
			for(Order o : (List<Order>)list) {
				List<OrderItem> li = oDao.selectAllItem(o.getId());
				o.setItemList(li);	
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public void updateStatus(int id,int status){
		try {
			oDao.updateStatus(id, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			oDao.deleteOrderItem(con, id);
			oDao.deleteOrder(con, id);
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(con!=null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
}
