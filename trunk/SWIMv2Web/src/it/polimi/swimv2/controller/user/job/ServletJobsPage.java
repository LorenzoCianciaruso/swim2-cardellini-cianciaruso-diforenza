package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.business.IMessage;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Ability;
import it.polimi.swimv2.entities.Job;
import it.polimi.swimv2.entities.Message;
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


public class ServletJobsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		IJob jobBean = (IJob) JNDILookupClass.doLookup("JobBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IMessage messageBean = (IMessage) JNDILookupClass.doLookup("MessageBean");
		
		List<Job> listPerformedJob = jobBean.findByPerformerId(currentUserId);
		List<Job> listAskedJob = jobBean.findByRequestorId(currentUserId);
		List<Ability> listOfAbility = abilityBean.allAbilities();
		int idUser = (Integer)request.getSession().getAttribute("id");
		
		List<User> listUserPerformed = new ArrayList<User>();
		List<User> listUserRequester = new ArrayList<User>();
		List<Message> listMessagesRequestJob = new ArrayList<Message>();
		List<Message> listMessagesPerformedJob = new ArrayList<Message>();
		
		for(int i=0; i<listPerformedJob.size(); i++){
			listUserPerformed.add(userBean.findUserById(listPerformedJob.get(i).getIdRequestor()));
		}
		
		for(int i=0; i<listAskedJob.size(); i++){
			listUserRequester.add(userBean.findUserById(listAskedJob.get(i).getIdPerformer()));
		}
		
		for(int i=0; i<listAskedJob.size();i++){
			listMessagesRequestJob.addAll(messageBean.searchByIdJob(listAskedJob.get(i).getId()));
		}
		
		for(int i=0; i< listPerformedJob.size();i++){
			listMessagesPerformedJob.addAll(messageBean.searchByIdJob(listPerformedJob.get(i).getId()));
		}
		
		
		request.setAttribute("listUserPerformed", listUserPerformed);
		request.setAttribute("listUserRequester", listUserRequester);
		request.setAttribute("listPerformedJob", listPerformedJob);
		request.setAttribute("listAskedJob", listAskedJob);
		request.setAttribute("listOfAbility", listOfAbility);
		request.setAttribute("listMessagesRequestJob", listMessagesRequestJob);
		request.setAttribute("listMessagesPerformedJob", listMessagesPerformedJob);
		request.setAttribute("user", idUser);

		
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userJobsList.jsp"); 
		rd.forward(request,response);
		
	}

}
