package fr.epsi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.epsi.dto.FactureDTO;
import fr.epsi.entity.Facture;
import fr.epsi.entity.LigneFacture;
import fr.epsi.entity.Produit;
import fr.epsi.repository.FactureRepository;
import fr.epsi.repository.FactureRepositoryImpl;

@Stateless
public class FactureServiceImpl implements FactureService {

// Injection de d�pendance d'un objet la classe repository pour Facture s'occupant de la persistence pour les objets Facture		
	
	@EJB
	FactureRepository dao = new FactureRepositoryImpl();

// Injection de d�pendance du service pour les objets la classe Client pour la g�n�ration d'une DummyFacture pour les tests dev	
	
	@EJB
	ClientService serviceclient;

// Injection de d�pendance du service pour les objets la classe Produit pour l'initialisation des LignesFacture
	
	@EJB
	ProduitService serviceprod;
	
	public List<Facture> getListeFacture()
	{		
		return dao.getListeFacture();
	}
	
/* 	Cr�ation d'une liste d'objets FactureDTO � partir d'une liste d'objets Client, 
 * 	afin d'�viter d'envoyer des objets Factures au Controller, et donc � la Vue
 */
	
	public void create (Facture f) 
	{
		dao.create(f);
	}
	
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
	
// Cr�ation d'une facture test, n'ayant pas de formulaire facture sur le site
	
	public Facture getDummyFacture()
	{		
		List<Produit> prodList = serviceprod.getListeProduit();
		List<LigneFacture> lFList = new ArrayList<LigneFacture>();
		for (Produit produit : prodList) {
			LigneFacture lF = new LigneFacture(produit, 2);
			lFList.add(lF);
		}
		Facture f = new Facture(new Date(), "F004", serviceclient.getListeClient().get(0), lFList);
		for (LigneFacture lF : lFList) {
			lF.setFacture(f);
		}		
		
		return f;
	}
	
// R�cup�ration d'une facture dans la database depuis le repository, par num�ro de facture 	
	
	public Facture getFactureByNum(String num) {
		
		Facture f = dao.getFactureByNum(num);
		FactureDTO fDTO = new FactureDTO(f);

		if (f.getNumero().equals(num))
		{
			return f;
		}
		return null;
	}
	
// Initialisation de la liste de LigneFacture dans 	un objet Facture
	
	public void setListeLigneFacture(Facture f, List<LigneFacture> lFList)
	{
		f.setLignesFacture(lFList);
	}

//* R�cup�ration des LigneFacture dans la database par ID d'une Facture 
	
	public List<LigneFacture> getLigneFactureByFacId(Long id)
	{
		List<LigneFacture> lFList = dao.getLigneFactureByFacId(id);
		return lFList;
	}
	
}
