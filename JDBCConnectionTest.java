package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBCConnectionTest {
public static void main(String[] args)throws Exception {
	//1.jdbc properties oracle db 
	String DriverClass="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userename="system";
	String userpwd="saka";
	//load driver 
	Connection con=null;
	try {
	Class.forName(DriverClass);
	//get connection 
	 con=DriverManager.getConnection(url,userename,userpwd);
	if(con!=null)
	System.out.println(con);
	else
		System.out.println("Connection failed ");
	}catch(SQLException e) {
		e.printStackTrace();
	}//end of the try block
	catch(ClassNotFoundException es) {
		es.printStackTrace();
	}
	catch(Exception r) {
		r.printStackTrace();
	}//end of the catch block 
	finally {
		try {
			if(con!=null)
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}//end of the catch block
	}//end of the finally block
}//end of the main method 
}//end of the class
