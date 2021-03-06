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
import fr.epsi.entity.Client;

/* 	Classe Repr�sentant la couche repository pour l'entit� Client
	Ainsi q'une annotation pr�cisant au framework que cette classe fait autorit� de transaction
*/
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientRepositoryImpl implements ClientRepository {
	
// D�claration du contexte de persistence comme pr�cis� dans le persistence.xml	
	
	@PersistenceContext(unitName = "produitPU")
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public ClientRepositoryImpl() {}
	
// M�thode permettant de faire persister un objet "Client" dans la database, dans la table du m�me nom
	
	public void create(Client c) {
		try {
			utx.begin();
			em.persist(c);
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// M�thode r�cup�rant la liste des Clients d�j� pr�sents dans la database
	
	public List<Client> getListeClient()
	{		
		List<Client> listClient = new ArrayList<Client>();
		listClient = em.createQuery("SELECT c FROM Client c ORDER BY c.id").getResultList();
		return listClient;		
	}
	
	public Client getClientByNom(String n)
	{
		Client client = (Client)em.createQuery("SELECT c FROM Client c WHERE c.nom = :n")
				.setParameter("n", n)
				.getSingleResult();		
		return client;
	}
	
}
