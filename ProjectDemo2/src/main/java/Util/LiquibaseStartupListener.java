package Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquibaseStartupListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try(Connection con = DataSourseUtil.getDataSource().getConnection()){
			Database database = DatabaseFactory.getInstance().
					findCorrectDatabaseImplementation(new JdbcConnection(con));
			
			Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.xml", 
					              new ClassLoaderResourceAccessor(), database);
			
			liquibase.update();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
