package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		  String username = req.getParameter("uname");
	        String password = req.getParameter("upassword");

	        HttpSession session = req.getSession();

	        if ("Admin".equals(username) && "Admin".equals(password)) {
 
	        	System.out.println(username+" "+password);
	            session.setAttribute("role", "Admin");
	            resp.sendRedirect(req.getContextPath() + "/admin");
	            return;
	        }

	        else if ("vishwa".equals(username) && "vishwa".equals(password)) {
	        	
	        	System.out.println(username+" "+password);
	            session.setAttribute("role", "employe");
	            resp.sendRedirect(req.getContextPath() + "/employe");
	            return;
	        }

	        else if ("guest".equals(username) && "guest".equals(password)) {

	            session.setAttribute("role", "Guest");
	            resp.sendRedirect(req.getContextPath() + "/guest/welcome");
	            return;
	        }

	        else {
	            resp.sendRedirect(req.getContextPath() + "/login");
	        }
		
		
//		String name = req.getParameter("uname");
//		String password = req.getParameter("upassword");
//		
//		System.out.println(name+" "+password);
//		if(name.equals("Admin")&& password.equals("Admin")) {
//			HttpSession session = req.getSession();
//			session.setAttribute("role","Admin");
//			System.out.println(session.getAttribute("role"));
//			req.getRequestDispatcher("/admin").forward(req, resp);
//		}
//		else {
//			System.out.println("hello");
//			resp.sendRedirect(req.getContextPath()+"/login");
//			//res.sendRedirect("/login");
//		}
//		
//		if(name.equals("vishwa")&& password.equals("vishwa")) {
//			HttpSession session = req.getSession();
//			session.setAttribute("role","employe");
//			System.out.println(session.getAttribute("role"));
//			resp.sendRedirect(req.getContextPath()+"/employe");
//		}
//		else {
//			System.out.println("hello");
//			resp.sendRedirect(req.getContextPath()+"/login");
//			//res.sendRedirect("/login");
//		}
		
//		HttpSession session=req.getSession();
//		String role =(String) session.getAttribute("role");
//		System.out.println(role);
////		if(role.equals("Admin")) {
////			System.out.println("This is " +role +" servlet");
////		}
////		else if(role.equals("user")) {
////			System.out.println("this is user");
////		}
////		else if(role.equals("guest")) {
////			System.out.println("this is guest");
////		}
		
	}
	
	

}
