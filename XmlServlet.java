package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class XmlServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		//get PrintWrite Object 
			PrintWriter pw=null;
			//set print wRITER 
			pw=res.getWriter();
			//setContentType 
			res.setContentType("text/xml");
			//write b logic below 
			pw.println("<table border='0'>");
			pw.println("<tr><th>playear</th> <th>Role</th></tr>");
			pw.println("<tr><th>	Doni</th> <th>Captan</th></tr>");
			pw.println("<tr><th>Sachin</th> <th>All ronder</th></tr>");
			pw.println("</table>");
			//close stream
			pw.close();	
	}//method close 
}//class close 
