package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOOKUP_STRING = "UserBean/remote";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUser bean = doLookup();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String telephone = request.getParameter("phone");
		String city = request.getParameter("city");
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		u.setName(name);
		u.setTelephone(telephone);
		u.setCity(city);
		
		bean.saveUser(u);
		
		response.sendRedirect(response.encodeRedirectURL("registrationOKPage.jsp"));
		
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

}
