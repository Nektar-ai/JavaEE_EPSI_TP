package fr.epsi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.epsi.dto.ClientDTO;

/* 	Classe repr�sentant l'objet Client, avec des attributs d'un type compatible avec ceux de la table client de la DataBase
 *	L'annotation @Entity pr�cise au framework que cette classe est li�e � une table de la database
 */

@Entity
public class Client {

/* 	Annotations d�clarant l'attribut id comme cl� primaire dans la database, 
 * 	& sa g�n�ration automatique par la base de donn�e
 */
	
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
