package fr.demos.formation.web;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaisieInscription
 */
@WebServlet("/SaisieInscription")
public class SaisieInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaisieInscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null && action.equals("Deconnexion")) {
			
			request.getSession().invalidate();
			
		}		
		
		ArrayList<String> listePays = new ArrayList<>();
		listePays.add("France");
		listePays.add("TrumpLand");
		listePays.add("Suisse");
		listePays.add("Canada");
		request.setAttribute("listePays", listePays);

		LocalTime time = LocalTime.now();
		HttpSession session = request.getSession();
		if (session.getAttribute("heureConnexion") == null) {
			session.setAttribute("heureConnexion", time);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/SaisieInscription.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pays;
		pays = request.getParameter("pays");

		List<String> erreursList = new ArrayList<String>();
		Map<String, String> erreurs = new HashMap<String, String>();

		String action = request.getParameter("valider");
		if (action != null && action.equals("Valider")) {

			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String ageString = request.getParameter("age");

			String message = "";

			int age = 0;

			try {
				age = Integer.parseInt(ageString);
			} catch (NumberFormatException ex) {
				erreursList.add("L âge entre n est pas au bon format");
				erreurs.put("age", "Le format de l'âge n'est pas le bon");
			}

			if (nom == null || nom.equals("")) {
				erreursList.add("Vous devez saisir un nom");
				erreurs.put("nom", "Le nom n'a pas été saisi");
			}
			if (age < 0) {
				erreursList.add("L age ne peut pas etre negatif");
				erreurs.put("age", "L'age ne peut pas etre negatif");
			}

			request.setAttribute("erreurs", erreurs);
			request.setAttribute("erreursList", erreursList);

			request.setAttribute("pays", pays);

			if (!erreurs.isEmpty()) {

				message = "Formulaire non valide";
				request.setAttribute("message", message);

				RequestDispatcher rd = request.getRequestDispatcher("/SaisieInscription.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);
				request.setAttribute("age", age);

				message = "Saisie correcte";
				request.setAttribute("message", message);

				RequestDispatcher rd = request.getRequestDispatcher("/Ok.jsp");
				rd.forward(request, response);
			}
		}

	}

}
