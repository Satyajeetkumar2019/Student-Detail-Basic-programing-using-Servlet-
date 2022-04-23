//WishApp
package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class WishApp extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	//create variable 
		PrintWriter pw=null;
		Calendar c=null;
		int h=0;
		//Generic seting 
		pw=res.getWriter();
		//set content type 
		res.setContentType("text/html");
		//Get system Date
		c=Calendar.getInstance();
		h=c.get(Calendar.HOUR_OF_DAY);
		//Generate Wish Message 
		if(h<=12) 
		pw.println("<h1 style='color:red;'><center>Good Morning</center> </h1>");	
		else if(h<=17)
			pw.println("<h1 style='color:red;'><center>Good Afternoon </center> </h1>");	
		else if(h<=20)
			pw.println("<h1 style='color:red;'><center>Good Evening </center> </h1>");	
		else 
			pw.println("<h1 style='color:red;'><center>Good Night</center> </h1>");		
		//Generate Hyper link 
		pw.println("<a href='http://localhost:7777/Student_Detail/drink123/*'>  Home </a>");
		//close stream
		pw.close();
	}//end of the serve method
}//end of the class
