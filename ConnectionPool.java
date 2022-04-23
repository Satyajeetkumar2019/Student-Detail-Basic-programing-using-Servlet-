package com.bce.JSP;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class ConnectionPool extends HttpServlet{

	//@Override 
	protected void doGet(HttpServletRequest req,HttpServletResponse res )throws ServletException ,IOException {
		//ctrate variablt here below 
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PrintWriter pw=null;
		String tabName=null;
		ResultSetMetaData rsmd=null;
		int colCnt=0;
		//general seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//read from data 
		tabName=req.getParameter("table");
		//write JDBC code herr 
		try {
			con=MakeConnection ();
			//create Object 
			st=con.createStatement();
			//send and Excuate queary 
			rs=st.executeQuery("select * from "+tabName);
			//setResult Set Metadat
			rsmd=rs.getMetaData();
			//print connction data
			colCnt=rsmd.getColumnCount();
			pw.println("<table border='1'>");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}//end of the method 

	private Connection MakeConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}//end of the class 
