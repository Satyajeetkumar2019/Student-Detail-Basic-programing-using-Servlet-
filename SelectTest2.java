//Q1.write a jdbc application that give student detail base on the given city  
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.sql.SQLException;
public class SelectTest2 {

	public static void main(String[] args)throws Throwable {
	//initalize the variable 
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		String city=null;
		int REGNO=0;
		Scanner scn=new Scanner(System.in);
		try {
			//input the end user 
			//System.out.println("Enter the Registation no from student  :");//give hyd
			//city=scn.next();
			//REGNO=scn.nextInt();
		//load driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//get a connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe:1521","system","saka");
		if(con!=null)
		//select a queary below 
		st=con.createStatement();

		if(st!=null)
		rs=st.executeQuery("select * from students ");
		//print Database record 
		if(rs!=null) {
			while(rs.next()!=false) {
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getInt(3));
			}//end of the while  block
		}//end of the if lock
		}//end of the try block
		catch(SQLException e) {
			e.printStackTrace();
			
		}//end of the catch block
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}//end of the catch block
		catch(Exception e) {
			e.printStackTrace();
			
		}//end of the catch block
		finally {
			try {
				if(rs!=null)
					rs.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}//end of the catch block
			try {
				if(st!=null)
					st.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}//end of the catch block
			try {
				if(con!=null)
					con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}//end of the catch block
			
		}//end of the finally block
		
	}//end of the main method 
}//end of the classs
