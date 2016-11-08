package fr.demos.formation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		RequestDispatcher rd = request.getRequestDispatcher("/SaisieInscription.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("valider");
		if (action != null && action.equals("Valider")) {

			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String ageString = request.getParameter("age");

			String erreur;
			
			int age = 0;

			try {
				age = Integer.parseInt(ageString);
			} catch (NumberFormatException ex) {

			}

			if (nom == null || nom.equals("")) {
				erreur = "Vous devez saisir un nom";
				request.setAttribute("erreur", erreur);
				
				RequestDispatcher rd = request.getRequestDispatcher("/SaisieInscription.jsp");
				rd.forward(request, response);
				
			} else {
				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);
				request.setAttribute("age", age);
				RequestDispatcher rd = request.getRequestDispatcher("/Ok.jsp");
				rd.forward(request, response);
			}

		}

	}

}
