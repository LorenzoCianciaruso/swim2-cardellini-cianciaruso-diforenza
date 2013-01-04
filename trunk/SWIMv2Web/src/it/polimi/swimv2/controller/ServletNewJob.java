package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletNewJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		
    		//create a new Session Bean
    		IJobRequest bean = (IJobRequest) JNDILookupClass.doLookup("JobRequestBean");
    		
    		//TODO carde controlla che con session funzioni tutto
    		//in realt� non so fare niente ti aspetto
    		
    		//get info and create new entity
    		String idPerformer = request.getParameter("email");
    		String password = request.getParameter("password");
    		String confirmPassword = request.getParameter("confirmPassword");
    		String name = request.getParameter("name");
    		String surname = request.getParameter("surname");
    		String phone = request.getParameter("phone");
    		String birthday = request.getParameter("birthday");
    		String city = request.getParameter("city");
    		
    		//if user doesn't fill an input or the passwords don't match forward to the fail page
    		if(email.equals("") || password.equals("") || confirmPassword.equals("") || name.equals("") || surname.equals("") || 
    										phone.equals("") || birthday.equals("") || city.equals("") || !(password.equals(confirmPassword)) )
    		{
    			response.sendRedirect(response.encodeRedirectURL("loginFail.jsp"));
    			
    		}else{
    			
    			//create a new user 
    			User u = new User();
    		
    			u.setEmail(email);
    			u.setPassword(password);
    			u.setName(name);
    			u.setSurname(surname);
    			u.setPhone(phone);
    			u.setBirthday(birthday);
    			u.setCity(city);
    		
    			//save the entity created in the DataBase
    			bean.saveUser(u);
    		
    			//redirect to the registrationOkPage
    			int id = bean.findUserByLogin(u).getId();
    			HttpSession session = request.getSession(true);
    			session.setAttribute("id", id);
    			
    			ServletContext sc = getServletContext(); 
    			RequestDispatcher rd = sc.getRequestDispatcher("/registrationOKPage.jsp"); 
    			rd.forward(request,response);

    		}
    		
    	}

	}

}