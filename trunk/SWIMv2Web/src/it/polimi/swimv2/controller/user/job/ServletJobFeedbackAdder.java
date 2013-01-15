package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Job;

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
		IAbilityDeclared abDecBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilityDeclaredBean");
		
		jobBean.setCommentById(jobId, comment);
		jobBean.setFeedbackById(jobId, feedback);
		
		// Update AbilitiesDeclared table in db
		Job job = jobBean.findById(jobId);
		int idAbility = job.getIdAbility();
		int idUser = job.getIdPerformer();
		abDecBean.setFeedbackById(idAbility, idUser, feedback);
		
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletProfilePage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	}

}
