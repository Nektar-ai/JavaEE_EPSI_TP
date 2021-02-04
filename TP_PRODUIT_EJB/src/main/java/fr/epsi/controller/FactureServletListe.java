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

@WebServlet("/factureliste")
public class FactureServletListe extends HttpServlet {

	@EJB 
	FactureService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
    {
		List<FactureDTO> listFac = new ArrayList<FactureDTO>();
		listFac = service.getListeFactureDTO();
		req.setAttribute("listeFacture", listFac);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ListeFacture.jsp").forward(req, resp);
    }
}
 