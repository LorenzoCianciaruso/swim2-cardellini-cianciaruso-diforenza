package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// manage registration to the site
public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// create a new Session Bean
		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		// get info from page
		String email = request.getParameter("registrationEmail");
		String password = request.getParameter("registrationPassword");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");
		
		//check if exist an user with the same email
		User user = bean.findUserByLogin(email);

		// if the mail already exist forward to 
		// the fail page
		// check again also the values checked by the script just to be sure
		if (email==null || email ==""||
			password==null || password ==""||
			name==null || name ==""||
			surname==null || surname ==""||
			phone==null || phone ==""||
			birthday==null || birthday ==""||	
			city==null || city ==""||	
			!checkDate(birthday)||user!=null) {			
			
			request.setAttribute("message", "The mail already exist or you haven't fill all fields in the form");
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/messageFail.jsp");
			rd.forward(request, response);

		} else {

			// create a new user with given information
			User u = new User();

			u.setEmail(email);
			u.setPassword(password);
			u.setName(name);
			u.setSurname(surname);
			u.setPhone(phone);
			u.setBirthday(birthday);
			u.setCity(city);

			// save the entity
			bean.save(u);

			// redirect to the registrationOkPage
			int id = bean.findUserByLogin(email).getId();
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);

			ServletContext sc = getServletContext();
			request.setAttribute("next", "ServletProfilePage");
			RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
			rd.forward(request, response);

		}

	}

	public static boolean checkDate(String input) {
		String regex = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)[0-9][0-9]";
		if (Pattern.matches(regex, input))
			return true;
		else
			return false;
	}
}
