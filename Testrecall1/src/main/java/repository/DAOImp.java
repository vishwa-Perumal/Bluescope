package repository;

import java.io.IOException;
import java.sql.*;

public class DAOImp implements DAOuser {

    public DAOImp(){

    }


    @Override
    public void createuser(String name, String password, String role) throws SQLException, ClassNotFoundException, IOException {
        Connection con = DataUtil.getConnection();
        PreparedStatement ps =con.prepareStatement("insert into testrecalluser values(?,?,'guest')");
        ps.setString(1,name);
        ps.setString(2,password);
        int useradded=ps.executeUpdate();
        if(useradded<1){
            System.out.println("user is not added");
        }
    }

    public DTOobject getuserrole(String name,String password) throws SQLException, ClassNotFoundException {

        DTOobject dtoo1=new DTOobject();
        try {
            Connection con = DataUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from testrecalluser where uname=?");
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
             dtoo1.setUname(rs.getString("uname"));
             dtoo1.setUpassword(rs.getString("upassword"));
              dtoo1.setUrole(rs.getString("urole"));
            }
            }catch(Exception e){
            System.out.println(e);
            }


        return dtoo1;
    }




}
