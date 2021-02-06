package fr.epsi.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.epsi.dto.FactureDTO;

/*	Classe représentant l'objet Client, avec des attributs d'un type compatible avec ceux de la table client de la database
 *	L'annotation @Entity précise au framework que cette classe est liée à une table de la database
 */

@Entity
public class Facture {

/* 	Annotations déclarant l'attribut id comme clé primaire dans la database, 
 * 	& sa génération automatique par la base de donnée
 */	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String numero;
	private double prix;

// Annotation déclarant une cardinalité 1 - n entre la table Facture & la table LigneFacture
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture", fetch = FetchType.EAGER)
	private List<LigneFacture> lignefacture;
	
// Annotation déclarant une cardinalité n - 1 entre la table Facture & la table Client 	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;	

	public Facture() {}
	
	public Facture(Date date, String n, Client c, List<LigneFacture> lFList) 
	{
		this.date = date;
		this.numero = n;
		this.client = c;
		this.lignefacture = lFList;
		for (LigneFacture ligneFacture : lFList) {
			this.prix += ligneFacture.getPrix();
		}
	}
	
	public Facture(Date date, String n, Client c) 
	{
		this.date = date;
		this.numero = n;
		this.client = c;
	}
	
// Création d'une facture à partir d'une FactureDTO, pour utilisation future depuis un formulaire	
	
	public Facture(FactureDTO f)
	{
		this.id = f.getId();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			this.date = formatter.parse(f.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.numero = f.getNumero();
		this.prix = f.getPrix();
		this.client = new Client (f.getClient());
	}
	
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
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<LigneFacture> getLignesFacture() {
		return lignefacture;
	}

	public void setLignesFacture(List<LigneFacture> lFac) {
		this.lignefacture = lFac;
	}
}
