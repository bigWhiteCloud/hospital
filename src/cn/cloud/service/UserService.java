package cn.cloud.service;

import cn.cloud.dao.UserDao;
import cn.cloud.entity.User;

public class UserService {
	private UserDao userDao = new UserDao(); 
	public boolean checkUserName(String username) {
		User user = userDao.checkUserName(username);
		if(user != null) {
			return true;
		}
		return false;
	}
	public boolean checkEmail(String email) {
		long count = userDao.checkEmail(email);
		if(count > 0) {
			return true;
		}
		return false;
	}
	public boolean registUser(User user) {
		int row = userDao.registUser(user);
		if(row > 0) {
			return true;
		}
		return false;
	}

}
