package fr.epsi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.epsi.dto.FactureDTO;
import fr.epsi.service.FactureService;
import fr.epsi.service.ProduitService;

// Annotation déclarant la route pour laquelle la Servlet va traiter les différentes methodes HTTP (GET, POST, PUT, etc...)

@WebServlet("/factureliste")
public class FactureServletListe extends HttpServlet {

// Injection de dépendance d'un objet FactureService de la couche service	
	
	@EJB 
	FactureService service;
	
	@EJB
	ProduitService serviceprod;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
    {
		FactureDTO test = new FactureDTO(service.getDummyFacture());
		service.create(test);
		List<FactureDTO> listFac = new ArrayList<FactureDTO>();		
		listFac = service.getListeFactureDTO();		

		req.setAttribute("listeFacture", listFac);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ListeFacture.jsp").forward(req, resp);
    }
}
