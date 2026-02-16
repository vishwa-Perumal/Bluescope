package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO1Imp;
import DAO.DTO;


public class AuthController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String enname = req.getParameter("enname");
        String pass = req.getParameter("passkey");
        System.out.println("AuthController called");

        DAO1Imp dao = new DAO1Imp();
        DTO user = dao.get(enname, pass);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            out.println("<h2>Login successful</h2>");
            out.println("Welcome " + user.getEname());
        } else {
            out.println("<h2>Invalid username or password</h2>");
        }
    }
	
}


