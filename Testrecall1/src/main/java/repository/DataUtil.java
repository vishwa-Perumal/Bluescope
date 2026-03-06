package repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataUtil {
    public static Connection con;

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        try {
            Properties prop = new Properties();
            InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("application.properties");
            prop.load(is);

            String url = prop.getProperty("url");
            String user = prop.getProperty("username");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            System.out.println(url);

        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }

}
