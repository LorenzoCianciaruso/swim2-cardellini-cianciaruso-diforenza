package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.JobRequest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletJobRequestsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		IJobRequest jobRequestBean = (IJobRequest) JNDILookupClass.doLookup("JobRequestBean");
		//get the id of the user
		int id = (int) request.getSession().getAttribute("id");
		
		//create the lists of both job to perform and requested
		List<JobRequest> requestsToUser = jobRequestBean.findJobRequestByPerformer(id);
		List<JobRequest> requestsByUser = jobRequestBean.findJobRequestByRequestor(id);
		request.setAttribute("requestsToUser", requestsToUser);
		request.setAttribute("requestsByUser", requestsByUser);
		
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/jobRequestsPage.jsp"); 
		rd.forward(request,response);
	}
}

