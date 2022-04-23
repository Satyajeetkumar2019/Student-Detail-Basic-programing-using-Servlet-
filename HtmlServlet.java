package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class HtmlServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse  res)throws ServletException ,IOException {
	//to create the veriable below 
		PrintWriter pw=null;
		pw=res.getWriter();
		//set REsponse write 
		res.setContentType("text/html");
		//write b logic below 
		pw.println("<table border='1'>");
		pw.println("<tr><th>playear</th> <th>Role</th></tr>");
		pw.println("<tr><th>	Doni</th> <th>Captan</th></tr>");
		pw.println("<tr><th>Sachin</th> <th>All ronder</th></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	}//end of the method 
}//end of the class 
