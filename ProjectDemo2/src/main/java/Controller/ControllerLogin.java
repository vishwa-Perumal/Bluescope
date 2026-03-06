package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceProjectDemo2.ServiceProjectDemo1;

public class ControllerLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("userName");
		String pass = req.getParameter("userPassword");
		
		ServiceProjectDemo1 service = new ServiceProjectDemo1();
		if(service.loginverify(name, pass)) {
			resp.sendRedirect("guest");
		}
		else {
			System.out.println("some thing went wrong in hashing");
		}
		
		
	}
	
	

}
