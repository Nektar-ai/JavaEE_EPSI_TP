package fr.epsi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.epsi.dto.ClientDTO;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	
	public Client() {}
	
	public Client (String n, String a) 
	{
		this.nom = n;
		this.adresse = a;
	}
	
	public Client (ClientDTO c) 
	{
		this.nom = c.getNom();
		this.adresse = c.getAdresse();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String n) 
	{
		this.nom = n;
	}
	
	public String getAdresse() 
	{
		return adresse;
	}
	
	public void setAdresse(String a) 
	{
		this.adresse = a;
	}
	
}
