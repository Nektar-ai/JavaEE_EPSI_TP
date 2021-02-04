package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entity.Produit;
import fr.epsi.service.ProduitService;

@WebServlet("/produitdetail")
public class ProduitDetailServlet extends HttpServlet {

	@EJB
	private ProduitService service;
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String nom=req.getParameter("nom");		
		Produit produit = service.findProductByName(nom);
		String bro = produit != null ? produit.getNom() : "Produit non trouvé";
//		System.out.println("paramètre fonction dans servlet : "+nom);
//		System.out.println("Nom produit dans servlet : "+bro);
		req.setAttribute("produit", produit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/DetailProduit.jsp").forward(req, resp);
	}
}
