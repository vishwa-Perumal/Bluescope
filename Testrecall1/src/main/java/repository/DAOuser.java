package repository;

import java.io.IOException;
import java.sql.SQLException;

public interface DAOuser {

    public void createuser(String name,String password,String role) throws SQLException, ClassNotFoundException, IOException;
    public DTOobject getuserrole(String name,String password) throws SQLException, ClassNotFoundException;

}
