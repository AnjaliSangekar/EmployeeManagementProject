package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.BOClass;
import com.dao.dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BOClass sb = dao.getEmployeeDataById(id);
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\edit.css\">");
		
		pw.print("<form action='UpdateController' method='post'>");
		
		pw.print("<h1>Form</h1>");
		
		pw.print("<table>");
		
		pw.print("<tr><td> <input type='hidden' name='id' value='"+sb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td> <input type='text' name='name' value='"+sb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email: </td> <td> <input type='text' name='email' value='"+sb.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Phone: </td> <td> <input type='text' name='phone' value='"+sb.getPhone()+"'/></td></tr>");
		pw.print("<tr><td>DOB: </td> <td> <input type='text' name='dob' value='"+sb.getDob()+"'/></td></tr>");
		pw.print("<tr><td>Salary: </td> <td> <input type='text' name='salary' value='"+sb.getSalary()+"'/></td></tr>");
		pw.print("<tr><td>Role: </td> <td> <input type='text' name='designation' value='"+sb.getDesignation()+"'/></td></tr>");
		pw.print("<tr><td>DOJ: </td> <td> <input type='text' name='doj' value='"+sb.getDoj()+"'/></td></tr>");
		pw.print("<tr><td>Address: </td> <td> <input type='text' name='address' value='"+sb.getAddress()+"'/></td></tr>");
		
		//pw.print("<br>");
		pw.print("<tr> <td> <input type='submit' value='Update' class='btn'/></td></tr>");
		
		pw.print("</table>");
		
		pw.print("</form>");
		
		
	}

}
