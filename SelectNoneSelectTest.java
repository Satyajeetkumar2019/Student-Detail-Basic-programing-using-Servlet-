//write a jdbc application select and non select both queary 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.sql.Statement;
public class SelectNoneSelectTest {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		Scanner scn=null;
		String q=null;
		boolean flag=false;
		int count=0;
		int no=0;
		try {
			//input end usere 
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter the sql queary ");
				q=scn.nextLine();
			}//end of if block
			//load jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			if(con!=null)
			//create jdbc Ststement 
			st=con.createStatement();
			if(st!=null)
			flag=st.execute(q);
			//print data into table 
			if(flag==true) 
				System.out.println("Select  sql queary ");
			rs=st.getResultSet();
			//processes the result set 
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}//end while 
				
			}//if block
			else 
				System.out.println(" Non select queary execuate  ");
			count=st.getUpdateCount();
			System.out.println("NO of record that are effected "+count);
		}//end tyr block 
		catch(Exception e) {
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
