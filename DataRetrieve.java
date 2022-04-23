package com.bce.JSP;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java. text. SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Date;

public class DataRetrieve {
private static final String DATE_SELECT_QUEARY="SELECT * FROM PERSON_TAB";
	public static void main(String[] args)throws Exception ,SQLException ,ClassNotFoundException {
	//create variable 
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		int id=0;
		String name=null;
		java.sql.Date sqdob=null;
		java.sql.Date sqdoj=null;
		java.sql.Date sqdom=null;
		
		java.util.Date udob=null;
		java.util.Date udoJ=null;
		java.util.Date udom=null;
		
		String          sdob=null;
		String          sdoj=null;
		String          sdom=null;
		boolean         flag=false;
	    java. text. SimpleDateFormat sdf=null;
		try {
			//REGISTER jdbc driver class manager 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");

			//create preparesatatement 
			if(con!=null)
				ps=con.prepareStatement(DATE_SELECT_QUEARY);
			//execuate queary 
			if(ps!=null)
				rs=ps.executeQuery();
			//processes result
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					id=rs.getInt(1);
					name=rs.getString(2);
					sqdob=rs.getDate(3);
					sqdoj=rs.getDate(4);
					sqdom=rs.getDate(5);
					//class object 
					udob=(java.util.Date)sqdob;
					udoJ=(java.util.Date)sqdoj;
					udom=(java.util.Date)sqdom;
					//convert java.util.Date to class object to String data
					sdf=new SimpleDateFormat("MMM-DD-YYYY");
					sdob=sdf.format(udob);
					sdoj=sdf.format(udoJ);
					sdom=sdf.format(udom);
					System.out.println(id+" "+name+" "+sdob+" "+sdoj+" "+sdom);
				}//end while block
			}//end of the  if block 
			if(flag==false)
			System.out.println(" ");
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
					}//end of the 
					
				}//end of the finally block

	}//end of the main method 

}//end of the class
