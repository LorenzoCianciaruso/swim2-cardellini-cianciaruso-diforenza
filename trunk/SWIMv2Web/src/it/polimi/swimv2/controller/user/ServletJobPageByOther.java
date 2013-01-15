package it.polimi.swimv2.controller.user;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Ability;
import it.polimi.swimv2.entities.Job;
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


public class ServletJobPageByOther extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("toShow"));
		
		IJob jobBean = (IJob) JNDILookupClass.doLookup("JobBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		
		List<Job> listPerformedJob = jobBean.findByPerformerId(id);
		List<Job> listAskedJob = jobBean.findByRequestorId(id);
		List<Ability> listOfAbility = abilityBean.allAbilities();
		
		List<User> listUserPerformed = new ArrayList<User>();
		List<User> listUserRequester = new ArrayList<User>();
		
		for(int i=0; i<listPerformedJob.size(); i++){
			listUserPerformed.add(userBean.findUserById(listPerformedJob.get(i).getIdRequestor()));
		}
		
		for(int i=0; i<listAskedJob.size(); i++){
			listUserRequester.add(userBean.findUserById(listAskedJob.get(i).getIdPerformer()));
		}
		
		request.setAttribute("listUserPerformed", listUserPerformed);
		request.setAttribute("listUserRequester", listUserRequester);
		request.setAttribute("listPerformedJob", listPerformedJob);
		request.setAttribute("listAskedJob", listAskedJob);
		request.setAttribute("listOfAbility", listOfAbility);
		
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userJobsListByOther.jsp"); 
		rd.forward(request,response);
		
	}

}
