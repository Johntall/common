package com.jt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jt.servlets.beans.User;
import com.jt.servlets.tools.AccountTool;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	AccountTool actool;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String lgname = req.getParameter("lgname");
		String lgpwd=req.getParameter("lgpwd");
		User lgUser = actool.login(lgname, lgpwd);
		resp.getWriter().write(lgUser.toString());
		
		
	}
	@Override
	public void destroy() {
		actool=null;
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		actool=new AccountTool();
	}
	
	
	

}
