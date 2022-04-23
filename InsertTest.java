//Write a JDBC application that grater student detail from base on the use usere insert into student 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement ;
public class InsertTest {
	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		String NAME=null;
		String  ADDRESH=null;
		int REGNO=0;
		String q=null;
		Scanner scn=null;
		int result=0;
		try {
			//input data end user 
			scn=new Scanner(System.in);
			if(scn!=null) {
			System.out.println("enter the  student regno ");
			REGNO=scn.nextInt();
			System.out.println("Enter the student name");
			NAME=scn.next();
			System.out.println("Enter the student Addresh ");
			 ADDRESH=scn.next();
			}//end if block
			//convert into selqueary 
			NAME=""+NAME+"";
			 ADDRESH=""+ ADDRESH+"";
			//load a driver manager class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			//create statement 
			if(con!=null)
			st=con.createStatement();
			//prepare sql queary 
			if(st!=null)
			// q=" insert into students(REGNO,NAME, ADDRESH) values("+regno+","+name+","+ ADDRESH+")";
			//System.out.println(q);
			//send and Execute queary in database softwere 100
			result=st.executeUpdate("INESRT INTO STUDENTS VALUES("+REGNO+","+NAME+" ,"+ ADDRESH+")");
			//processes result 
			if(result!=0)
				System.out.println("Record successfully insert :");
			else
				System.out.println("not insert data in database :");
		}//end of the try block
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
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
