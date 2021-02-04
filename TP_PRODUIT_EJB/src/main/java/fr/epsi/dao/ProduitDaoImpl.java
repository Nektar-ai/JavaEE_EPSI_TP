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

/* 	Classe Repr�sentant la couche repository pour l'entit� Produit
 *	Ainsi q'une annotation pr�cisant au framework que cette classe fait autorit� de transaction
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProduitDaoImpl implements ProduitDao {
	
// D�claration du contexte de persistence comme pr�cis� dans le persistence.xml	
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public ProduitDaoImpl() { }
	
// M�thode permettant de faire persister un objet "Produit" dans la database, dans la table du m�me nom	
	
	public void create(Produit v) {
		try {
			utx.begin();
			em.persist(v);
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// M�thode r�cup�rant la liste des Produits d�j� pr�sents dans la database	
	
	public List<Produit> getListeProduit()
	{
		List<Produit> listProd = new ArrayList<Produit>();		
		listProd = em.createQuery("SELECT p FROM Produit p ORDER BY p.nom").getResultList();
		return listProd;
	}
}
