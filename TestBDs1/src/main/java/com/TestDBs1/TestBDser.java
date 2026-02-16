package com.TestDBs1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestDBs1.DAO.DAOInterface1;
import com.TestDBs1.DAO.DAOInterface1Imp;
import com.TestDBs1.DAO.DTOfile1;
import com.TestDBs1.DAO.DataBasetDAO;
import com.TestDBs1.Services.StudentService;
import com.TestDBs1.Services.StudentServiceImpl;


public class TestBDser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestBDser() {
        // TODO Auto-generated constructor stub
    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 response.setContentType("application/json");
////		    response.setCharacterEncoding("UTF-8");
////
//		    PrintWriter out = response.getWriter();
////
////		    String a = "";
////		    String b = "";
////
////		    try {
////		       Connection con= DataBasetDAO.getCon();
////		        PreparedStatement ps = con.prepareStatement("select * from student1");
////		        ResultSet rs = ps.executeQuery();
////
////		        while (rs.next()) {   // single record example
////		            a = rs.getString("sname");
////		            b = rs.getString("dept");
////		        }
////
////		        // JSON response
////		        out.print("{");
////		        out.print("\"name\":\"" + a + "\",");
////		        out.print("\"dept\":\"" + b + "\"");
////		        out.print("}");
////
////		    } catch (Exception e) {
////		        e.printStackTrace();
////		    }
//		    int id =Integer.parseInt(request.getParameter("id"));
//		    DAOInterface1 data1 = new DAOInterface1Imp();
//		    
//		    out.println(data1.get(id));
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//
//		 response.setContentType("application/json");
//		 response.setCharacterEncoding("UTF-8");
//	    PrintWriter out = response.getWriter();
//	    //out.println("hello");
//	    String name =request.getParameter("name");
//	    String dept =request.getParameter("dept");
//	    try {
//	    	 Connection con= DataBasetDAO.getCon();
//	    	PreparedStatement ps = con.prepareStatement(
//	    			"INSERT INTO student1 VALUES(?,?)");
//	    	ps.setString(1,name);
//	    	ps.setString(2,dept);
//	    	 int rowsInserted = ps.executeUpdate();
//	    }catch(Exception e) {
//	    	System.out.println(e);
//	    	}
//	}
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("application/json");
//		String name=req.getParameter("name");
//		String dept=req.getParameter("dept");
//		try {
//			 Connection con= DataBasetDAO.getCon();
//			PreparedStatement ps =con.prepareStatement("UPDATE student1 SET dept=? WHERE sname=?");
//			ps.setString(1,dept);
//			ps.setString(2,name);
//			ps.executeUpdate();
//		}catch(Exception e ) {
//			System.out.println(e);
//		}
//	}
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name =req.getParameter("name");
//		try {
//			 Connection con= DataBasetDAO.getCon();
//			PreparedStatement ps=con.prepareStatement("DELETE FROM student1 WHERE sname = ?");
//			ps.setString(1,name);
//			ps.executeUpdate();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	
    
   //============================================================================= 
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws IOException {
//
//        int id = Integer.parseInt(req.getParameter("id"));
//        DAOInterface1 dao = new DAOInterface1Imp();
//
//        DTOfile1 dto = dao.get(id);
//
//        resp.setContentType("application/json");
//        PrintWriter out = resp.getWriter();
//
//        if (dto == null) {
//            out.print("{}");
//            return;
//        }
//
//        out.print("{");
//        out.print("\"id\":" + dto.getId() + ",");
//        out.print("\"name\":\"" + dto.getName() + "\",");
//        out.print("\"dept\":\"" + dto.getDept() + "\"");
//        out.print("}");
//    }
//    
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws IOException {
//
//        DTOfile1 dto = new DTOfile1(
//                Integer.parseInt(req.getParameter("id")),
//                req.getParameter("name"),
//                req.getParameter("dept")
//        );
//
//        DAOInterface1 dao = new DAOInterface1Imp();
//        dao.insert(dto);
//
//        resp.getWriter().print("{\"status\":\"created\"}");
//    }
//    
//    
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
//            throws IOException {
//
//        DTOfile1 dto = new DTOfile1(
//                Integer.parseInt(req.getParameter("id")),
//                req.getParameter("name"),
//                req.getParameter("dept")
//        );
//
//        DAOInterface1 dao = new DAOInterface1Imp();
//        dao.update(dto);
//
//        resp.getWriter().print("{\"status\":\"updated\"}");
//    }
//    
//    
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
//            throws IOException {
//
//        int id = Integer.parseInt(req.getParameter("id"));
//
//        DAOInterface1 dao = new DAOInterface1Imp();
//        dao.delete(id);
//
//        resp.getWriter().print("{\"status\":\"deleted\"}");
//    }

    
    private StudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        DTOfile1 student = service.getStudentById(id);

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (student == null) {
            out.print("{}");
            return;
        }

        out.print("{");
        out.print("\"id\":" + student.getId() + ",");
        out.print("\"name\":\"" + student.getName() + "\",");
        out.print("\"dept\":\"" + student.getDept() + "\"");
        out.print("}");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        try {
            // 1. Read request parameters
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String dept = req.getParameter("dept");

            // 2. Create DTO
            DTOfile1 student = new DTOfile1(id, name, dept);

            // 3. add values in service layer.
            service.createStudent(student);

            // 4. Send response
            out.print("{\"status\":\"success\",\"message\":\"Student created\"}");

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"status\":\"error\",\"message\":\"Invalid id\"}");
        }

    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        try {
            // 1. Read parameters
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String dept = req.getParameter("dept");

            // 2. Create DTO
            DTOfile1 student = new DTOfile1(id, name, dept);

            // 3. update values in service layer.
            service.updateStudent(student);

            // 4. Response
            out.print("{\"status\":\"success\",\"message\":\"Student updated\"}");

        }catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"status\":\"error\",\"message\":\"Server error\"}");
            e.printStackTrace();
        }
    }
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        try {
            // 1. Read id
            int id = Integer.parseInt(req.getParameter("id"));

            // 2. delete values in service layer.
            service.deleteStudent(id);

            // 3. Response
            out.print("{\"status\":\"success\",\"message\":\"Student deleted\"}");

        }catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"status\":\"error\",\"message\":\"Server error\"}");
            e.printStackTrace();
        }
    }








}
