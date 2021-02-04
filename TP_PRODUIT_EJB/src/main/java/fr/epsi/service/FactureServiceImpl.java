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

// Injection de d�pendance d'un objet la classe repository s'occupant de la persistence pour les objets Facture		
	
	@EJB
	FactureDao dao = new FactureDaoImpl();
	
	public List<Facture> getListeFacture()
	{		
		return dao.getListeFacture();
	}
	
	/* 	Cr�ation d'une liste d'objets FactureDTO � partir d'une liste d'objets Client, 
	 * 	afin d'�viter d'envoyer des objets Factures au Controller, et donc � la Vue
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
	
	public FactureDTO getFactureByNum(String num) {
		
		Facture f = dao.getFactureByNum(num);
		FactureDTO fDTO = new FactureDTO(f);

		if (fDTO.getNumero().equals(num))
		{
			return fDTO;
		}
		return null;
	}
}
