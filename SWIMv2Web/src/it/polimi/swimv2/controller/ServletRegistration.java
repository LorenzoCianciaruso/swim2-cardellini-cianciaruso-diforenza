package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDIUserLookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// manage registration to the site
public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//create a new Session Bean
		IUser bean = JNDIUserLookupClass.doLookup();
		
		//get info and create new entity
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");
		
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
		//TODO forward to the profile.jsp
		response.sendRedirect(response.encodeRedirectURL("registrationOKPage.jsp"));
		
	}

}
