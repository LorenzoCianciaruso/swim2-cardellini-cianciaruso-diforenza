package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Job;
import it.polimi.swimv2.entities.JobRequest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletJobAccepted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IJob jobBean = (IJob) JNDILookupClass.doLookup("JobBean");
		IJobRequest jobRequestBean = (IJobRequest) JNDILookupClass.doLookup("JobRequestBean");
		
		//get the request to accept
		int id = Integer.parseInt(request.getParameter("idJobRequest"));
		JobRequest req = jobRequestBean.findJobRequestById(id);
		
		//create new job
		Job job = new Job();
		
		job.setPerformer(req.getPerformer());
		job.setRequestor(req.getRequestor());
		job.setAbility(req.getAbility());
		job.setDate(req.getDate());
		job.setPlace(req.getPlace());
				
		jobBean.save(job);
		
		// delete the Request because we don't need it anymore
		jobRequestBean.remove(req.getId());
		
		//forward to success page
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletJobRequestsPage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);			
	}

}
