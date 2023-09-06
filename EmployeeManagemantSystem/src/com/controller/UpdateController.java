package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.BOClass;
import com.dao.dao;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String salary = request.getParameter("salary");
		String des = request.getParameter("designation");
		String doj = request.getParameter("doj");
		String address = request.getParameter("address");
		
		
		BOClass sb = new BOClass();
		
		sb.setId(id);
		sb.setName(name);
		sb.setEmail(email);
		sb.setPhone(phone);
		sb.setDob(dob);
		sb.setSalary(salary);
		sb.setDesignation(des);
		sb.setDoj(doj);
		sb.setAddress(address);
		
		
		int status = dao.getupdateEmployee(sb);
		
		if(status>0)
		{
			pw.print("<script> alert('Data has been updated successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AllEmployeeController");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AllEmployeeController");
			
			rd.include(request, response);
			
			
		}
		
	}

}
