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
import fr.epsi.entity.Client;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientDaoImpl implements ClientDao {
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public ClientDaoImpl() {}
	
	public ClientDaoImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}
	
	public void create(Client c) {
		try {
			utx.begin();
			em.persist(c);
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Client> getListeClient()
	{		
		List<Client> listClient = new ArrayList<Client>();
		listClient = em.createQuery("SELECT c FROM Client c ORDER BY c.id").getResultList();
		return listClient;		
	}
}
