package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement ;
public class InsertTest1 {

	public static void main(String[] args) {
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		int result=0;
		
		try {
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
		result=st.executeUpdate("insert into students(NAME,ADDRESH,REGNO) values('1002','bihar','98')");
		//processes result 
		if(result!=0)
			System.out.println("Record successfully insert :");
		else
			System.out.println("not insert data in database :");
		
		
		//print data into database table 
		if(st!=null)
		rs=st.executeQuery(" select * from students");
		//print database table 
				if(rs!=null)
					while(rs.next()!=false) {
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					}//end of the while block
		
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
	}//end of the finally block
	}//end of the main method
}//end of the class
