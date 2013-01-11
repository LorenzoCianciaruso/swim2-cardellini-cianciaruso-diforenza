package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbilityRequest;
import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
import it.polimi.swimv2.entities.AbilityRequest;
import it.polimi.swimv2.entities.Friendship;
import it.polimi.swimv2.entities.FriendshipRequest;
import it.polimi.swimv2.entities.JobRequest;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBanUser
 */
public class ServletBanUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("abilityDeclaredBean");
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		IAbilityRequest abilityRequestBean = (IAbilityRequest) JNDILookupClass.doLookup("AbilityRequestBean");
		IJobRequest jobRequestBean = (IJobRequest) JNDILookupClass.doLookup("JobRequestBean");
		
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		
		//removes all user's friendships
		List<Friendship> friendList = friendshipBean.findByUserId(idUser);
		for(int i=0; i<friendList.size(); i++){
			friendshipBean.remove(friendList.get(i).getId());
		}
		
		//removes all friendship requests
		List<FriendshipRequest> frReqPerformerList = friendshipRequestBean.findByPerformerId(idUser);
		List<FriendshipRequest> frReqRequestorList = friendshipRequestBean.findByRequestorId(idUser);
		
		for(int i=0; i < frReqPerformerList.size(); i++){
			friendshipRequestBean.remove(frReqPerformerList.get(i).getId());
		}
		
		for(int i=0; i < frReqRequestorList.size();  i++){
			frReqRequestorList.remove(frReqRequestorList.get(i).getId());
		}
		
		// removes abilityRequests
		List<AbilityRequest> abilityReqList = abilityRequestBean.findByUserId(idUser);
		
		for(int i=0; i < abilityReqList.size(); i++){
			abilityReqList.remove(abilityReqList.get(i).getId());
		}
		
		//removes jobRequests
		List<JobRequest> jobRequestPerformerList = jobRequestBean.findJobRequestByPerformer(idUser);
		List<JobRequest> jobRequestRequestorList = jobRequestBean.findJobRequestByRequestor(idUser);
		
		for(int i = 0; i < jobRequestPerformerList.size() ; i++){
			jobRequestPerformerList.remove(jobRequestPerformerList.get(i).getId());
		}
		
		for(int i = 0; i < jobRequestRequestorList.size() ; i++){
			jobRequestRequestorList.remove(jobRequestRequestorList.get(i).getId());
		}
		
		
		//removes ablitiesdeclared
		List<AbilityDeclared> abDeclList = abilityDeclaredBean.findByUserId(idUser);
		
		for(int i = 0; i < abDeclList.size(); i++){
			abDeclList.remove(abDeclList.get(i).getId());
		}
		
		//removes user
		userBean.remove(idUser);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/adminProfile.jsp"); 
		rd.forward(request,response);
	

		
	}

}
