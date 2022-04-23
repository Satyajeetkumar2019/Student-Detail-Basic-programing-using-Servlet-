package com.bce.JSP;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
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
public class ConnectionPoolServlet {
	private DataSource ds;
protected void doGet(HttpServletRequest req,
		HttpServletResponse res)throws ServletException ,IOException  {
	//create variable 
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PrintWriter pw=null;
	String tabname=null;
	ResultSetMetaData rsmd=null;
	int count=0;
	//General Seting 
	pw=res.getWriter();
	res.setContentType("text/html");
	//read from data 
	tabname=req.getParameter("tname");
	//write JDBC code from the remeaning work
	try {
		//get connection from jdbc 
		con=makeConnection ();
		//Create statement oject 
		st=con.createStatement();
		//send data and execuate queary 
		rs=st.executeQuery("select  * from "+tabname);
		//get result set meta data 
		rsmd=rs.getMetaData();
		//print cplume name
		count=rsmd.getColumnCount();
		pw.println("<table border='1' bgcolor='red'>");
		pw.println("<tr bgcolor='cyan'>");
		for(int i=1;i<=count;i++) {
			pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			
		}//end of the for block
		pw.println("</tr>");
		//processes the result set data 
		while(rs.next())
			pw.println("<tr>");
		for(int i=1;i<=count;i++) {
			pw.println("<td>"+rs.getString(i)+"</td>");
			
		}//end of the for block
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("<br><a href='index4.html'>Try Agine</a></br>");
		//close jdbc object 
		rs.close ();
		st.close();con.close();
	}catch(Exception e) {
		pw.println("<br><a href='index4.html'>Try Agine</a></br>");
		e.printStackTrace();
		
	}//end of the catch block
	
			//close streame 
	pw.close();
}//end of the method 
	
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	doGet(req,res);
}//end method 
private Connection MakeConnection () {
		Connection con=null;
		try {
			con=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}//end catch 
		
		return con;
	}//end method 
	
	
	
}//end of the class
