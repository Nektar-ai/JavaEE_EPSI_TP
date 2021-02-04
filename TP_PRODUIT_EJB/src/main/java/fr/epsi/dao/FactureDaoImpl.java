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

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureDaoImpl implements FactureDao {
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public FactureDaoImpl() {}
	
	public List<Facture> getListeFacture()
	{		
		List<Facture> listFac = new ArrayList<Facture>();
		listFac = em.createQuery("SELECT f FROM Facture f ORDER BY f.id").getResultList();
		return listFac;		
	}
}
