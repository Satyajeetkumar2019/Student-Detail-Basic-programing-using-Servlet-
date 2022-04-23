//DBServlet.java (show the servlet to db softwere commucation based on the approach 1)
package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class DB3Servlet extends HttpServlet{
Connection con;
PreparedStatement ps;
public void init() {
	//to create variable 
	String s1=null;
	String s2=null;
	String s3=null;
	String s4=null;
	
	try {
		//Get Accesses to ServletContext Object 
		ServletConfig sc=getServletConfig();
		//red context param values from web xml object 
		s1=sc.getInitParameter("driver");
		s2=sc.getInitParameter("dburl");
		s3=sc.getInitParameter("dbuser");
		s4=sc.getInitParameter("dbpwd");
		//create JDBC connection object 
		Class.forName(s1);
		con=DriverManager.getConnection(s2,s3,s4);
		//Create jdbc PreparedStatement object 
		ps=con.prepareStatement(" select empno,empname,job,sal from empy where empno=?");
	}catch(Exception e) {
		e.printStackTrace();
		
	}//end of the catch 
}//end init()

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	try {
		//create variable 
		int no=0;
		PrintWriter pw=null;
		ResultSet rs=null;
		//read from data html form page 
		no=Integer.parseInt(req.getParameter("empno"));
		//General seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//write Jdbc code 
		//set value fro parama values 
		ps.setInt(1,no);
		//excuate the quear 
		rs=ps.executeQuery();
		//processes the result set 
		 if(rs.next())
			 pw.println("<br><i> Employes no is "+rs.getInt(1) +"</i></br>");
		 pw.println("<br><i> Employes Name is "+rs.getString(2) +"</i></br>");	
		 pw.println("<br><i> Employes no is "+rs.getString(3) +"</i></br>");
		 pw.println("<br><i> Employes no is "+rs.getFloat(4) +"</i></br>");	
		//close result set 
		 rs.close();
		 //close stream 
		 pw.close();
	}catch(Exception e) {
		e.printStackTrace();
	}//end of the catch block
}//end of the doGet method 
}//end of the class
