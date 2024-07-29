package com.nt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Employee;

public class SelectAllServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@123");
			PreparedStatement ps =con.prepareStatement("select * from emp");
			ResultSet rs =ps.executeQuery();
			List<Employee> list = new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name =rs.getString("name");
				int sal =rs.getInt("sal");
				Employee e =new Employee(id,name,sal);
				list.add(e);
			}
			req.setAttribute("emplist", list);
			RequestDispatcher rd = req.getRequestDispatcher("displayAll.jsp");
			rd.forward(req, res);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	


}
