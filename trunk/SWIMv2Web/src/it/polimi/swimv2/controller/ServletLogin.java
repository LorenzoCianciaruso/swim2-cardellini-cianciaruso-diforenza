package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAdmin;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Admin;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//manage login from the Homepage
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//create a stateless Session bean for an user
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAdmin adminBean = (IAdmin) JNDILookupClass.doLookup("AdminBean");
		
		//get login information from the request form sent by the login page
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//make a new user with those email and password
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		//make a new admin
		Admin a = new Admin();
		a.setEmail(email);
		a.setPassword(password);
		
		//I use the Session Bean to check if the made user exist in the database
		User u2 = userBean.findUserByLogin(u);
		
		//if login fail we control if it is an admin
		if(u2 == null){
			//checking the admin table
			Admin a2 = adminBean.findAdminByLogin(a);
			if(a2 == null){
				response.sendRedirect(response.encodeRedirectURL("loginFail.jsp"));
			}else{
				//admin login successful
				HttpSession adminSession = request.getSession(true);
				int adminId = a2.getId();
				adminSession.setAttribute("id", adminId);
				
				request.setAttribute("admin", a2);
				forward(request, response, "/adminProfile.jsp");
			}
		}
		
		//if login is successful redirect to user page
		//creating a new Session with the user id
		else{
			HttpSession session = request.getSession(true);
			int id = u2.getId();
			session.setAttribute("id", id);
			
			request.setAttribute("user", u2);
			forward(request, response, "/profile.jsp");
		}

		
	}
	
	
	//forward steps
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException
	{
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher(page); 
		rd.forward(request,response);
	}

}
