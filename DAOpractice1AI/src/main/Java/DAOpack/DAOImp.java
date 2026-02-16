package DAOpack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOImp implements DAO {

	@Override
	public DTOfile save(int id) {
		DTOfile dto ;
		try {
		Connection con = DataBase.getCon();
		PreparedStatement ps =con.prepareStatement("SELECT * FORM testdao where id =?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			       int oid =rs.getInt("id");
			       String ename =rs.getString("ename");
			       String role =rs.getString("role");
			       return new DTOfile(oid,ename,role);
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public void create(DTOfile dto) {
		
	}

	@Override
	public void update(DTOfile dto) {
		
	}

	@Override
	public void delete(DTOfile dto) {
	}
	
	

}
