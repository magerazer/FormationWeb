package fr.demos.formation.web;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class DemoListener
 *
 */
@WebListener
public class DemoListener implements ServletContextListener, HttpSessionListener {
	
	private Compteur compteur = new Compteur();
	private ArrayList<String> liste = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public DemoListener() {
        // TODO Auto-generated constructor stub
    }
	
    // création de session (request.getSession() la premiere fois)
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	LocalTime time = LocalTime.now();		
		arg0.getSession().setAttribute("heureConnexion", time);
		// compteur++
		compteur.incremente();
		liste.add("create");
		
    }

    // timout de session ou session.invalidate()
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	// compteur--
    	compteur.decremente();    	
    	liste.add("destroy");
    }

    // arrêt de l'appli (arrêt de Tomcat)
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
    // démarrage de l'appli (démarrage de Tomcat)
    public void contextInitialized(ServletContextEvent arg0)  { 
        // compteur à 0
    	
    	liste.add("un");
    	arg0.getServletContext().setAttribute("liste", liste);
    	
    	arg0.getServletContext().setAttribute("compteur", compteur);
    }
	
}
