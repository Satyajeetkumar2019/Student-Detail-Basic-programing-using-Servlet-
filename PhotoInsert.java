package com.bce.JSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class PhotoInsert {

	public static void main(String[] args)throws Exception ,SQLException ,ClassNotFoundException {
	//create a variable 
		Connection con=null;
		ResultSet rs=null;
		Scanner scn=null;
		String name=null;
		String imagePath=null;
		PreparedStatement ps=null;
		int no=0;
		float salary=0.0f;
		File file=null;
		InputStream is=null;
		int result=0;
		//FileInputStream is=null;
		try {
			//red input end isere 
			scn=new Scanner(System.in);
			if(scn!=null) {
			System.out.println("Enter the no");
			no=scn.nextInt();
			System.out.println("Enter the name");
			name=scn.next();
			System.out.println("Salary ");
			salary=scn.nextFloat();
			System.out.println("Enter the photo path");
			imagePath=scn.next();
			}//end of the if block
			//create inputStrem by location file base on the photo path 
			file=new File(imagePath);
			is=new FileInputStream(file);
			//Register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
//create preparedStatement object
			if(con!=null)
				ps=con.prepareStatement("insert into empall values(?,?,?,?)");
			//set param values 
			if(ps!=null) {
				ps.setInt(1, no);
				ps.setString(2,name);
				ps.setFloat(3,salary);
				ps.setBinaryStream(4,is,file.length());
			}//end of the if block
			//execute the  sql queary 
			if(ps!=null)
			result=ps.executeUpdate();
			//processes the result 
			if(result==0)
				System.out.println("Record insert");
				else
			
					System.out.println("Record  not insert");	
			
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
				if(scn!=null)
					scn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}//end 
			try {
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end of the 
			
			try {
				if(ps!=null)
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}//end of the 
			
		}//end of the finally bloc21
		
	}//end of the mainmethod 

}//end of the class
