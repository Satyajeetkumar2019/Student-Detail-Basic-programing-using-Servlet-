//JDBCConnection.java
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBCConnectionTest2 {

	public static void main(String[] args)throws Exception {
		//create jdbc variable 
		Connection con=null;
		//Register JDBC driver class object 
		try {
		//sun.jdbc.odbc.jdbcOdbcDriver driver=new sun.jdbc.odbc.jdbcOdbcDriver();
	//DriverManager.registerDriver(driver);
	//establish the connection
	
	con=DriverManager.getConnection("jdbc:odbc:oradsn","system","saka");
	if(con!=null)
		System.out.println("conection Establish");
	else 
		System.out.println("Connection failed ");
		}//end of the try block
		catch(SQLException e ) {
			e.printStackTrace();
			
		}//end of the catch block
	}//end of the main method 

}//end of teh class
