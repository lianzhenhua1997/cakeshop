package com.lzh.model;

import java.util.List;

public class Page {
	private int pageNumber;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private List<Goods> list;
	public void setPageSizeAndTotalCount(int pageSize,int totalCount) {
		this.pageSize=pageSize;
		this.totalCount=totalCount;
		totalPage = (int) Math.ceil((double)totalCount/pageSize);
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}
	
}
