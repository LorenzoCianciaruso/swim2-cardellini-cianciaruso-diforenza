package it.polimi.swimv2.controller;



import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOOKUP_STRING = "UserBean/remote";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUser bean = doLookup();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		User u2 = bean.findUserByLogin(u);
		
		if(u2 == null){
			response.sendRedirect(response.encodeRedirectURL("loginPage.jsp"));
		}else{
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			forward(request, response, "/profile.jsp");
		}
		
		
		
		
		
	}
	
	private IUser doLookup() {
		Context context = null;
		IUser bean = null;
		
		try {
            // 1. Obtaining Context
            context = it.polimi.swimv2.clientutility.JNDILookupClass.getInitialContext();
            // 2. Lookup and cast
            bean = (IUser) context.lookup(/*LOOKUP_STRING*/"UserBean");
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
		
		return bean;
	}
	
	

	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException
	{
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(page); 
		rd.forward(request,response);
	}

}
