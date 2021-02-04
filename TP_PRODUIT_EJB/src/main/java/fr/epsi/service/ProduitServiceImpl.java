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
import fr.epsi.dto.ProduitDTO;
import fr.epsi.entity.Produit;

@Stateless
public class ProduitServiceImpl implements ProduitService {

	@EJB
	ProduitDao dao = new ProduitDaoImpl();
	
	public void create(ProduitDTO pDTO)  
	{
		Produit p = new Produit(pDTO);
		
		dao.create(p);
	}
	
	public List<Produit> getListeProduit()
	{
		return dao.getListeProduit();
	}
	
	public Produit findProductByName(String n)
	{
		List<Produit> list = getListeProduit();
		System.out.println(" !\nTaille de la liste : "+list.size());
		for (Produit produit : list) {
			System.out.println("Nom produit dans service : "+produit.getNom());
			if (produit.getNom().equals(n))
			{
				System.out.println("IF is ON !!");
				System.out.println("paramètre fonction dans service: "+n);
				System.out.println("Nom produit dans service : "+produit.getNom());
				return produit;
			}
		}
		return null;
	}
}
