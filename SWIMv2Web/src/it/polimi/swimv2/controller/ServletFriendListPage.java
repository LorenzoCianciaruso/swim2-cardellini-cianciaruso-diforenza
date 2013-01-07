package it.polimi.swimv2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFriendListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//TODO Pagina che visualizza l'elenco degli amici di un utente con bottoni per
		// visualizzare il loro profilo
		// IDEA: se mettiamo un campo di ricerca qui dentro facciamo la ricerca solo tra gli amici
		// utilizzando lo stesso codice della ricerca normale, cambia sol la query
	}

}
