package cn.cloud.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.cloud.entity.User;
import cn.cloud.util.C3P0Utils;

public class UserDao {
	private QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
	public User checkUserName(String username) {
		User user = null;
		try {
			user = qRunner.query("select * from user where username = ?", 
					new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public long checkEmail(String email) {
		long count = 0;
		try {
			count = qRunner.query("select count(*) from user where email = ? ", new ScalarHandler<Long>(), email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int registUser(User user) {
		int row = 0;
		try {
			row = qRunner.update("insert into user (uname, username, password, email, create_time) values"
					+ "(?,?,?,?,?)",user.getUname(),user.getUsername(), user.getPassword(),user.getEmail(),user.getCreate_time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
}
