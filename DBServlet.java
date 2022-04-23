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

import java.sql.*;
public class DBServlet extends HttpServlet {
	//some data base connection 
	Connection con=null;
	PreparedStatement ps=null;
	
	public void init() {
		try {
			//Load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin"
					+ ":@localhost:1521:xe","system","saka");
            //create pre statemant 
			ps=con.prepareStatement(" select empno,empname,job,sal from empy where empno=?");
		   }catch(Exception e) {
			e.printStackTrace();
		  }//end of the catch block
		
	   }//end of the init method()
	
	
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws ServletException ,	IOException {
		try {
			//General seting 
			PrintWriter pw=null;
			int no=0;
			res.setContentType("text/html");
			//red data from html form 
			no=Integer.parseInt(req.getParameter("empno"));
			//select param values to sql queary 
			ps.setInt(1, no);
			//execuate the queary 
			ResultSet rs=ps.executeQuery();
			//processes the result 
			if(rs.next()) {
				pw.println("<br>Emp number "+rs.getInt(1)+" </br>");
				pw.println("<br>Emp Name"+rs.getString(2)+" </br>");
				pw.println("<br>Emp Design "+rs.getString(3)+" </br>");
				pw.println("<br>Emp Salary "+rs.getFloat(4)+" </br>");
			}else {
				pw.println("<br> NO Emp found    </br>");
			}//end else 
		}catch(Exception e) {
			e.printStackTrace();
		}//end catch()
	}//end of the doget method 
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws ServletException ,IOException {
		doGet(req,res);		
	}//end of the doPost()
	public void destroy() {
		//close JDBC CODE HERE 
		try {
			if(ps!=null)
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}//end catch block
		try {
			if(con!=null)
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}//end catch block
	}//end of the method 
}//end of the classs
