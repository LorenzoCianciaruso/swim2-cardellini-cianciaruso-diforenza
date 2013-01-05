package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.JobRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletNewJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// create a new Session Bean
		IJobRequest bean = (IJobRequest) JNDILookupClass.doLookup("JobRequestBean");
		
		// get info and create new entity
		int idPerformer = (int) request.getAttribute("userPerformerId");		
		int idRequestor = (int) request.getSession().getAttribute("id");
		int idAbility = Integer.parseInt(request.getParameter("ability"));
		String place = request.getParameter("place");
		String date = request.getParameter("date");

		// TODO decidere se serve l'if per l'errore
		if (false) {
			response.sendRedirect(response.encodeRedirectURL("error.jsp"));
		} else {

			// create a new job request
			JobRequest j = new JobRequest();

			j.setIdPerformer(idPerformer);
			j.setRequestor(idRequestor);
			j.setAbility(idAbility);
			j.setPlace(place);
			j.setDate(date);

			// save the entity created in the DataBase
			bean.saveJobRequest(j);

			// TODO redirect to user page
			// redirect to the registrationOkPage
			// int id = bean.findUserByLogin(session).getId();
			// HttpSession session = request.getSession(true);
			// session.setAttribute("id", id);

			// ServletContext sc = getServletContext();
			// RequestDispatcher rd =
			// sc.getRequestDispatcher("/registrationOKPage.jsp");
			// rd.forward(request,response);

		}

	}

}
