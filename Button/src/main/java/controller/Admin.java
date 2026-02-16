package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Admin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("this is Admin doGet");
		System.out.println("doget");
		HttpSession session = req.getSession();
		if(session.getAttribute("isLogin") == null || session.getAttribute("isLogin").equals("")) {
			resp.sendRedirect(req.getContextPath()+"/signin");
		}
		out.println("your are successfully logiin");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("this is Admin dopost");
		System.out.println("dopost");
		HttpSession session = req.getSession();
		if(session.getAttribute("isLogin") == null || session.getAttribute("isLogin").equals("")) {
			resp.sendRedirect(req.getContextPath()+"/signin");
		}
		out.println("your are successfully logiin");
	}
	
	@Override
	public void init() throws ServletException {
	
		System.out.println("init");
		
		
		
	}
	

}
