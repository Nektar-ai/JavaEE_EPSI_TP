package fr.epsi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*	Classe repr�sentant l'objet Client, avec des attributs d'un type compatible avec ceux de la table client de la database
 *	L'annotation @Entity pr�cise au framework que cette classe est li�e � une table de la database
 */

@Entity
public class Facture {

/* 	Annotations d�clarant l'attribut id comme cl� primaire dans la database, 
 * 	& sa g�n�ration automatique par la base de donn�e
 */	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String numero;
	private double prix;

// Annotation d�clarant une cardinalit� 1 - n entre la table Facture & la table Produit
	
	@OneToMany(mappedBy = "facture" ,cascade = CascadeType.ALL)
	private List<Produit> produits = new ArrayList<Produit>();
	
// Annotation d�clarant une cardinalit� n - 1 entre la table Facture & la table Client	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public String getNumero() 
	{
		return numero;
	}
	
	public void setNumero(String numero) 
	{
		this.numero = numero;
	}
	
	public double getPrix() 
	{
		return prix;
	}
	
	public void setPrix(double prix) 
	{
		this.prix = prix;
	}
	
	public Client getClient() 
	{
		return client;
	}
	
	public void setClient(Client client) 
	{
		this.client = client;
	}
}
