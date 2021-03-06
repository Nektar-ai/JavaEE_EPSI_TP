package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.epsi.dto.ProduitDTO;
import fr.epsi.entity.Produit;
import fr.epsi.repository.ProduitRepository;
import fr.epsi.repository.ProduitRepositoryImpl;

@Stateless
public class ProduitServiceImpl implements ProduitService {

// Injection de d�pendance d'un objet la classe repository s'occupant de la persistence pour les objets Client	
	
	@EJB
	ProduitRepository dao = new ProduitRepositoryImpl();
	
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
		for (Produit produit : list) {
			if (produit.getNom().equals(n))
			{
				return produit;
			}
		}
		return null;
	}
}
