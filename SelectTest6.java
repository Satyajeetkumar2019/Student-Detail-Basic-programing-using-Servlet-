//write a jdbc programe to find nth higest sal from emp table 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet ;
public class SelectTest6 {

	public static void main(String[] args)throws Exception {
		//create a variable 
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			//load a driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			if(con!=null)
			st=con.createStatement();
			if(st!=null)
				rs=st.executeQuery("select max(sal) from emp8 where sal>1300");
			if(rs!=null) {
				while(rs.next()) {
				System.out.println(rs.getInt(1));
			}//end of the while block 
				}//end of the if block
		}catch(Exception e) {
			e.printStackTrace();
		}//end of the catch block
		
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
	}//end of the main method 
}//end of the class 
