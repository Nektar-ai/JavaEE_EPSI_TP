package fr.epsi.repository;

import java.util.List;
import fr.epsi.entity.Client;

public interface ClientRepository 
{
	void create(Client v);
	public List<Client> getListeClient();
	public Client getClientByNom(String n);
}
