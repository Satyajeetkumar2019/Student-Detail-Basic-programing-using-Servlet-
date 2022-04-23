//some basic programe 
package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class DateFind extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	
	//to create variable below 
	PrintWriter pw=null;
	//set response type 
	res.setContentType("text/html");
	
	//write response 
	pw=res.getWriter();
	Date d=new Date();
	//write response 
	pw.println("<h1 style='color:red'><center>Date And Time :"+d+"</center><h1>");
	//close stream 
pw.close();
	
	
	
}//end of the method 
	
	
	
}//end of the class
