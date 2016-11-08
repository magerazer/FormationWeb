package fr.demos.formation.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEnteteHTTP
 */
@WebServlet("/AfficheEnteteHTTP")
public class AfficheEnteteHTTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEnteteHTTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		Enumeration<String> noms = request.getHeaderNames();
		while(noms.hasMoreElements()) {
			String nom = noms.nextElement();
			String valeur = request.getHeader(nom);
			out.println(nom + "  =  " + valeur);
			out.println("<br>");
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("/enteteVue.jsp");
		//rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
