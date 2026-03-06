package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import Security.PasswordUtility;
import Util.DataSourseUtil;

public class DAOUser {
	
//	public String getuserrole(String user_name,String user_password) throws SQLException, ClassNotFoundException {
//		 String role = null;
//		 DTOUsers dtouser;
//		 
//		//password= BCrypt.checkpw("userpassword", )
//		  
//		 try {
//		        Class.forName("org.postgresql.Driver");
//		    	Connection connection = DataSourseUtil.getDataSource().getConnection();
//				PreparedStatement ps =connection.prepareStatement("SELECT urole FROM table4 where uname=? and upassword=?");
//				ps.setString(1, user_name);
//				ps.setString(2, user_password);
//				ResultSet rs=ps.executeQuery();
//				if(rs.next()) {
//					 role = rs.getString("urole");				
//				}
//				return role;
//
//		    } catch (ClassNotFoundException e) {
//		        throw new RuntimeException("PostgreSQL Driver not found", e);
//		    }
//	
//	}
	

	
	
	public DTOUsers getuserByname(String user_name) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DataSourseUtil.getDataSource().getConnection();
			PreparedStatement ps =connection.prepareStatement("SELECT * FROM table4 WHERE uname=?");
			ps.setString(1, user_name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				DTOUsers user = new DTOUsers();
				user.setusername(rs.getString("uname"));
				user.setuserpassword(rs.getString("upassword"));
				user.setuserrole(rs.getString("urole"));
				return user;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void createguestuser(String name , String password) {
		
		
		
		try {
		   Class.forName("org.postgresql.Driver");
		   Connection connection = DataSourseUtil.getDataSource().getConnection();
		   PreparedStatement ps =connection.prepareStatement("INSERT INTO table4 values(?,?,'guest')");
		   ps.setString(1,name);
		   ps.setString(2, password);
		   int created=ps.executeUpdate();
		   if(created<1) {
			   System.out.println("guest user is added successfully");
		   }
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
