package com.jt.servlets.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jt.servlets.dao.CategoryDao;

public class CategoryTool {
	
	private CategoryDao dao;

	public CategoryTool() {
		dao=new CategoryDao();
	}
	
	public List<String> allCatImg(String cid){
		List<Integer> r=null;
		r=dao.findAll(cid);
		ArrayList<String> url=new ArrayList<>();
		for (Integer i : r) {
			
			File f = new File("http://localhost/Tmall01/img/productSingle_middle/"+i+".jpg");
			if(f.exists()){
				url.add(f.getPath());
				System.out.println("true");
			}
		}
		return url;
	}
	

}
