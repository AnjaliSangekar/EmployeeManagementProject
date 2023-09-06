package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.dao;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//boolean status = dao.loginvalid(email, password);
		
		if(dao.loginvalid(email, phone))
		{
			pw.print("<script> alert('Login successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something wrong..Try again...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			
			rd.include(request, response);
			
		}

	}

}
