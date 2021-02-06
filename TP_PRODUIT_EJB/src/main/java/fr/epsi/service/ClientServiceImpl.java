package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.epsi.dto.ClientDTO;
import fr.epsi.entity.Client;
import fr.epsi.repository.ClientRepository;
import fr.epsi.repository.ClientRepositoryImpl;

@Stateless
public class ClientServiceImpl implements ClientService {
	
// Injection de dépendance d'un objet la classe repository s'occupant de la persistence pour les objets Client	
	
	@EJB
	ClientRepository dao = new ClientRepositoryImpl();
	
// Création d'un objet Client, à partir de l'objet ClientDTO récupéré depuis le Controller
	
	public void create(ClientDTO cDTO)  
	{
		Client c = new Client(cDTO);
		dao.create(c);
	
	}
	
	public List<Client> getListeClient()
	{		
		return dao.getListeClient();
	}

/* 	Création d'une liste d'objets ClientDTO à partir d'une liste d'objets Client, 
 * 	afin d'éviter d'envoyer des objets Clients au Controller, et donc à la Vue
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
