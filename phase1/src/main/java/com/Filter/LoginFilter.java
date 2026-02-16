package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
		    System.out.println("filer");
		  HttpSession session = req.getSession(false);

	        if (session == null || session.getAttribute("role") == null) {
	            resp.sendRedirect(req.getContextPath() + "/login");
	            return;
	        }

	        String role = (String) session.getAttribute("role");
	        String uri = req.getRequestURI();
	        String context = req.getContextPath();

	        // Admin area
	        if (uri.startsWith(context + "/admin") && "Admin".equals(role)) {
	            chain.doFilter(req, resp);
	            System.out.println(role);
	        }

	        // Employee area
	        else if (uri.startsWith(context + "/employe") && "employe".equals(role)) {
	            chain.doFilter(req, resp);
	            System.out.println(role);
	        }

	        // Guest area
	        else if (uri.startsWith(context + "/guest") && "Guest".equals(role)) {
	            chain.doFilter(req, resp);
	        }

	        else {
	            resp.sendRedirect(context + "/login");
	        }
		
	}
}
		
		
//	     HttpSession session = req.getSession(false);
//	     String uri = req.getRequestURI();
//	        String context = req.getContextPath();
//
//	        // Not logged in
//	        if (session == null || session.getAttribute("role") == null) {
//	            resp.sendRedirect(context + "/login");
//	            return;
//	        }
//
//	        String role = (String) session.getAttribute("role");
//
//	        // Admin access
//	        if (uri.startsWith(context + "/admin") && "Admin".equals(role)) {
//	            chain.doFilter(req, resp);
//	        }
//
//	        // Employee access
//	        else if (uri.startsWith(context + "/employee") && "Employee".equals(role)) {
//	            chain.doFilter(req, resp);
//	        }
//
//	        // Guest access
//	        else if (uri.startsWith(context + "/guest") && "Guest".equals(role)) {
//	            chain.doFilter(req, resp);
//	        }
//
//	        // Unauthorized
//	        else {
//	            resp.sendRedirect(context + "/login");
//	        }
//		
//		
//		String name = req.getParameter("uname");
//		    String password = req.getParameter("upassword");
//
//		    if ("Admin".equals(name) && "Admin".equals(password)) {
//
//		        HttpSession session = req.getSession();
//		        session.setAttribute("role", "Admin");
//		        chain.doFilter(req, resp);
//
//
//		       // resp.sendRedirect(req.getContextPath() + "/admin");
//		        return;
//		    }
//
//		    else if ("vishwa".equals(name) && "vishwa".equals(password)) {
//
//		        HttpSession session = req.getSession();
//		        session.setAttribute("role", "Employee");
//		        chain.doFilter(req, resp);
//
//
//		        //resp.sendRedirect(req.getContextPath() + "/employe");
//		        return;
//		    }
//
//		    else {
//		        resp.sendRedirect(req.getContextPath() + "/login");
//		        return;
//		    }


		   // res.sendRedirect(req.getContextPath() + "/Admin.html");

//	    HttpSession session = req.getSession(false);
//
//	    if(session != null) {
//
//	        String role = (String) session.getAttribute("role");
//	        System.out.println(role);
//
//	        if("Admin".equals(role)) {
//	            chain.doFilter(req, res);
//	            return;
//	        }
//	    }
//
//	    res.sendRedirect(req.getContextPath() + "/login");
//	}
//
//	
//	
//
//}
