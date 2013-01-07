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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");

		// if user doesn't fill an input or the passwords don't match forward to
		// the fail page
		if (email.equals("") || password.equals("")
				|| confirmPassword.equals("") || name.equals("")
				|| surname.equals("") || phone.equals("")
				|| city.equals("")
				|| !(password.equals(confirmPassword)) || !checkDate(birthday)) {
			response.sendRedirect(response.encodeRedirectURL("loginFail.jsp"));

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
			bean.saveUser(u);

			// redirect to the registrationOkPage
			int id = bean.findUserByLogin(u).getId();
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);

			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/done.jsp");
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
