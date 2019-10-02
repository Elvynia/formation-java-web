package fr.wcs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.wcs.service.UserService;

@WebServlet("/welcome")
public class SuperTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SuperTestServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SuperTestServlet.LOGGER
				.info("L'utilisateur à demandé la page index.jsp");
		req.setAttribute("welcome", "Bienvenue dans ma super appli");
		User me = new User("jmasson", 29,
				"jeremy.masson@wildcodeschool.fr");
		req.setAttribute("user", me);
		// Passer la liste des utilisateurs à la JSP.
		req.setAttribute("userList", UserService.USERS);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/index.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Récupération des paramètres.
		String name = req.getParameter("user_name");
		String strAge = req.getParameter("user_age");
		String email = req.getParameter("user_email");

		// Valide les paramètres récupérés.
		boolean formOk = true;
		if (name.isEmpty() || name.isBlank() || !strAge.matches("[0-9]+")
				|| email.isEmpty() || email.isBlank()) {
			formOk = false;
		}
		// Ajout de l'utilisateur dans la liste du service.
		User newUser = new User(name, Integer.parseInt(strAge), email);
		UserService.addUser(newUser);
		
		// Passer l'information à la confirm.jsp.
		req.setAttribute("ok", formOk);
		// On donne une réponse à la requête.
		LOGGER.debug("Paramètres reçus du formulaire : {} {} {} !", name,
				strAge, email);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/confirm.jsp")
				.forward(req, resp);
	}

}
