//write a jdbc application to update in to table  base on the given condiation
package com.bce.JSP;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.sql.Statement;
public class UpdateTest {

	public static void main(String[] args) {
		//to create variabel 
		Connection con=null;
		Statement st =null;
		ResultSet rs=null;
		Scanner scn=null;
		String NAME=null;
		String ADDRESH=null;
		int result=0;
		int no=0;
		String q=null;
		try {
			//red input end usere 
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter the existing student no to update ");
				no=scn.nextInt();
				System.out.println("Enter the student name :");
				NAME=scn.next();
				System.out.println("Enter the student Addresh ");
				ADDRESH=scn.next();
			}//end of the if block
			//convert into value as a requeir for sql queary 
			NAME=""+NAME+"";
			ADDRESH=""+ADDRESH+"";
			//REGISTER jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			if(con!=null)
			//create jdbc Ststement 
			st=con.createStatement();
			//prepare sql queary 
			//1003q=("update students set NAME="+NAME+",ADDRESH="+ADDRESH+"where REGNO="+no);
			//send and execuate queary in database softwere 
			if(st!=null)
				result=st.executeUpdate("update students set NAME="+NAME+",ADDRESH="+ADDRESH+"where REGNO="+no);
			//processes the result 
			if(result!=0)
				System.out.println("Record found successfull update ");
			else 
				System.out.println("Record found not update ");
		}//end of the try block
		catch(Exception e) {
			e.printStackTrace();
			
		}//end of the catch block 
		
		finally {
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
			
			try {
				if(scn!=null)
					scn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}//end of the 
			
			
		}//end of the finally block
		
		
		
		
		
	}//end of the main method 

}//end of the class
