package service;

import repository.DAOImp;
import repository.DAOuser;
import repository.DTOobject;

import java.io.IOException;
import java.sql.SQLException;


public class SignupService {

    public void createuser(String name,String password,String role) throws SQLException, ClassNotFoundException, IOException {

        DAOuser dao1 = new DAOImp();
        dao1.createuser(name,password,role);

    }
    public String getuser(String name, String password) throws SQLException, ClassNotFoundException {
        DAOuser dao= new DAOImp();
        DTOobject dto =dao.getuserrole(name,password);
        return dto.getUrole();
    }

}
