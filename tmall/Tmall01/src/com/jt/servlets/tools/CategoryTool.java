package com.jt.servlets.tools;

import com.jt.servlets.beans.CatEntry;
import com.jt.servlets.beans.User;
import com.jt.servlets.dao.AccountDao;
import com.jt.servlets.dao.CategoryDao;

public class CategoryTool {
	
	private CategoryDao dao;

	public CategoryTool() {
		dao=new CategoryDao();
	}
	
	

}
