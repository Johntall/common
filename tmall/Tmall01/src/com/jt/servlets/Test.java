package com.jt.servlets;

import com.jt.servlets.tools.AccountTool;

public class Test {

	public static void main(String[] args) {
		
		AccountTool t = new AccountTool();
		
		System.out.println(t.login("jt", "123").getId());//ok
		
		
	}

}
