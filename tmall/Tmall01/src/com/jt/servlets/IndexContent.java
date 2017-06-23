package com.jt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jt.servlets.dao.CategoryDao;
import com.jt.servlets.tools.CategoryTool;

import javafx.print.JobSettings;

/**
 * Servlet implementation class IndexContent
 */
@WebServlet("/IndexContent")
public class IndexContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryTool cgtool;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		cgtool = new CategoryTool();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		cgtool=null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String id=req.getParameter("id");
		String rt=JSON.toJSONString(cgtool.allCatImg(id));
		PrintWriter wt = resp.getWriter();
		wt.write(rt);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
