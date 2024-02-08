package com.techpalle.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.RegistrationServices;


@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//read the data from browser through servlet
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		String q=request.getParameter("tbQual");
		String p=request.getParameter("tbPwd");
		
		//call dao method to insert data
		int affectedrow = RegistrationServices.doRegister(n, e, q, p);
		
		if(affectedrow != 0)
		{
			response.getWriter().append("<h1 style=\"color:green\">Data is inserted..</h1>");
		}
		else
		{
			response.getWriter().append("<h1 style=\"color:red\">Data is not inserted..</h1>");
		}
		

	}

}
