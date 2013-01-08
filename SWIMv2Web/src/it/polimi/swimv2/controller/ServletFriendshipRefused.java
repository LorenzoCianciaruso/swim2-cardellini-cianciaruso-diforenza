package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFriendshipRefused extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idFriendshipRequest"));
		
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");

		// removes friendship Request
		friendshipRequestBean.remove(id);

		// return to success page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/done.jsp");
		rd.forward(request, response);
	}

}
