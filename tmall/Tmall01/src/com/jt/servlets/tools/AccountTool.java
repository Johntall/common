package com.jt.servlets.tools;

import com.jt.servlets.beans.User;
import com.jt.servlets.dao.AccountDao;

public class AccountTool {
	
	private AccountDao dao;

	public AccountTool() {
		dao=new AccountDao();
	}
	
	public User login(String name,String pwd){
		User u1=null;
		if(name!=null){
			User find = dao.findUser(name);
			if(find!=null){
				if(find.getPassword().equals(pwd)){
					u1=find;
				}
			}
		}
		return u1;
	}
	

}
