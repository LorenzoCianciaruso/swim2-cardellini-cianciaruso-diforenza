package it.polimi.swimv2.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete the session id associated to the user		
		request.getSession().removeAttribute("id");
		//forward to the login page
		response.sendRedirect(response.encodeRedirectURL("index.jsp"));
	}

}
