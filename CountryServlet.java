package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class CountryServlet extends HttpServlet{
//to create variable 
	//PrintWriter pw=null;
	public void doGet(HttpServletRequest req,
			HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=null;
		//to create variable 
		String A[]= {"abc","pqr","ddj"};
		String B[]= {"pqw","pqr","ddj"};
		String C[]= {"abc","pqr","ddj"};
		String country=null;
		pw=res.getWriter();
		//red data from param values 
		country=req.getParameter("country");
		//General Seting 
		res.setContentType("text/html");
		//get state base on the country that is select 
		if(country.equals("india")) {
			pw.println("<h1>state is "+Arrays.toString(A)+"</h1>");
		}//end of the if 
		else if(country.equals("us"))
			pw.println("<h1>State is "+ Arrays.toString(B)+"</h1>");
		
		else 
			
			pw.println("<h1>State is "+ Arrays.toString(C)+"</h1>");
			
		//CLOSE stream 
		pw.close();
		
	}//end of the method 
	
	public void doPost(HttpServletRequest req,
			HttpServletResponse res)throws ServletException,IOException {
		doGet(req,res);
	}//end doPost
}//end of the class
