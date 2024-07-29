package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@123");
			PreparedStatement ps =con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter pw=res.getWriter();
		pw.write("<h1> record deleted sucessfully</h1>");
		pw.close();
				
	}			

}
