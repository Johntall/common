package com.jt.servlets.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jt.servlets.beans.User;
import com.jt.servlets.utils.DbConnection;

public class AccountDao implements ICommonDao{

	public User findUser(String name) {
		 String sql = "select * from user where name =?";
	        User user = null;
	        try {
	            user = DbConnection.getInstance()
	                    .getQueryRunner()
	                    .query(sql, new BeanHandler<>(User.class), name);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return user;
	}
	

}
