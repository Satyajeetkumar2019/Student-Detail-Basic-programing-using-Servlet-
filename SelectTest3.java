//WRITE A jdbc progrsms that give employes detail base on the given detail 
package com.bce.JSP;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.IOException;
public class SelectTest3 {
	public static void main(String[] args)throws SQLException {
		//initilize the variabel 
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		Scanner scn=null;
		String str1=null;
		String str2=null;
		String str3=null;
		String condation =null;
		boolean flag=false;
		try {
			//read input from end user 
			scn=new Scanner(System.in);
			if(scn!=null)
				System.out.println("Enter the str2");
			str1=scn.next().toUpperCase();
			System.out.println("Enter the str 2");
			str2=scn.next().toUpperCase();
			System.out.println("Enter the str3");
			str3=scn.next().toUpperCase();
			condation =(str1+" "+str2+" "+str3);
			//LOAD The driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//get a connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			//create Statement 
			if(con!=null)
				st=con.createStatement();
			//from QUEARY 
			String q= "select empno,ename,job,sal from emp8 where job in"+condation+"ORDER BY job";
			if(st!=null)
				rs=st.executeQuery(q);
			if(rs!=null) {
				while(rs.next()) {
					
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}//end of the while
			}//end of the if block
			else {
				System.out.println("No Record Found ");
			}	//end of the else
		}//end of the try block
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
			
		}//end of the finally 
		
	}//end of the main method 
}//end of the class
