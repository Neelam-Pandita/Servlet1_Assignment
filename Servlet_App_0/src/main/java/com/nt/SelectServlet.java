package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Employee;

public class SelectServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//reading data from web form
		int id =Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@123");
			PreparedStatement ps =con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			if(rs.next()) {
				int i=rs.getInt("id");
				String name =rs.getString("name");
				int sal=rs.getInt("sal");
				
				//call display.jsp from servlet
				Employee e =new Employee(i,name,sal);
				req.setAttribute("emp", e);
				
				
				RequestDispatcher rd =req.getRequestDispatcher("Display.jsp");
				// forwarding 2 trucks to jsp
				rd.forward(req, res);
				//settin data for req to forward to jsp
				//req.setAttribute("empid", id);
				//req.setAttribute("ename", n);
				//req.setAttribute("esal", s);
				
				
				
				
				//pw.write("<h1>record details are here</h1>");
				pw.write(i+" "+name+" "+sal);
				}
			
			else{
				pw.write("<h1>record is not present</h1>");
			}
			pw.close();
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	

}
