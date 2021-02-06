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
	
// Injection de d�pendance d'un objet la classe repository s'occupant de la persistence pour les objets Client	
	
	@EJB
	ClientRepository dao = new ClientRepositoryImpl();
	
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
