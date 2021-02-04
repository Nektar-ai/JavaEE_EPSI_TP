package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ClientDao;
import fr.epsi.dao.ClientDaoImpl;
import fr.epsi.dto.ClientDTO;
import fr.epsi.dto.FactureDTO;
import fr.epsi.entity.Client;
import fr.epsi.entity.Facture;

@Stateless
public class ClientServiceImpl implements ClientService {
	
// Injection de d�pendance d'un objet la classe repository s'occupant de la persistence pour les objets Client	
	
	@EJB
	ClientDao dao = new ClientDaoImpl();
	
// Cr�ation d'un objet Client, � partir de l'objet ClientDTO r�cup�r� depuis le Controller
	
	public void create(ClientDTO cDTO)  
	{
		Client c = new Client(cDTO);
		dao.create(c);
	
	}
	
	public List<Client> getListeClient()
	{		
		return dao.getListeClient();
	}

/* 	Cr�ation d'une liste d'objets ClientDTO � partir d'une liste d'objets Client, 
 * 	afin d'�viter d'envoyer des objets Clients au Controller, et donc � la Vue
 */	
	
	public List<ClientDTO> getListeClientDTO()
	{
		List<ClientDTO> listClientDTO= new ArrayList<ClientDTO>();
		for (Client c : dao.getListeClient()) 
		{
			ClientDTO cDTO = new ClientDTO(c);
			listClientDTO.add(cDTO);
		}
		return listClientDTO;
	}
}
