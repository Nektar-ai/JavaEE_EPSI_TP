package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.epsi.dao.FactureDao;
import fr.epsi.dao.FactureDaoImpl;
import fr.epsi.dto.FactureDTO;
import fr.epsi.entity.Facture;
import fr.epsi.entity.Produit;

@Stateless
public class FactureServiceImpl implements FactureService {

// Injection de dépendance d'un objet la classe repository s'occupant de la persistence pour les objets Facture		
	
	@EJB
	FactureDao dao = new FactureDaoImpl();
	
	public List<Facture> getListeFacture()
	{		
		return dao.getListeFacture();
	}
	
	/* 	Création d'une liste d'objets FactureDTO à partir d'une liste d'objets Client, 
	 * 	afin d'éviter d'envoyer des objets Factures au Controller, et donc à la Vue
	 */
	
	public List<FactureDTO> getListeFactureDTO()
	{
		List<FactureDTO> fListDTO = new ArrayList<FactureDTO>();
		for (Facture f : dao.getListeFacture()) 
		{
			FactureDTO fDTO = new FactureDTO(f);
			fListDTO.add(fDTO);
		}
		return fListDTO;
	}
	
	public FactureDTO getFactureByNum(String nom) {
		
		Facture f = dao.getFactureByNum(nom);
		FactureDTO fDTO = new FactureDTO(f);
//		System.out.println(" !\nTaille de la liste : "+list.size());
		
//		for (Produit produit : list) {
//			System.out.println("Nom produit dans service : "+produit.getNom());
			if (fDTO.getNumero().equals(nom))
			{
//				System.out.println("IF is ON !!");
//				System.out.println("paramètre fonction dans service: "+nom);
//				System.out.println("Nom produit dans service : "+produit.getNom());
				return fDTO;
			}
		return null;
	}
	
}
