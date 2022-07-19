package com.lzh.service;

import java.sql.SQLException;
import java.util.List;

import com.lzh.dao.UserDao;
import com.lzh.model.Page;
import com.lzh.model.User;

public class UserService {
	private UserDao ud = new UserDao();
	public boolean register(User user) {
		try {
			if(ud.isUsernameExist(user.getUsername())) {
				return false;
			}
			if(ud.isEmailExist(user.getEmail())) {
				return false;
			}
			ud.addUser(user);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public User login(String ue,String password) {
		User user = null;
		try {
			user = ud.selectByUsernamePassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		try {
			user = ud.selectByEmailPassword(ue, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			return user;
		}
		return null;
	}
	public void updateUserAddress(User user) {
		try {
			ud.updateUserAddress(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateUserPassword(User user) {
		try {
			ud.updateUserPassword(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Page getUserPage(int pageNo) {
		int pageSize = 7;
		Page p =new Page();
		p.setPageNumber(pageNo);
		int totalCount = 0;
		try {
			totalCount = ud.getUserCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(pageSize,totalCount);
		List list = null;
		try {
			list = ud.selectUserList(pageNo, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setList(list);
		return p;
	}
	public User selectById(int id) {
		User user = null;
		try {
			user = ud.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public boolean delete(int id) {
		try {
			ud.delete(id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
