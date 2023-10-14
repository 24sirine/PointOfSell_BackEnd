package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
private static Connection connection = null ;
public static Connection getConnection() throws SQLException  {
	if ( connection != null ) {
		System.out.println("ui");
		return connection ;
	}
	else
	{System.out.println("nn");
		String driver ="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:4000/DynamixServices_POS?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true";
		String user ="sirine";
				String password ="user1";
				try {
					
					Class.forName(driver);
					connection = DriverManager.getConnection(url , user , password);
					System.out.println("tryy");
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
	}
	
	return connection ;
}
}
