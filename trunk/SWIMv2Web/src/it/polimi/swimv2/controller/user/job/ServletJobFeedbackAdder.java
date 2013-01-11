package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.clientutility.JNDILookupClass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletJobFeedbackAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comment = request.getParameter("comment");
		int feedback = Integer.parseInt(request.getParameter("feedback"));
		int jobId = Integer.parseInt(request.getParameter("jobId"));
		
		IJob jobBean = (IJob) JNDILookupClass.doLookup("JobBean");
		
		jobBean.setCommentById(jobId, comment);
		jobBean.setFeedbackById(jobId, feedback);
		
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletProfilePage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	}

}
