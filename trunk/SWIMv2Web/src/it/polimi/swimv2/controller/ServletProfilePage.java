package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUser bean = JNDILookupClass.doLookup();
		
		//controllo a quale utente corrisponde la sessione
		//prendo l'id della sessione
		int currentSessionId = (Integer) request.getSession().getAttribute("id");
		
		//creo un utente con l'id della sessione
		User user = new User();
		user.setId(currentSessionId);
		
		//cerco nel database l'utente del quale corrisponde l'id della sessione
		User currentUser = bean.findUserById(user);
		
		if(currentUser == null){
			//mando alla pagina di errore login
			response.sendRedirect(response.encodeRedirectURL("loginFail.jsp"));
		}else{
			//setto la request con il parametro utente
			request.setAttribute("user", currentUser);
			
			//faccio il forward
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher("/profile.jsp"); 
			rd.forward(request,response);
			
		}
		
		
	}

}
