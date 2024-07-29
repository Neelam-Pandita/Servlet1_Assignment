package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Reading data from form and storing in the database
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int sal=Integer.parseInt(req.getParameter("sal"));
		//System.out.println(id+" "+name+" "+sal);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@123");
			PreparedStatement ps =con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, sal);
			ps.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PrintWriter pw =res.getWriter();
		pw.write("<h1>Registeration done</h1>");
		pw.close();
		
				
	}



}
