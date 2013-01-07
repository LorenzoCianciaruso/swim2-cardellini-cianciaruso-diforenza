package it.polimi.swimv2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFriendshipPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentId = (int) request.getSession().getAttribute("id");
		
		// interrogare la tabella FriendshipRequest per ottenere le richieste in base all'id passato
		// inviare la lista delle richieste fatte e la lista di quelle ricevute ad una pagina .jsp
	}

}
