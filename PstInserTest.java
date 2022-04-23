//Data insert into table using Preparestatement 
package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PstInserTest {
public static void main(String []args)throws Exception,SQLException ,ClassNotFoundException {
	//to create variable
	Connection con=null;
	PreparedStatement ps=null;
	String NAME=null;
	String  ADDRESH=null;
	int count=0;
	String q=null;
	int result=0;
	int REGNO=0;
	Scanner scn=null;
	try {
		//red input data into end usere 
		scn=new Scanner(System.in);
		if(scn!=null) {
			System.out.println("Enter the student count :");
			count=scn.nextInt();
		}//end of the if block
		//load jdbc driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
		//Prepare sql queary 
		q="insert into students values(?,?,?)";
		if(con!=null)
		ps=con.prepareStatement(q);
		//red multiple values in endusere 
		if(scn!=null) {
			for(int i=1;i<=count;i++) {
				System.out.println("Enter the "+i+"student detail :");
				System.out.println();
				System.out.println();
				System.out.println("Enter the Name :");
				NAME=scn.nextLine();
				System.out.println("Enter the student Addressh :");
				 ADDRESH=scn.nextLine();
				 System.out.println("Enter the student number :");
					REGNO=scn.nextInt();
				//set the input values red from the endusere to queary param methe 
				ps.setString(2,NAME);
				ps.setString(3, ADDRESH);
				ps.setInt(1,REGNO);
				//Execuate the queary 
				result=ps.executeUpdate();
				if(result!=0)
					System.out.println(i+"student detail are successfully insert ");
				else
					System.out.println(i+"student detail are not insert ");
			}//end of for loop 
		}//end of the if block
	}//end of the try block
	catch(Exception e) {
		e.printStackTrace();
	}//end of the catch block
	//close jdbc object 
			finally {
				try {
					if(ps!=null)
						ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}//end of teh catch block
				try {
					if(con!=null)
						con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}//end 
				try {
					if(scn!=null)
						scn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}//end of the 
				
			}//end of the finally block

	
	
	
}//end of the main method 
	
	
	
}//end of the class
