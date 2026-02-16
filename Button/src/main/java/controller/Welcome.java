package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        
		PrintWriter out =resp.getWriter();
		out.println("welcome");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out =resp.getWriter();
		out.println("welcome dopost");
		
		String name=req.getParameter("name");
		String password= req.getParameter("password");
		out.println(name + "  "+password );
		if(name.equals("vishwa")&& password.equals("pass")) {
			//req.getRequestDispatcher("/admin").forward(req, resp);
			HttpSession session=req.getSession();
			session.setAttribute("isLogin", name);
			resp.sendRedirect(req.getContextPath()+"/admin");
		}
		else {
			out.println("not admin");
		}
		
		
	}
	
	

}
