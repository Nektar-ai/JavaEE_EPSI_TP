package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.dto.ClientDTO;
import fr.epsi.service.ClientService;

// Annotation déclarant la route pour laquelle la Servlet va traiter les différentes methodes HTTP (GET, POST, PUT, etc...)

@WebServlet("/clientform")
public class ClientServletForm extends HttpServlet {

// Injection de dépendance d'un objet ClientService	de la couche service
	
	@EJB 
	ClientService service;
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/FormulaireClient.jsp").forward(req, resp);
        }
	
 // Methode doPost récupérant les champs du formulaire de la page .jsp, afin de construire un objet DTO    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		String nom = req.getParameter("nomClient");
    		String adresse = req.getParameter("adresseClient");
    		ClientDTO c = new ClientDTO(nom, adresse);
    		service.create(c);
    		resp.sendRedirect("/TP_PRODUIT_EJB-0.0.1-SNAPSHOT/clientliste");
        }
}
