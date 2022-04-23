//to write a jdbc programe to veryfied end usere write a wrong 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class LoginApp {

	public static void main(String[] args)throws SQLException ,ClassNotFoundException ,Exception {
		//create a variable 
		Connection con=null;
		ResultSet  rs=null;
		Statement st=null;
		Scanner scn=null;
		String uname=null;
		String pwd=null;
		String q=null;
		int count=0;
		try {
			//get a input end usere
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter the user name ");
				uname=scn.nextLine();
				System.out.println("Enter valid password ");
				pwd=scn.nextLine();
			}//end of the if block
			//convert into values as sql queary 
			uname=""+uname+"";//raja 
			pwd=""+pwd+"";//rani
			//load driver class manager 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			if(con!=null)
			//create jdbc Ststement 
			st=con.createStatement();
			//Prepare sql queary 
			q="select count(*) from uselist where UNAME="+uname+" and  UPWD ="+pwd;
			
			System.out.println(q);
			//Execuate the sql queary 
			if(st!=null)
				rs=st.executeQuery(q);
			//processes the result set 
			if(rs!=null) {
				while(rs.next()) {
					count=rs.getInt(1);
					System.out.println(count);
				}//end of the while
			}//end of the if block
			if(count==0)
				System.out.println("Invalid usere ");
				else
			System.out.println("Valid usere ");
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
