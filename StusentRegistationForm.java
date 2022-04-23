package com.bce.JSP;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
public class StusentRegistationForm extends HttpServlet{
public void doGet(HttpServletRequest req,
		HttpServletResponse res)throws ServletException ,IOException ,NumberFormatException{
	//to create variable 
	String name =null;
	String course=null;
	String fathername=null;
	String mothername=null;
	int age=0;
	int clas=0;
	String tclass=null;
	//converter need 
	String tage=null;
	String addresh=null;
	//convrter need
	int number=0;
	String tnumber=null;
	//converter need 
	int aadhaar=0;
	String taadhaar=null;
	
	PrintWriter pw=null;
	//set content type 
	pw=res.getWriter();
	res.setContentType("text/html");
	//red getparam values 
	name=req.getParameter("name");
	course=req.getParameter("Course");
	fathername=req.getParameter("Fathername");
	mothername=req.getParameter("mothername");
	addresh=req.getParameter("add");
	tage=req.getParameter("age");
	age=Integer.parseInt(tage);
	tnumber=req.getParameter("number");
	number=Integer.parseInt(tnumber);
	taadhaar=req.getParameter("aadhaar");
	aadhaar=Integer.parseInt(taadhaar);
	tclass=req.getParameter("Class");
	clas=Integer.parseInt(tclass);
	//print Given result or input
	pw.println("<h4>successfull </h4>");
	pw.println("<h4>Name"+name+"  </h4>");
	pw.println("<h4>Name"+fathername+"  </h4>");
	pw.println("<h4>Name"+mothername+"  </h4>");
	pw.println("<h4>Name"+course+"  </h4>");
	pw.println("<h4>Name"+clas+"  </h4>");
	pw.println("<h4>Name"+number+"  </h4>");
	pw.println("<h4>Name"+aadhaar+"  </h4>");
	pw.println("<h4>Name"+addresh+"  </h4>");
	pw.println("<h4>Name"+age+"  </h4>");
	

//close stream
	pw.close();
	
}//end of the class
public void doPost(HttpServletRequest req,
		HttpServletResponse res)throws ServletException ,IOException {
	doGet(req,res);	}

}//end of the class
