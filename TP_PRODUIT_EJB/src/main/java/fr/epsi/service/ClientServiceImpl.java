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
import fr.epsi.entity.Client;

@Stateless
public class ClientServiceImpl implements ClientService {
	
	@EJB
	ClientDao dao = new ClientDaoImpl();
	
	public void create(ClientDTO cDTO)  
	{
		Client c = new Client(cDTO);
		dao.create(c);
	
	}
	public List<Client> getListeClient()
	{		
		return dao.getListeClient();
	}
	
	public List<ClientDTO> getListeClientDTO()
	{
		List<ClientDTO> listClientDTO= new ArrayList<ClientDTO>();
		ClientDTO client3 = new ClientDTO("Lars Jenkins", "9 rue fuckface");
		ClientDTO client4 = new ClientDTO("John Cologne", "10 rue du nez");
		listClientDTO.add(client3);
		listClientDTO.add(client4);
		return listClientDTO;
	}
}
