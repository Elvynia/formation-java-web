package fr.wcs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/")
public class SuperTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SuperTestServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SuperTestServlet.LOGGER.info("L'utilisateur à demandé la page index.jsp");
		req.setAttribute("welcome", "Bienvenue dans ma super appli");
		User me = new User("jmasson", 29, "jeremy.masson@wildcodeschool.fr");
		req.setAttribute("user", me);
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/index.jsp")
			.forward(req, resp);
	}
}
