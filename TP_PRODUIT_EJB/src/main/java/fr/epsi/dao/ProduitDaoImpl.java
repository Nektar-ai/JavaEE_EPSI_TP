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
import fr.epsi.entity.Produit;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProduitDaoImpl implements ProduitDao {
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public ProduitDaoImpl() { }
	
	public ProduitDaoImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}
	
	public void create(Produit v) {
		try {
			utx.begin();
			em.persist(v);
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produit> getListeProduit()
	{
		List<Produit> listProd = new ArrayList<Produit>();		
		listProd = em.createQuery("SELECT p FROM Produit p ORDER BY p.nom").getResultList();
		return listProd;
	}
}
