package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		int sal = Integer.parseInt(req.getParameter("sal"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@123");
			PreparedStatement ps=con.prepareStatement("update emp set sal=? where id=?");
			ps.setInt(1, sal);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter pw =res.getWriter();
		pw.write("<h1>Record updated sucessfully</h1>" );
		pw.close();
	
	}

}
