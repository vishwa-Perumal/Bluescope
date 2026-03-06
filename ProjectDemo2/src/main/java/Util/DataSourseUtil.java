package Util;

import java.sql.Statement;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourseUtil {
	
	private static HikariDataSource dataSource;
	static {
		
		HikariConfig config = new HikariConfig();
		
		  config.setJdbcUrl("jdbc:postgresql://localhost:5432/database1");
	        config.setUsername("postgres");
	        config.setPassword("root");

	        config.setMaximumPoolSize(10);
	        config.setMinimumIdle(2);
	        config.setConnectionTimeout(30000);
	        config.setIdleTimeout(600000);
	        config.setMaxLifetime(1800000);
	        
	        dataSource = new HikariDataSource(config);
		
	}
	
	 private DataSourseUtil() {}

	    public static DataSource getDataSource() {
	        return dataSource;
	    }


}
