package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ProduitDao;
import fr.epsi.dao.ProduitDaoImpl;
import fr.epsi.dto.ClientDTO;
import fr.epsi.dto.ProduitDTO;
import fr.epsi.entity.Client;
import fr.epsi.entity.Produit;

@Stateless
public class ProduitServiceImpl implements ProduitService {

// Injection de d�pendance d'un objet la classe repository s'occupant de la persistence pour les objets Client	
	
	@EJB
	ProduitDao dao = new ProduitDaoImpl();
	
// Cr�ation d'un objet Produit, � partir de l'objet ProduitDTO r�cup�r� depuis le Controller	
	
	public void create(ProduitDTO pDTO)  
	{
		Produit p = new Produit(pDTO);	
		dao.create(p);
	}
	
	public List<Produit> getListeProduit()
	{
		return dao.getListeProduit();
	}
	
/* 	Cr�ation d'une liste d'objets ProduitDTO � partir d'une liste d'objets Produit, 
 * 	afin d'�viter d'envoyer des objets Produit au Controller, et donc � la Vue
 */		
	
	public List<ProduitDTO> getListeProduitDTO()
	{
		List<ProduitDTO> listProduitDTO= new ArrayList<ProduitDTO>();
		for (Produit c : dao.getListeProduit()) 
		{
			ProduitDTO pDTO = new ProduitDTO(c);
			listProduitDTO.add(pDTO);
		}
		return listProduitDTO;
	}
	
// M�thode permettant de r�cup�rer dans la database un objet Produit, en le recherchant par son champ nom	
	
	public Produit findProductByName(String n)
	{
		List<Produit> list = getListeProduit();
		System.out.println(" !\nTaille de la liste : "+list.size());
		for (Produit produit : list) {
			System.out.println("Nom produit dans service : "+produit.getNom());
			if (produit.getNom().equals(n))
			{
				System.out.println("IF is ON !!");
				System.out.println("param�tre fonction dans service: "+n);
				System.out.println("Nom produit dans service : "+produit.getNom());
				return produit;
			}
		}
		return null;
	}
}
