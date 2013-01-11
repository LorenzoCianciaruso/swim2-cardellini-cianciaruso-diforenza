package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.JobRequest;
import it.polimi.swimv2.entities.User;

import java.io.IOException;
import java.util.ArrayList;
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
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		//get the id of the user
		int id = (int) request.getSession().getAttribute("id");
		
		//create the lists of both job to perform and requested
		List<JobRequest> requestsToMe = jobRequestBean.findJobRequestByPerformer(id);
		List<JobRequest> requestsByMe = jobRequestBean.findJobRequestByRequestor(id);
		request.setAttribute("requestsToMe", requestsToMe);
		request.setAttribute("requestsByMe", requestsByMe);
		
		//create the lists of users names
		List<User> userIAsked = new ArrayList<User>();
		List<User> userAskedToMe =  new ArrayList<User>();
		int requestorId;
		
		for (int i = 0; i < requestsToMe.size(); i++) {
			// build the list that contains abilities name
			requestorId = requestsToMe.get(i).getRequestor();
			userAskedToMe.add(userBean.findUserById(requestorId));
		}
		
		int performerId;
		for (int i = 0; i < requestsByMe.size(); i++) {
			// build the list that contains abilities name
			performerId = requestsByMe.get(i).getPerformer();
			userIAsked.add(userBean.findUserById(performerId));
		}
		
		request.setAttribute("userIAsked", userIAsked);
		request.setAttribute("userAskedToMe", userAskedToMe);
		
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userJobRequestsManager.jsp"); 
		rd.forward(request,response);
	}
}

