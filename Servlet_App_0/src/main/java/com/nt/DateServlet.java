package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		Date dt =new Date();
		PrintWriter pw =res.getWriter();
		pw.write("<h1 style ='color:green'> current date and time is"+ dt + "</h1>");
		pw.close();
		
	}

}
