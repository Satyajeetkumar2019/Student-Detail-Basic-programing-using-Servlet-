package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class VoterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws ServletException ,IOException ,NullPointerException {
//to create variable 
		PrintWriter pw=null;
		String name =null;
		String tage=null;
		int age =0;
		//set content type 
		res.setContentType("text/html");
		//set request paramater
		try {
		name=req.getParameter("pname");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		//write request response logic 
		if(age<18)
			pw.println("<h1 style ='color:red;'>"+name+" you are eligibility for vote </h1>");
		else
			pw.println("<h1 style ='color:red;'>"+name+" you are  not eligibility for vote </h1>");
			
		//hyper link 
		pw.println("<a href='Input.html'>  Home </a>");
		//close stream 
		pw.close();
	}//end of the mathod 
}//end of the class
