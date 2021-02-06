package fr.epsi.repository;

import java.util.List;

import fr.epsi.entity.Client;
import fr.epsi.entity.Facture;

public interface ClientRepository 
{
	void create(Client v);
	public List<Client> getListeClient();	
}
