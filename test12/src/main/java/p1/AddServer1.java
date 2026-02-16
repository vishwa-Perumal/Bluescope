package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

public class AddServer1 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int i = Integer.parseInt(req.getParameter("num1"));//HTML form data → getParameter()
		int j = Integer.parseInt(req.getParameter("num2"));
		int k= i+j;
	//	PrintWriter out = resp.getWriter();
		req.setAttribute("result",k);//Server-side data → getAttribute() or setAttribute

		
		
		RequestDispatcher rd= req.getRequestDispatcher("/sq");
		rd.forward(req, resp);
		
	} 

}
