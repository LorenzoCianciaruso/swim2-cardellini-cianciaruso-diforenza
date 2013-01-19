package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IMessage;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Message;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSendMessage
 */
public class ServletSendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMessage messageBean = (IMessage) JNDILookupClass.doLookup("MessageBean");
		
		Message message = new Message();
		
		message.setIdJob(Integer.parseInt(request.getParameter("idJob")));
		message.setIdUser(Integer.parseInt(request.getParameter("idUser")));
		message.setMessage(request.getParameter("message"));
		
		messageBean.save(message);
		
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletJobsPage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	
	}

}
