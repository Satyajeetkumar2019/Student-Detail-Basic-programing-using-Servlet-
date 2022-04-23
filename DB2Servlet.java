package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class DB2Servlet extends HttpServlet{
//to create variable object 
	Connection con=null;
	PreparedStatement ps=null;
	public void init() {
		try {
			//get sevle configure object 
			ServletConfig cg=getServletConfig();
			//red input from web.xml 
			String s1=null;
			String s2=null;
			String s3=null;
			String s4=null;
			s1=cg.getInitParameter("driver");
			s2=cg.getInitParameter("dburl");
			s3=cg.getInitParameter("dbpwd");
			s1=cg.getInitParameter("dbuser");
			//create jdbc connection object 
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			//create JDBC preparadStatement object 
			ps=con.prepareStatement("select empno,empname,job,sal from empy where empno=?");
		}catch(Exception e) {
			e.printStackTrace();
		}//end of catch block
	}//end of the init()
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		
		int no=0;
		PrintWriter pw=null;
		
		try {
			//red data from html form 
			pw=res.getWriter();
			res.setContentType("text/html");
			//red data from html form page below 
			no=Integer.parseInt(req.getParameter("empno"));
			
			//write JDBC code here 
			//set values to param of the queary 
			ps.setInt(1,no);
			//execuate queary 
			ResultSet rs=ps.executeQuery();
			//processes the result set 
			if(rs.next())
				pw.println("<h3>Empno is "+rs.getString(1)+"</h3>");
			pw.println("<h3>Emp salary is  "+rs.getFloat(1)+"</h3>");
			//close stream 
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}//end of the catch block
	}//end of the doGet();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		doGet(req,res);	
	}//end dopost();
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}//end of the catch block
		try {
			if(con!=null)
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}//end of the catch block
	}//end destroy
}//end class
