package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class LoginApp1 {
	public static void main(String[] args)throws SQLException ,ClassNotFoundException ,Exception {
	//intilize the variable 
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		String uname=null;
		String upwd=null;
		int count=0;
		String q=null;
		Scanner scn=null;
		try {
			//red input data in end usere 
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter the usere name ");
			uname=scn.next();
			System.out.println(	"Enter the password ");
			upwd=scn.next();
			}//end of the  block
			//load jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			//prepare sql queary 
			q="select count(*) from us where uname=? and upwd=?";
			if(con!=null)
				ps=con.prepareStatement(q);
			//set as parame values 
		if(ps!=null) {
				ps.setString(1,uname);
		        ps.setString(2,upwd);
		 
		}//end of the if block
		//send and execuate the sql queary 
		if(ps!=null)
			rs=ps.executeQuery();
		if(rs!=null) {
			if(rs.next()) {
				count=rs.getInt(1);
			}//end of the if block
		}//end of the if block
			if(count!=0)
				System.out.println("Valid Credentials");
				else
					System.out.println(" InValid Credentials");
		}catch(SQLException e) {
			e.printStackTrace();
		}//end of the catch block
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}//end of the catch block
		catch(Exception e) {
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
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end 
			try {
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end of the catch block
			
			try {
				if(scn!=null)
					scn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}//end of the catch block
			
		}//end of the finally block
	}//end of the main method 

}//end of the class
