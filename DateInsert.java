package com.bce.JSP;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java. text. SimpleDateFormat;
import java.sql.PreparedStatement;
//import java.util.Date;
import java.sql.Date;

public class DateInsert {
	public static void main(String[] args)throws SQLException ,ClassNotFoundException,Exception {
	//create variable 
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Scanner scn=null;
		String name=null;
		String dob=null;
		String doj=null;
		SimpleDateFormat sdf=null;
		java.util.Date udab=null;
		java.sql.Date dqdob=null;
		java.sql.Date sqdoj=null;
		int no=0;
		long ms=0;
		int result=0;
		try {
			//red input enduser 
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter the no");
				no=scn.nextInt();
				System.out.println("Enter name ");
				name=scn.next();
				System.out.println("Enter DOB(DD-MM-YYYY)");
				dob=scn.next();
				System.out.println("Enter DOJ(YYY-MM-DD)");
				doj=scn.next();
			}//end of the if block
			//CONVERT String data into date class clas objec 
			//FOR DOB
			sdf=new SimpleDateFormat("dd-mm-yyyy");
			if(sdf!=null)
				udab=sdf.parse(dob);
			if(udab!=null)
				ms=udab.getTime();
			dqdob=  new java.sql.Date(ms);
			//FOR DOJ
			sqdoj= java.sql.Date.valueOf(doj);
			// load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			//create preparestatement 
			if(con!=null)
				ps=con.prepareStatement("insert into person_tab values(?,?,?,?)");
			//set param values 
			if(ps!=null) {
			ps.setInt(1,no);
			ps.setString(2,name);
			ps.setDate(3,dqdob);
			ps.setDate(4,sqdoj);

			}//end if block
			//execute sql queary 
			if(ps!=null) {
				result=ps.executeUpdate();
				//PROCESSES result set
			}//end of the if block
			if(result==0)
				System.out.println("Record not insert ");
				else
			System.out.println("Record insert ");
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
					try {
						if(scn!=null)
							scn.close();
					}catch(Exception e) {
						e.printStackTrace();
					}//end of the
				}//end of the finally bloc
	}//end of the main method 

}//end of the class
