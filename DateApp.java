// Date App servlet programe 

package com.bce.JSP;
import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
public class DateApp {
public static void main(String []args)throws Exception {
	//load the driver 
	//create a variable 
	Statement st=null;
	ResultSet rs=null;
			Connection con=null;
	try {
	
	Class.forName("oracle.jdbc.driver.OracleDrver");
	//establish the connection 
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
	//create jdbc statement 
	if(con!=null) {
	 st=con.createStatement();
	}//end of the if block
	//excused queary and processes the result set 
	if(st!=null)
	rs=st.executeQuery("select * from students");
	//printData base record 
	if(rs!=null) {
		while(rs.next()!=false) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getInt(3));
		}//end of the while 
		
	}//end of the if block
	
	
	}//end try block
	catch(SQLException e) {
		e.printStackTrace();
	}//end of the catch block
	catch(ClassNotFoundException es) {
		es.printStackTrace();
		
	}//end of the catch block
	catch(Exception e) {
		e.printStackTrace();
		
	}//end of the catch block
	finally {
		try {
		if(rs!=null)
		rs.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(st!=null)
			st.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		try {
			if(con!=null)
			con.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}//end of the finally block
	
	
}//end of the mail method 
}//end of the class 
