package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class MarrageServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws ServletException ,IOException ,NullPointerException {
//to create variable 
		PrintWriter pw=null;
		String name =null;
		String mf=null;
		String tage=null;
		int age=0;
		//request get writer 
		pw=res.getWriter();
	//to set content type 
		res.setContentType("text/html");
		//get param values 
		name=req.getParameter("pname");
		mf=req.getParameter("m");
		tage=req.getParameter("age");
		age=Integer.parseInt(tage);
		//write b logic 
		if(age<21)
			pw.println("<h1>mr."+name+ " you are not Eligible for marray </h1>");
		else 
			pw.println("<h1>mr."+name+ " you are  Eligible for marray </h1>");
		//close stream 
		pw.close();
	}//end of the method 
}//end of the class
