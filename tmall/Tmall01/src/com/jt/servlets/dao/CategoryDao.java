package com.jt.servlets.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jt.servlets.beans.CatEntry;
import com.jt.servlets.utils.DbConnection;

public class CategoryDao implements ICommonDao{

	public CatEntry findAll() {
		 String sql = "select * from category";
		 CatEntry ce = null;
	        try {
	            ce = DbConnection.getInstance()
	                    .getQueryRunner()
	                    .query(sql, new BeanHandler<>(CatEntry.class));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ce;
	}
	

}
