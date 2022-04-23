//Write a JDBC Application give that record count of the Database table 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectTest5 {

	public static void main(String[] args) {
		//create basic variable 
				Connection con=null;
				ResultSet rs=null;
				Statement st=null;
				int count=0;
				try {
					//load the driver class
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//establish the connection 
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
					if(con!=null)
					//create jdbc Ststement 
					st=con.createStatement();
					//Exceuse queary 
					if(st!=null)
						rs=st.executeQuery(" select count(*) from emp8");
					//print database table 
					if(rs!=null) {
						while(rs.next()!=false) {
						count=rs.getInt("count(*)");
						System.out.println(count);
						}//end of the while block
					}//end of the if block
					else
						System.out.println("Record not found :");
					
				}catch(Exception e) {
					e.printStackTrace();
				}//end of the catch block
		
				//close jdbc object 
				finally {
					try {
						if(rs!=null)
							rs.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}//end of teh catch block
					try {
						if(st!=null)
							st.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}//end 
					try {
						if(con!=null)
							con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}//end of the 
					
				}//end of the finally block
				
				
				
				
		
	}//end of the main  method 

}//end of the class
