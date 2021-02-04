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

@WebServlet("/clientform")
public class ClientServletForm extends HttpServlet {

	@EJB 
	ClientService service;
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/FormulaireClient.jsp").forward(req, resp);
        }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
        {
    		String nom = req.getParameter("nomClient");
    		String codeBarre = req.getParameter("adresseClient");
    		ClientDTO p = new ClientDTO(nom, codeBarre);
    		service.create(p);
    		resp.sendRedirect("/TP_PRODUIT_EJB-0.0.1-SNAPSHOT/clientliste");
        }
}
