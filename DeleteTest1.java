//Write a jdbc application to delete record base on the on the given student number
package com.bce.JSP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
public class DeleteTest1 {
	public static void main(String[] args) {
		//create basic variable 
				Connection con=null;
				ResultSet rs=null;
				Statement st=null;
				int result=0;
				int no=0;
				Scanner scn=null;
				try {
					//input data in end usere
					scn=new Scanner(System.in);
					System.out.println("Enter the no of student which are u want to delete ");
					no=scn.nextInt();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//establish the connection 
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
					if(con!=null)
					//create jdbc Ststement 
					st=con.createStatement();
					//send and exceute queary database 
					if(st!=null)
						result=st.executeUpdate("delete from students where regno="+no);
					//processes result data 
					if(result==0)
						System.out.println("Record not found :");
						else
					System.out.println(result+"Delete susseccesfull");
				}//end of the try block
				catch(Exception e) {
					e.printStackTrace();
				}//end of the catch block
				
				//close jdbc object 
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
					
				}//end of the finally block
	}//end of the main method 
}//end of the class
