package fr.epsi.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.epsi.dto.ProduitDTO;

/* 	Classe repr�sentant l'objet Produit, avec des attributs d'un type compatible avec ceux de la table client de la DataBase
 *	L'annotation @Entity pr�cise au framework que cette classe est li�e � une table de la database
 */

@Entity
public class Produit {

/* 	Annotations d�clarant l'attribut id comme cl� primaire dans la database, 
 * 	& sa g�n�ration automatique par la base de donn�e
 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private double prix;
	private String codeBarre;
	
// Annotation d�clarant une cardinalit� 1 - n entre la table Produit & la table LigneFacture	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.EAGER)
	private List<LigneFacture> lignefacture;

	public Produit() {}
	
	public Produit (String n, String c) 
	{
		this.nom = n;
		this.codeBarre = c;
	}
	
	public Produit (ProduitDTO p) 
	{
		this.nom = p.getNom();
		this.codeBarre = p.getCodeBarre();
		this.prix = Double.valueOf(p.getPrix());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public String getCodeBarre() 
	{
		return codeBarre;
	}
	
	public void setCodeBarre(String codeBarre) 
	{
		this.codeBarre = codeBarre;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public List<LigneFacture> getLignefacs() {
		return lignefacture;
	}

	public void setLignefacs(List<LigneFacture> lignefacs) {
		this.lignefacture = lignefacs;
	}
	
}
