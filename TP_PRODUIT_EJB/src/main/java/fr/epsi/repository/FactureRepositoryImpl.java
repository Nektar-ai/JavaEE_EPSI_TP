package fr.epsi.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import fr.epsi.entity.Facture;
import fr.epsi.entity.LigneFacture;

/* 	Classe Représentant la couche repository pour l'entité Facture
 *	Ainsi q'une annotation précisant au framework que cette classe fait autorité de transaction
 */	
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureRepositoryImpl implements FactureRepository {
	
// Déclaration du contexte de persistence comme précisé dans le persistence.xml
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public FactureRepositoryImpl() {}
	
// Méthode récupérant la liste des Factures déjà présentes dans la database	
	
	public List<Facture> getListeFacture()
	{		
		List<Facture> listFac = new ArrayList<Facture>();
		listFac = em.createQuery("SELECT f FROM Facture f ORDER BY f.id").getResultList();
		return listFac;		
	}

// Méthodes recherchant une ou des Facture dans la database, avec un numero de facture passé en paramètre
	
	public void create(Facture f) {
		try {
			utx.begin();
			em.merge(f);
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Récupération d'une facture dans la database par le numéro de la Facture
	
	public Facture getFactureByNum(String n)
	{		
		Facture f1 = new Facture();		
		f1 = (Facture) em.createQuery("SELECT MIN(f) FROM Facture f WHERE f.numero = :n", Facture.class)
				.setParameter("n", n)
				.getSingleResult();		
		return f1;
	}
	
// Récupération dans la database des LigneFacture par la clé étrangère facture_id	
	
	public List<LigneFacture> getLigneFactureByFacId(Long id)
	{
		List<LigneFacture> lFList;
		lFList = em.createQuery("SELECT l FROM LigneFacture l WHERE l.facture.id = :id", LigneFacture.class)
				.setParameter("id", id)
				.getResultList();
		return lFList;
	}
}
