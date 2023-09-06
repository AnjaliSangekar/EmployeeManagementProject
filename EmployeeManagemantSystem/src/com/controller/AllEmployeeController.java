package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.BOClass;
import com.dao.dao;

/**
 * Servlet implementation class AllEmployeeController
 */
@WebServlet("/AllEmployeeController")
public class AllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		pw.print("<a href='home.html' > <input type='button' id='btn' value='home'> </a> <br><br>");
		
		pw.print("<table width='100%'>");
		
		pw.print("<tr> <th>ID</th> <th>Name</th> <th>Email</th> <th>Phone</th> <th>DOB</th> <th>Salary</th> <th>Role</th> <th>DOJ</th> <th>Address</th> <th>Update</th> <th>Delete</th></tr>");
		
		List<BOClass> list = dao.getAllEmployee();
		
		for(BOClass sb: list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td><td>"+sb.getEmail()+"</td><td>"+sb.getPhone()+"</td><td>"+sb.getDob()+"</td><td>"+sb.getSalary()+"</td><td>"+sb.getDesignation()+"</td><td>"+sb.getDoj()+"</td><td>"+sb.getAddress()+"</td><td>"+"<a href='EditServlet?id="+sb.getId()+"'> edit </a> </td> <td><a href='DeleteController?id="+sb.getId()+"'>delete </a></td></tr>");       
		}
				
		pw.print("</table>");	
		
	}

	
}
