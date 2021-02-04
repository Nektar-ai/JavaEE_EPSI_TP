package fr.epsi.dao;

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

/* 	Classe Repr�sentant la couche repository pour l'entit� Facture
 *	Ainsi q'une annotation pr�cisant au framework que cette classe fait autorit� de transaction
 */	
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureDaoImpl implements FactureDao {
	
// D�claration du contexte de persistence comme pr�cis� dans le persistence.xml
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public FactureDaoImpl() {}
	
// M�thode r�cup�rant la liste des Factures d�j� pr�sentes dans la database	
	
	public List<Facture> getListeFacture()
	{		
		List<Facture> listFac = new ArrayList<Facture>();
		listFac = em.createQuery("SELECT f FROM Facture f ORDER BY f.id").getResultList();
		return listFac;		
	}

// M�thodes recherchant une ou des Facture dans la database, avec un numero de facture pass� en param�tre
	
	public Facture getFactureByNum(String n)
	{		
		Facture f1 = new Facture();		
		System.out.println("Numero Facture param�tre :"+n);
		f1 = (Facture) em.createQuery("SELECT f FROM Facture f WHERE f.numero = :n", Facture.class)
				.setParameter("n", n)
				.getSingleResult();		
		return f1;
	}

	public List<Facture> getFactureByNumList(String n)
	{		
		List<Facture> f = new ArrayList<Facture>();		
		f = em.createQuery("SELECT f FROM Facture f WHERE f.numero = :n", Facture.class)
				.setParameter("n", n)
				.getResultList();		
		return f;
	}
}
