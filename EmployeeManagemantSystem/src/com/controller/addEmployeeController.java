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
 * Servlet implementation class addEmployeeController
 */
@WebServlet("/addEmployeeController")
public class addEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeeController() {
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
		
		System.out.println("This is console");
		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String salary = request.getParameter("salary");
		String des = request.getParameter("des");
		String doj = request.getParameter("doj");
		String address = request.getParameter("address");
		
		
		BOClass ob = new BOClass();
		
		ob.setName(name);
		ob.setEmail(email);
		ob.setPhone(phone);
		ob.setDob(dob);
		ob.setSalary(salary);
		ob.setDesignation(des);
		ob.setDoj(doj);
		ob.setAddress(address);
		
		
		int status = dao.addEmployee(ob);
		
		if(status>0)
		{
			pw.print("<script> alert('Employee data added successfully..') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong..try again') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AddEmployee.html");
			
			rd.include(request, response);
			
		}
	}

}
