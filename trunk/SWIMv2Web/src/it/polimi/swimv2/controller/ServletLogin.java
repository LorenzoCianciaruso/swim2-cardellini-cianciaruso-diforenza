package it.polimi.swimv2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		
		forward(request, response, "/profile.jsp");
		
		
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException
	{
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(page); 
		rd.forward(request,response);
	}

}
