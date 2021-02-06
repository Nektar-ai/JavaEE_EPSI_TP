package fr.epsi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneFacture {
	
/* 	Annotations déclarant l'attribut id comme clé primaire dans la database, 
 * 	& sa génération automatique par la base de donnée
 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int qte;
	private double prix;

// Annotation déclarant une cardinalité n - 1 entre la table LigneFacture & la table Facture	
	
	@ManyToOne	
	private Facture facture;
	
// Annotation déclarant une cardinalité n - 1 entre la table LigneFacture & la table Produit	
	
	@ManyToOne
	private Produit produit;
	
	public LigneFacture() {}

	public LigneFacture(Produit p, int qte) 
	{
		this.produit = p;
		this.qte = qte;
		this.prix = p.getPrix() * qte;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Facture getFacture() {
		return facture;
	}

// Méthode permettant d'initialiser la clé étrangère facture_id dans la table LigneFacture	
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}
