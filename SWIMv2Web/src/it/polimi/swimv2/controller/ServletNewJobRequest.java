package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.JobRequest;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNewJobRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// create a new Session Bean
		IJobRequest bean = (IJobRequest) JNDILookupClass
				.doLookup("JobRequestBean");

		// get info from the page
		int idPerformer = Integer.parseInt(request
				.getParameter("userPerformerId"));
		int idRequestor = (int) request.getSession().getAttribute("id");
		int idAbility = Integer.parseInt(request.getParameter("ability"));
		String place = request.getParameter("place");
		String date = request.getParameter("date");

		if (place.equals("") || !checkDate(date)) {
			response.sendRedirect(response.encodeRedirectURL("messageFail.jsp"));
		} else {
			// create a new job request
			JobRequest j = new JobRequest();
			j.setPerformer(idPerformer);			
			j.setRequestor(idRequestor);
			j.setAbility(idAbility);
			j.setPlace(place);
			j.setDate(date);

			// save the entity created in the DataBase
			bean.save(j);

			// forward to success page
			ServletContext sc = getServletContext();
			request.setAttribute("next", "ServletProfilePage");
			RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
			rd.forward(request, response);

		}
	}
	
	public static boolean checkDate(String input) {
		String regex = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9][0-9]";
		if (Pattern.matches(regex, input))
			return true;
		else
			return false;
	}
}
