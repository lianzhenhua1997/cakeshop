package com.lzh.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lzh.dao.GoodsDao;
import com.lzh.model.Goods;
import com.lzh.model.Page;

public class GoodsService {
	private GoodsDao gDao = new GoodsDao();
	public  List<Map<String, Object>> getGoods(){
		List<Map<String, Object>> list = null;
		try {
			list = gDao.getGoods(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public  List<Map<String, Object>> getNewGoods(){
		List<Map<String, Object>> list = null;
		try {
			list = gDao.getGoods(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public  Map<String, Object> getScrollGoods(){
		Map<String, Object> map = null;
		try {
			map = gDao.getScrollGoods();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
//	public List<Goods> selectGoods(int typeId,int pageNo,int pageSize){
//		List<Goods> list = null;
//		try {
//			list = gDao.selectGoods(typeId, pageNo, pageSize);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	public Page getGoodsPage(int typeId,int pageNo) {
		Page p =new Page();
		p.setPageNumber(pageNo);
		int totalCount = 0;
		try {
			totalCount = gDao.getGoodsCount(typeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8,totalCount);
		List<Goods> list = null;
		try {
			list = gDao.selectGoods(typeId, pageNo, 8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public Page getGoodsRecommendPage(int type,int pageNo){
		Page p =new Page();
		p.setPageNumber(pageNo);
		int totalCount = 0;
		try {
			totalCount = gDao.getGoodsRecommendCount(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8,totalCount);
		List<Goods> list = null;
		try {
			list = gDao.selectGoodsRecommend(type, pageNo, 8);
			for(Goods g : (List<Goods>)list) {
				g.setScroll(gDao.isScroll(g));
				g.setHot(gDao.isHot(g));
				g.setNew(gDao.isNew(g));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public Goods getById(int id) {
		Goods g =null;
		try {
			g = gDao.getById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}
	public Page getGoodsSearchPage(String keyword, int pageNo) {
		Page p =new Page();
		p.setPageNumber(pageNo);
		int totalCount = 0;
		try {
//			totalCount = gDao.getGoodsRecommendCount(type);
			totalCount = gDao.getGoodsSearchCount(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8,totalCount);
		List<Goods> list = null;
		try {
//			list = gDao.selectGoodsRecommend(type, pageNo, 8);
			list = gDao.selectGoodsSearch(keyword,pageNo,8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public void addRecommend(int id,int type) {
		try {
			gDao.addRecommend(id, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteRecommend(int id,int type) {
		try {
			gDao.deleteRecommend(id, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(Goods g) {
		try {
			gDao.insert(g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Goods goods) {
		try {
			gDao.update(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		try {
			gDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
