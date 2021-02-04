package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.dto.ProduitDTO;
import fr.epsi.service.ProduitService;

@WebServlet("/produitform")
public class ProduitServletForm extends HttpServlet {

	@EJB 
	ProduitService service;
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/FormulaireProduit.jsp").forward(req, resp);
    }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
		String nom = req.getParameter("nomProduit");
		String codeBarre = req.getParameter("codeBarre");
		String prix = req.getParameter("prix");
		ProduitDTO p = new ProduitDTO(nom, codeBarre, prix);
		service.create(p);
		resp.sendRedirect("/TP_PRODUIT_EJB-0.0.1-SNAPSHOT/produitliste");
    }

}
