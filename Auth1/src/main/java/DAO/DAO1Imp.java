package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO1Imp implements DAO1{
	    @Override
	    public DTO get(String enname, String enpassword) {

	        DTO dto = null;

	        try {
	            Connection con = DataBase.getCon();
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT enname, enpassword FROM lognintable WHERE enname=? AND enpassword=?"
	            );

	            ps.setString(1, enname);
	            ps.setString(2, enpassword);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                dto = new DTO(
	                    rs.getString("enname"),
	                    rs.getString("enpassword")
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return dto;
	    }


	@Override
	public void create(DTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DTO dto) {
		// TODO Auto-generated method stub
		
	}
	
}
