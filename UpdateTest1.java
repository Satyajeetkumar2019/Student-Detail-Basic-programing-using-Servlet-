package com.bce.JSP;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.sql.Statement;
public class UpdateTest1 {
	public static void main(String[] args)throws Exception {
		Connection con=null;
		Statement st =null;
		ResultSet rs=null;
		int result=0;
		try {
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
				result=st.executeUpdate(" update students set name=' mohan' ,  ADDRESH='pnj' where regno=45");
			//processes the result 
			if(result!=0)
				System.out.println("Record found successfull update ");
			else 
				System.out.println("Record found not update ");
		}//end of the try block
		catch(SQLException e) {
			e.printStackTrace();
		}//end of the catch block
		finally {
			try {
				if(st!=null)
					st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end catch block
			try {
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end of the catch block
	}//end of the main method 
	}//end of the finally block
	}//end of the class
