package ServiceProjectDemo2;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import Repository.DAOUser;
import Repository.DTOUsers;
import Security.PasswordUtility;

public class ServiceProjectDemo1 {
	DAOUser daouser = new DAOUser();
	
//	public String getuserrole(String user_name,String user_password) throws SQLException {
//		try {
//			return  daouser.getuserrole(user_name, user_password);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return null;
//	}
//     my  code
//	public boolean loginverify(String user_name, String painPassword) {
//		//DAOUser dao = new DAOUser();
//		DTOUsers user =daouser.getuserByname(user_name);
//		String hashedPasswordN = user.getpassword();
//		return PasswordUtility.chechPassword(painPassword,hashedPasswordN);
//	}
	
	
	
	public String loginAndGetRole(String user_name, String plainPassword) {

	    DTOUsers user = daouser.getuserByname(user_name);

	    if (user == null) {
	        return null;
	    }

	    boolean isValid = PasswordUtility.chechPassword(
	        plainPassword,
	        user.getpassword()
	    );

	    if (!isValid) {
	        return null;
	    }

	    return user.getuserrole();
	}
	
	public boolean loginverify(String user_name, String plainPassword) {

	    DTOUsers user = daouser.getuserByname(user_name);

	    if (user == null) {
	        return false; // user not found
	    }

	    String hashedPasswordFromDB = user.getpassword();

	    return PasswordUtility.chechPassword(
	        plainPassword,
	        hashedPasswordFromDB
	    );
	}
	
	public void createuser(String name, String plainPassword) {
		// TODO Auto-generated method stub
		
		System.out.println(name+" from service class1");
		String hashedPassword = PasswordUtility.passwordHashing(plainPassword);
		daouser.createguestuser(name, hashedPassword);
		System.out.println(name+" from service class2");
	}

}
